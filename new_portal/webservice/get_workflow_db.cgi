#!/usr/bin/perl

use warnings;
use strict;
use CGI;
use DBI;
use Data::Dumper;
use JSON;

use Encode;
use HTTP::Request::Common;
use LWP::UserAgent;
use URI::Escape;

use Config::Simple;

my $form = new CGI;

my $msg;

my $conf_file = "/etc/netkarma/netkarma.ini";

# --- Get config values
my $cfg = new Config::Simple($conf_file);
#
my $db_name =  $cfg->param('DB_Name');
my $db_user = $cfg->param('DB_User');
my $db_pass = $cfg->param('DB_Password');

my $exp_loc = $cfg->param('HTML_Location');

my $datacite_user = $cfg->param('DataCite_User');
my $datacite_pass = $cfg->param('DataCite_Password');



my $id = "40";

if ($form->param('exp_id') ne "") {
	$id = $form->param('exp_id');
}



my @results; 

   # Clean data 
   my $name = $form->param('exp_name');
   #my $url = $form->param('exp_url');
   my $url = 'test url';
   my $creator = "chsmall\@indiana.edu";
   my $email = $form->param('exp_email'); 
   
   # Open DB
   # TODO: put this in a config file
   #DATA SOURCE NAME
   my $dsn = "dbi:mysql:$db_name:localhost:3306";

   my $dbh = DBI->connect($dsn,$db_user,$db_pass) || die "Can not connect to $db_name: $DBI::errstr";

   # Build Experiment  sql
   my $e_sql = "select workflow_id from workflows where exp_id=" . $id;

     my $sth = $dbh->prepare($e_sql);
      my $rv = $sth->execute;
      my $array_ref = $sth->fetchall_arrayref;

      foreach my $arr (@$array_ref) {
        #my $wf_id = "<div class='wf_id' id='".$arr->[0]."'>".$arr->[0]."</div>";
        my $wf_id = "<a href=\"#\" onclick=\"load_cyto_wf('" . $arr->[0]. "')\">" . $arr->[0] . "</a>";
        my $wf_opm_file = "<a href=\"/webservice/uploads/" . $id . "/" . $arr->[0] . ".xml\">OPM File</a>";
        my $wf_xgmml_file = "<a href=\"/cache/" . $arr->[0] . ".xgmml\">XGMML File</a>";
       
        my @res_arr = [ $wf_id , $wf_opm_file, $wf_xgmml_file];
        push @results, @res_arr; 
      }
        
      my $res = { "aaData" => \@results}; 
     
      send_json($res);


sub send_json {
 	my $output = shift;
	print "Content-type: text/plain\n\n" . encode_json($output);
  } 

