#!/usr/bin/perl

use warnings;
use strict;
use CGI;
use Data::Dumper;

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

print $form->header;

# Validate data
#validate_data();

# Add experiment to DB
db_add_exp();

exit;

#============

sub validate_data {
  
  if ($form->param('exp_name') eq "") {
     $msg = "Must enter Experiment Name";
     print $msg;
     exit 1;
    }

#if (!($form->param('exp_url') =~ /http:\/\/(.*)\.(.*)/)) {
#     $msg = "Must enter Experiment URL";
#     die $msg
#    }

#if ($form->param('exp_desc') eq "") {
#     $msg = "Must enter Experiment Description";
#     die $msg;
#    }
   
}

sub test_handle {
    my $hand_url = shift;
    my $hand_name = shift;

    print "doi://99999/test";
}

sub get_handle {
    my $hand_url = shift;
    my $hand_name = shift;

    my $doi = "handle not created";

    my %metadata = ( "_target" => $hand_url,
    "creator" => "Beth Plale, Chris Small, Scott Jensen",
    "publicationyear" => "2012",
    "publisher" => "Data To Insight Center"
    );

   my $ua = LWP::UserAgent->new;
   $ua->credentials("n2t.net:443", "EZID", $datacite_user, $datacite_pass);

   #$r = $ua->request(POST "https://n2t.net:443/ezid/shoulder/doi:10.5967/M0",
   my $r = $ua->request(POST "https://n2t.net/ezid/shoulder/doi:10.5072/FK2",
      "Content-Type" => "text/plain; charset=UTF-8",
      Content => encode("UTF-8", join("\n",
       map { escape($_) . ": " . escape($metadata{$_}) } keys %metadata)));

      
     if ( $r->decoded_content =~ /success: doi:(\S+)/) {
        $doi = "doi:" . $1;
     }

    return $doi ;
}


sub escape {
  (my $s = $_[0]) =~ s/([%:\r\n])/uri_escape($1)/eg;
  return $s;
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
   my $exp_url = $exp_loc . "?id=" . $exp_id; 


   # Get Handle ID for EZID

   my $handle = get_handle($exp_url,$name);
   #my $handle = test_handle($exp_url,$name);

   # Build Handle sql
   my $h_sql = "INSERT INTO handles (handle_name,handle_type,exp_id) VALUES (\'$handle\','DOI',$exp_id)";

   my $h_ret_val = $dbh->do($h_sql); 
    

}
