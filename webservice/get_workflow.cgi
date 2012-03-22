#!/usr/bin/perl


use JSON;


sub main {

  open(QUERY,"/home/karma/karma-3.2.1/client-core/bin/query.sh  /home/karma/karma-3.2.1/client-core/config/karma.properties /home/karma/karma-3.2.1/client-core/samples/query/findService_sample2.xml |") || die "Can not query Karma DB";

while (<QUERY>) {
   if (/<ns:serviceID>(.*)<\/ns:serviceID>/) {
        print "ID: $1\n";
        push ( @ids, { "id" => $1  } );
    }
  }
  my $results = { "data" => \@ids };

  send_json($results);
}


sub get_wf {


my @ids = ();
my $now = time();
open(QUERY,"/home/karma/karma-3.2.1/client-core/bin/query.sh  /home/karma/karma-3.2.1/client-core/config/karma.properties /home/karma/karma-3.2.1/client-core/samples/query/findService_sample2.xml |") || die "Can not query Karma DB";

while (<QUERY>) {
    print $_;
   if (/<ns:serviceID>(.*)<\/ns:serviceID>/) { 
	print "ID: $1\n";
	push ( @ids, { "id" => $1  } );
	#$workflow{$1}{"description"} = "Gush log";
	#$workflow{$1}{"project"} = "unknown";
	#$workflow{$1}{"user"} = "unknown";
	#$workflow{$1}{"start_time"} = $now - 3600;
	#$workflow{$1}{"end_time"} = $now;
    }

   my $results = { "data" => \@ids };
	
   return $results;

}
}

sub send_json {
        my $output = shift;
        print "Content-type: text/plain\n\n" . encode_json($output);
}

main();
