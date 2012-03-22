#!/usr/bin/perl

use Data::Dumper;
use DBI;
use JSON;

my $wf_db="/var/www/html/portal/uploader/uploads/wf.db";

sub main {

    my $username      = 'karma';
    my $password      = 'kicks3,cans';
    my $database_name = 'karma';
    my $port          = 3306;
    my $hostname      = 'localhost';
    my $dbh           = DBI->connect(
                "DBI:mysql:database=$database_name;host=$hostname;port=$port",
                $username, $password, { AutoCommit => 0 } );


    #my $query = "select entity_uri from exe_entity where entity_type = 'WORKFLOW' and entity_subtype='REGULAR'"; 
    my $query = "select DISTINCT context_workflow_uri from exe_entity where context_workflow_uri is NOT NULL";
    my $sth = $dbh->prepare($query);
    $sth->execute();

       my $results = [];
	my $st_time = time() - 3600;
        my $end_time = time();
        while ( my $row = $sth->fetchrow_hashref() ) {
		$gm_st_str = gmtime($st_time);
		$gm_end_str = gmtime($end_time);
		my $wf_uri = $row->{'context_workflow_uri'};


		# get experiment
		my ($handle, $exp_desc) = get_exp_id($wf_uri);
	 	my $wf_id = "<a href=\"#wf_tabs-2\" onclick=\"load_cyto_wf('" . $wf_uri . "')\">" . $wf_uri . "</a>";	
                my $exp_id = "<a href=\"http://n2t.net/" . $handle . "\">" . $handle . "</a>";
		push( @$results, [ "No Description", $wf_id, $exp_desc, $exp_id , "chsmall", $gm_st_str, $gm_end_str]);
	}

        my $res = { "aaData" => $results };
	#print Dumper $results;
	send_json($res);

    $dbh->disconnect();
		
			
} 

sub get_exp_id {
   my $wf_id = shift;

    open (DB_FILE,$wf_db) || die "Cant open $wf_db";
    while (<DB_FILE>) {
	my @exp_arr = split(/\|/,$_);
	if ($exp_arr[0] eq $wf_id) {
		return ($exp_arr[2],$exp_arr[1]);
	}
    }
    close DB_FILE;
    return ("handle not found","no desccription"); 
}


sub send_json {
        my $output = shift;
        print "Content-type: text/plain\n\n" . encode_json($output);
}

main();
