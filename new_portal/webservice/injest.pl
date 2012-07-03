#!/usr/bin/perl
#

use strict;
use DBI;
use Config::Simple;

# Find the file
#
my $iperf_file = "";
my $xsplog_file = "";
my $slice_file = "";

my $exp_id = $ARGV[0];
#$exp_id = 42;
my $wf_id;

# Get the three files
#
my $user = "netkarma_demo";
my $upload_path = "/home/chsmall/git/NetKarma_Portal/new_portal/webservice/uploads/" . $exp_id;
#print $upload_path;

my @files = <$upload_path/*>;

foreach my $file (@files) {
    if ($file =~/iperf.xsplog.(\d+)/) { $iperf_file = $file; }
    if ($file =~/xsplog.(\d+)/) { $xsplog_file = $file; }
    if ($file =~/slice.info/) { $slice_file = $file; }

}

if (( $iperf_file ne "") && ( $xsplog_file ne "") && ( $slice_file ne "")) {
    my $rv =`java -jar netkarma-xsp-adapter.jar $user $slice_file $xsplog_file $iperf_file`;

    if ( $rv =~ /Workflow-Instance ID = (\S+)/ ) { $wf_id=$1; print $wf_id; }
    add_wf_id($wf_id,$exp_id);

}




sub add_wf_id {
 my $wf_id = shift;
 my $exp_id = shift;


my $msg;

my $conf_file = "/etc/netkarma/netkarma.ini";

# --- Get config values
my $cfg = new Config::Simple($conf_file);
# 
my $db_name =  $cfg->param('DB_Name');
my $db_user = $cfg->param('DB_User');
my $db_pass = $cfg->param('DB_Password');
#
my $exp_loc = $cfg->param('HTML_Location');
#
my $datacite_user = $cfg->param('DataCite_User');
my $datacite_pass = $cfg->param('DataCite_Password');
#
#
#                            
# Open DB
# TODO: put this in a config file
#DATA SOURCE NAME
my $dsn = "dbi:mysql:$db_name:localhost:3306";

my $dbh = DBI->connect($dsn,$db_user,$db_pass) || die "Can not connect to $db_name: $DBI::errstr";
# Build Experiment  sql
my $e_sql = "insert into workflows (workflow_id, exp_id) values ( '$wf_id' , $exp_id )";
print $e_sql;
#                                                  
my $sth = $dbh->prepare($e_sql);
my $rv = $sth->execute;

}
