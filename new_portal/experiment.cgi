#!/usr/bin/perl

use strict;
use CGI;
use DBI;
use Config::Simple;
my $conf_file = "/home/chsmall/netkarma.ini";


my $exp_html = new CGI;

print $exp_html->header;

my $exp_id = $exp_html->param('id');


# --- OO interface:
my $cfg = new Config::Simple($conf_file);
#
my $db_name =  $cfg->param('DB_Name');
my $db_user = $cfg->param('DB_User');
my $db_pass = $cfg->param('DB_Password');


get_experiment($exp_id);

sub get_experiment {
      my $exp_id = shift;

      #DATA SOURCE NAME
      my $dsn = "dbi:mysql:$db_name:localhost:3306";
      my $dbh = DBI->connect($dsn,$db_user,$db_pass) || die "Can not connect to $db_name: $DBI::errstr";

      my $sth = $dbh->prepare('SELECT name,handle_name,creator_email,creation_date from experiments, handles where handles.exp_id = $exp_id AND handles.exp_id = experiments.exp_id');
      my $rv = $sth->execute;
      my $array_ref = $sth->fetchall_arrayref;
      foreach my $arr (@$array_ref) {
          print Dumper $arr; 
      }
}
