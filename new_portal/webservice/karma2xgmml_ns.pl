#!/usr/bin/perl

use strict;

use XML::Simple;
use Graph::Easy;
use Data::Dumper;
use IO::File;
use lib '/var/www/html/portal/uploader/lib';
use NetKarma::XGMML;
use File::Copy;


my $n_hash;
my $links = {};
my @endpoints;
my $i=0;

my $workflow_id = $ARGV[0];
my $exp_id = $ARGV[1];

my $tmp_query = "/tmp/query." . $$;
my $query_res = "/tmp/query_res." . $$;

my $cache_path = "/home/chsmall/git/NetKarma_Portal/new_portal/cache";

my $outfile = $cache_path . "/" . $workflow_id . ".xgmml";

# initialize Graph
my $graph  = Graph::Easy->new();

my $graph_xgmml  = NetKarma::XGMML->new(
      directed => 1,
      OUTPUT   => IO::File->new($outfile, 'w'),
  );

open(QUERY,">$tmp_query") || die "Cant open query file";

#print " Query tmp file : $tmp_query\n";
#print " Query res file : $query_res\n";

print QUERY "<q0:getWorkflowGraphRequest xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:q0=\"http://www.dataandsearch.org/karma/query/2010/10/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">
 <q0:workflowID>$workflow_id</q0:workflowID>
 <q0:format>OPM</q0:format>
 <q0:informationDetailLevel>FINE</q0:informationDetailLevel>
</q0:getWorkflowGraphRequest>
";


# Get OPM graph

my $opm_str = "";

my %hash_proc_name;

system("/home/chsmall/git/NetKarma_Portal/new_portal/webservice/query.sh /home/chsmall/git/NetKarma_Portal/new_portal/webservice/karma-3.2.2/client-core/config/karma.properties $tmp_query > $query_res");

#print "Wrote $query_res\n";

my $query_res_clean = "/tmp/res_clean." . $$;

open(RES_CLEAN,">$query_res_clean");
open(RES,"$query_res");
while (<RES>) {
  if ((!(/Total Execution Time/)) && (!(/^Query Result/))) {
    print RES_CLEAN $_;
  }
}
close RES;
close RES_CLEAN;

my $opm_file = "/home/chsmall/git/NetKarma_Portal/new_portal/webservice/uploads/$exp_id/$workflow_id.xml";
#system "cp -p $query_res_clean $opm_file";
print "$query_res_clean :: $opm_file\n";

open(RES_CLEAN,"$query_res_clean");
open(OPM,">$opm_file");
while (<RES_CLEAN>) {
  if (!(/getWorkflowGraphResponse/)) {
     print OPM $_;
  }
}
close OPM;
close RES_CLEAN;


my $ref = XMLin($query_res_clean, NSExpand => 1);




get_procs($ref);
get_artifacts($ref);
get_deps($ref);

$graph_xgmml->end;

#open (GRAPHML,">test.graphml");
#print GRAPHML $graph->as_graphml_file("test.graphml");
#close GRAPHML;


###################################################

sub get_procs {
  my $proc_ref = shift;
  
  my $procs = $proc_ref->{'{http://openprovenance.org/model/v1.1.a}opmGraph'}->{'{http://openprovenance.org/model/v1.1.a}processes'}->{'{http://openprovenance.org/model/v1.1.a}process'};
        
  foreach my $proc (keys %$procs) {
	print "Processes: $proc\n";
        #my $node_g = $graph->add_node($proc);	
	#$graph_xgmml->add_node($proc);

	my @atr_arr; 

	# Add Process type 
	#$node_g->set_attributes( { group => 'Process' } );
	#my $ann = $procs->{$proc}->{'{http://openprovenance.org/model/v1.1.a}annotation'}->{'{http://openprovenance.org/model/v1.1.a}property'};
	my $ann = $procs->{$proc}->{'{http://openprovenance.org/model/v1.1.a}annotation'};
	# If only one entry this is a hash
        if (ref($ann) eq "HASH") {
            @atr_arr = get_ann($ann); 
        }
        if (ref($ann) eq "ARRAY") {
          # More than one entry this is an array
          foreach my $ann_hash (@$ann) {
                push (@atr_arr,get_ann($ann_hash));
           }
        }
	print Dumper @atr_arr;
        my $proc_name = $proc . ":" . $atr_arr[0][5];
        print "PROC: $proc_name\n";
        $hash_proc_name{$proc} = $proc_name;
	my $node_g = $graph->add_node($proc_name);
	# Add Process type 
	$node_g->set_attributes( { group => 'Process' } );
#	print Dumper $atr_arr[0];
        my $i=0;
        my $nm="";
	my $att_str="";
	my @fff = $atr_arr[0];
	my $last_val;
	print Dumper @fff;
	foreach my $att1 (@fff) {
	   print "ATT1: $att1\n";
	   if (($i % 2)  == 0) {
                $nm = $att1;
            } else {
                my $val = $att1;	
		$last_val = $att1;
		$att_str .= $nm . "=>" . "\"" . $val . "\",";
	    }
	 $i++;
	}
	print "FFFFF: $att_str\n";
	$graph_xgmml->add_node($proc_name, type => "process", $att_str); 
	#$graph_xgmml->add_node($proc);
 }
}

###

sub get_ann {
   my $ann = shift;

   my $props = $ann->{'{http://openprovenance.org/model/v1.1.a}property'};
   my ($name,$val);
   my @ann_arr;

   if (ref($props) eq "HASH") {
            ($name,$val) = get_ann_props($props);
	    push (@ann_arr,$name);
	    push (@ann_arr,$val);
	    
        }
   if (ref($props) eq "ARRAY") {
          # More than one entry this is an array
          foreach my $props_hash (@$props) {
                ($name,$val) = get_ann_props($props_hash);
                 push (@ann_arr,$name);
                 push (@ann_arr,$val);
		
           }
   }
   #print Dumper @ann_arr;
   return \@ann_arr;
}


sub get_ann_props {
    my $props = shift;

    my $uri = $props->{'uri'};
    my $value = $props->{'{http://openprovenance.org/model/v1.1.a}value'};

    my @prop_arr; 

   #print "$uri\n";
   #print Dumper $props->{'{http://openprovenance.org/model/v1.1.a}value'};
   foreach my $val (keys %$value) {
	return ($val,$value->{$val});
   }
}


####

sub get_artifacts {
  my $a_ref = shift;

  my $artifacts = $a_ref->{'{http://openprovenance.org/model/v1.1.a}opmGraph'}->{'{http://openprovenance.org/model/v1.1.a}artifacts'}->{'{http://openprovenance.org/model/v1.1.a}artifact'};
  foreach my $artifact (keys %$artifacts) {
        print "Artifacts: $artifact\n";
        my $node_g = $graph->add_node($artifact);
	$graph_xgmml->add_node($artifact, type => "artifact");
	#$graph_xgmml->add_node($artifact);
	
	# Add Process type
        $node_g->set_attributes( { group => 'Artifacts' } );


        #my $ann = $procs->{$proc}->{'{http://openprovenance.org/model/v1.1.a}annotation'};
        #print Dumper $ann;
  }
}

####

sub get_deps {
  my $a_ref = shift;

  my $deps = $ref->{'{http://openprovenance.org/model/v1.1.a}opmGraph'}->{'{http://openprovenance.org/model/v1.1.a}causalDependencies'};
  #print Dumper $deps;
  foreach my $dep (keys %$deps) {
        (my $dep_name) = $dep =~/\{http:\/\/openprovenance.org\/model\/v1.1.a}(.*)$/;
	print "Deps: $dep:$dep_name\n";
	my $dep_values = $deps->{$dep};
	print "Ref: " . ref($dep_values) . "\n";
	# If only one entry this is a hash
        if (ref($dep_values) eq "HASH") {
	    get_dep_values($dep_name,$dep_values);
        } 
	if (ref($dep_values) eq "ARRAY") {
          # More than one entry this is an array
          foreach my $dep_hash (@$dep_values) {
		get_dep_values($dep_name,$dep_hash);	
	   }
	}
  }
}


sub get_dep_values {
   my $dep_name = shift;
   my $dep_values_ref = shift;


    print "$dep_name\n\n";
    print Dumper $dep_values_ref;

	my $source = $dep_values_ref->{'{http://www.dataandsearch.org/karma/query/opmExt/2012/03/}cause'}->{'ref'};
    	my $target = $dep_values_ref->{'{http://www.dataandsearch.org/karma/query/opmExt/2012/03/}effect'}->{'ref'};
    	my $start_time = $dep_values_ref->{'{http://www.dataandsearch.org/karma/query/opmExt/2012/03/}time'}->{'noEarlierThan'};
    	my $end_time = $dep_values_ref->{'{http://www.dataandsearch.org/karma/query/opmExt/2012/03/}time'}->{'noLaterThan'};

     if ($dep_name eq "wasTriggeredBy") {

       $source = $dep_values_ref->{'{http://openprovenance.org/model/v1.1.a}cause'}->{'ref'};
       $target = $dep_values_ref->{'{http://openprovenance.org/model/v1.1.a}effect'}->{'ref'};
       $start_time = $dep_values_ref->{'{http://openprovenance.org/model/v1.1.a}time'}->{'noEarlierThan'};
       $end_time = $dep_values_ref->{'{http://openprovenance.org/model/v1.1.a}time'}->{'noLaterThan'};

   } 

    if ($dep_name eq "wasGeneratedBy") {

       $source = $dep_values_ref->{'{http://openprovenance.org/model/v1.1.a}cause'}->{'ref'};
       $target = $dep_values_ref->{'{http://openprovenance.org/model/v1.1.a}effect'}->{'ref'};
       $start_time = $dep_values_ref->{'{http://openprovenance.org/model/v1.1.a}time'}->{'noEarlierThan'};
       $end_time = $dep_values_ref->{'{http://openprovenance.org/model/v1.1.a}time'}->{'noLaterThan'};

   }

	
    print "=== $hash_proc_name{$source},$hash_proc_name{$target},$dep_name \n";
   
    my $edge_g = $graph->add_edge($hash_proc_name{$source},$hash_proc_name{$target},$dep_name);
     $graph_xgmml->add_edge($hash_proc_name{$source} => $hash_proc_name{$target}, label => $dep_name);
}
