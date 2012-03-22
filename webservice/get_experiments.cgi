#!/usr/bin/perl

use Data::Dumper;
use DBI;
use JSON;

my $ff_db="/var/www/html/portal_dev/uploader/uploads/exp.db";


sub main {

	# For now do this from a flat file DB, move to SQL eventualy
	get_ff_exp();
	#get_db_exp();
			
} 




sub get_ff_exp {

	my $results = [];
	open (DB_FILE,$ff_db) || die "Cant open $ff_db";
	while (<DB_FILE>) {
	    chomp;
	    my @exp_arr = split (/\|/,$_);
	    my $exp_id = $exp_arr[0];
	    $exp_arr[0] = "<a href=\"http://n2t.net/" . $exp_id . "\">" . $exp_id . "</a>";


	    my $num_workflow = $exp_arr[2];
	    $exp_arr[2] = "<a href=\"#tabs-2\">" . $num_workflow . "</a>";

	    my $num_resources = $exp_arr[3];
            $exp_arr[3] = "<a href=\"#tabs-3\">" . $num_resources . "</a>";



	    push( @$results, \@exp_arr);
	
	} 
        my $res = { "aaData" => $results };


	send_json($res);
}



sub send_json {
        my $output = shift;
        print "Content-type: text/plain\n\n" . encode_json($output);
}

main();
