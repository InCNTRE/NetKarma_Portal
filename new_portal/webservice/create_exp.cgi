#!/usr/bin/perl

use warnings;
use strict;
use CGI;
use Data::Dumper;

my $form = new CGI;

my $msg;

my $exp_loc = "http://netkarma-demo.incntre.iu.edu/dev/experiment.cgi";


use Config::Simple;

my $conf_file = "/home/chsmall/netkarma.ini";
# --- OO interface:
my $cfg = new Config::Simple($conf_file);
#
my $db_name =  $cfg->param('DB_Name');
my $db_user = $cfg->param('DB_User');
my $db_pass = $cfg->param('DB_Password');



print $form->header;



# Validate data
validate_data();


# Add experiment to DB
db_add_exp();

print "sucesss!!!";
exit;

#============

sub validate_data {
  
  if ($form->param('exp_name') eq "") {
     $msg = "Must enter Experiment Name";
     die $msg;
    }

if (!($form->param('exp_url') =~ /http:\/\/(.*)\.(.*)/)) {
     $msg = "Must enter Experiment URL";
     die $msg
    }

if ($form->param('exp_desc') eq "") {
     $msg = "Must enter Experiment Description";
     die $msg;
    }
   

}


sub get_handle {
    my $hand_url = shift;
    my $hand_name = shift;

   return "doi:/99999/FA0000";
}


sub db_add_exp {

   use DBI;



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
   my $e_sql = "INSERT INTO experiments (name,creator,creator_email,creation_date) VALUES 
	(\'$name\',\'$creator\',\'$email\',NOW())";


   my $e_ret_val = $dbh->do($e_sql); 

   #my $exp_id = $dbh->last_insert_id();
   my $exp_id = $dbh->{ q{mysql_insertid}};
   my $exp_url = $exp_loc . "id=" . $exp_id; 


   # Get Handle ID for EZID

   my $handle = get_handle($exp_url,$name);

   # Build Handle sql
   my $h_sql = "INSERT INTO handles (handle_name,handle_type,exp_id) VALUES (\'$handle\','DOI',$exp_id)";

   my $h_ret_val = $dbh->do($h_sql); 
    

}
