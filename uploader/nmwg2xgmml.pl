#!/usr/bin/perl

use strict;

use XML::Simple;
use Graph::Easy;
use Data::Dumper;
use IO::File;


my $n_hash;
my $links = {};
my @endpoints;
my $i=0;

# initialize Graph
my $graph  = Graph::Easy->new();


my $ref = XMLin('esnet_topo.xml');

my $node_hash = $ref->{'nmtb:domain'}->{'nmtb:node'};
my $link_hash = $ref->{'nmtl2:link'};

foreach my $node (keys %$node_hash) {
  $n_hash = $node_hash->{$node};
  print "$node  Long: $n_hash->{'nmtb:longitude'} Lat: $n_hash->{'nmtb:latitude'}\n";
  my $node_g = $graph->add_node($node);

  $node_g->set_attribute('label',$n_hash->{'nmtb:hostName'});
  #$node_g->set_attribute('string','label2',$n_hash->{'nmtb:hostName'});
  #, longitude => $n_hash->{'nmtb:longitude'}, latitude => $n_hash->{'nmtb:latitude'} });
  #$node_g->set_attribute('lll',$n_hash->{'nmtb:hostName'});
  #, Longitude => $n_hash->{'nmtb:longitude'}, Latitude => $n_hash->{'nmtb:latitude'} });

  # Create a link hash
  my $port_hash = $n_hash->{'nmtl2:port'};
     foreach my $port (keys %$port_hash) {
	#print Dumper $port_hash->{$port}->{'nmtl2:link'};
	if ($port_hash->{$port}->{'nmtl2:link'}->{'nmtb:relation'}->{'type'} eq "sibling") {
		#print "   Port $port Link: $port_hash->{$port}->{'nmtl2:link'}->{'nmtb:relation'}->{'nmtb:idRef'}\n";
		my $link_urn = $port_hash->{$port}->{'nmtl2:link'}->{'nmtb:relation'}->{'nmtb:idRef'};
		if ($link_urn =~ /^(.*):port=(.*)/) {
			my $target = $1;
			#$links->{$link_urn}->{'source'} = $node;
			#$links->{$link_urn}->{'target'} = $target;
			# Record A->B in hash
			$links->{$target . ":" . $node} = $link_urn;
			if ( ! $links->{$node . ":" . $target}) {
			     my $edge_g = $graph->add_edge($node,$target,$link_urn);
			     print "   Port $port Link: $link_urn Source : $node Target $target\n";	
			} else { 
				print  "   Dupliate edge\n";
			}
	       } 
	}
       }
	
}


open (GRAPHML,">esnet_topo.graphml");
print GRAPHML $graph->as_graphml_file("esnet_topo.graphml");
close GRAPHML;



