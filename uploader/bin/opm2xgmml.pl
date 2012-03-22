#!/usr/bin/perl

use strict;

use XML::Simple;
use Graph::Easy;
use Data::Dumper;
use IO::File;
use lib '/var/www/html/portal/uploader/lib';
use NetKarma::XGMML;


my $n_hash;
my $links = {};
my @endpoints;
my $i=0;

my $workflow_id = $ARGV[0];
my $outfile = $workflow_id . ".xgmml";

# initialize Graph
my $graph  = Graph::Easy->new();

my $graph_xgmml  = NetKarma::XGMML->new(
      directed => 1,
      OUTPUT   => IO::File->new($outfile, 'w'),
  );


# Get OPM graph



my $query_res_clean = "/tmp/GEC13-xml-files/" . $workflow_id . ".xml";

my $ref = XMLin($query_res_clean);

#print Dumper $ref;

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

  my $ann_res;

  my $procs = $proc_ref->{'v1:processes'}->{'v1:process'};
  foreach my $proc (keys %$procs) {
	print "Processes: $proc\n";
        my $node_g = $graph->add_node($proc);	
	#$graph_xgmml->add_node($proc);

	# Add Process type 
	$node_g->set_attributes( { group => 'Process' } );
	#my $ann = $procs->{$proc}->{'v1:annotation'}->{'v1:property'};
	my $ann = $procs->{$proc}->{'v1:annotation'};
	# If only one entry this is a hash
        if (ref($ann) eq "HASH") {
            # $ann_res = get_ann($ann); 
        }
        if (ref($ann) eq "ARRAY") {
          # More than one entry this is an array
          foreach my $ann_hash (@$ann) {
             # $ann_res = get_ann($ann_hash);
           }
        }

 	my @atr_arr = [];	
	print Dumper $ann_res; 
	$graph_xgmml->add_node($proc, type => "process"); 
	#$graph_xgmml->add_node($proc);
 }
}

###

sub get_ann {
   my $ann = shift;

   my @res;
   my $name;
   my $val;

   my $props = $ann->{'v1:property'};

   if (ref($props) eq "HASH") {
	    @res = get_ann_props($props);   
        }
   if (ref($props) eq "ARRAY") {
          # More than one entry this is an array
          foreach my $props_hash (@$props) {
		@res = get_ann_props($props);
           }
   }

  print Dumper @res;
  #return $res; 
}

sub get_ann_props {
    my $props = shift;

    my $uri = $props->{'uri'};
    my $value = $props->{'v1:value'};

    my @prop_arr; 

    if (!($uri =~ /^process-annotation\/EXTERNAL_SOURCE/ )) {
      print "$uri\n";
      #print Dumper $props->{'v1:value'};
      foreach my $val (keys %$value) {
	push (@prop_arr,$val);
	push (@prop_arr,$value->{$val});
      }
   }
   return \@prop_arr;
}
####

sub get_artifacts {
  my $a_ref = shift;

  my $artifacts = $a_ref->{'v1:artifacts'}->{'v1:artifact'};
  foreach my $artifact (keys %$artifacts) {
        print "Artifacts: $artifact\n";
        my $node_g = $graph->add_node($artifact);
	$graph_xgmml->add_node($artifact, type => "artifact");
	#$graph_xgmml->add_node($artifact);
	
	# Add Process type
        $node_g->set_attributes( { group => 'Artifacts' } );


        #my $ann = $procs->{$proc}->{'v1:annotation'};
        #print Dumper $ann;
  }
}

####

sub get_deps {
  my $a_ref = shift;

  my $deps = $ref->{'v1:causalDependencies'};
  #print Dumper $deps;
  foreach my $dep (keys %$deps) {
        (my $dep_name) = $dep =~/v1:(.*)$/;
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


    my $source = $dep_values_ref->{'v1:cause'}->{'ref'};
    my $target = $dep_values_ref->{'v1:effect'}->{'ref'};
    my $start_time = $dep_values_ref->{'v1:time'}->{'noEarlierThan'};
    my $end_time = $dep_values_ref->{'v1:time'}->{'noLaterThan'};
   
    my $edge_g = $graph->add_edge($source,$target,$dep_name);
     $graph_xgmml->add_edge($source => $target, label => $dep_name);
}	
