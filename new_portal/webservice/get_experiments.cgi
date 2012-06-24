#!/usr/bin/perl

use Data::Dumper;
use DBI;
use JSON;

use Config::Simple;

my $conf_file = "/home/chsmall/netkarma.ini";
# --- OO interface:
my $cfg = new Config::Simple($conf_file);

my $db_name =  $cfg->param('DB_Name');
my $db_user = $cfg->param('DB_User');
my $db_pass = $cfg->param('DB_Password');
my @resuilts =[];

get_db_exp();


sub get_db_exp {
      my @resuilts =[];

      #DATA SOURCE NAME
      my $dsn = "dbi:mysql:$db_name:localhost:3306";
      my $dbh = DBI->connect($dsn,$db_user,$db_pass) || die "Can not connect to $database: $DBI::errstr";

      my $sth = $dbh->prepare('SELECT name,handle_name,creator_email,creation_date,experiments.exp_id from experiments, handles where handles.exp_id = experiments.exp_id');
      my $rv = $sth->execute;
      my $array_ref = $sth->fetchall_arrayref;
      foreach my $arr (@$array_ref) {
	my $name = "<a href='html/experiment.cgi?id=".$arr->[4]."'>".$arr->[0]."</a>";
	my $handle = "<a href='http://n2t.net/ezid/id/".$arr->[1]."'>".$arr->[1]."</a>";
       
        my @res_arr = [ $name , $handle, $arr->[2], $arr->[3] ];
        push @results, @res_arr; 
      }
	
      my $res = { "aaData" => \@results}; 
     
      #print Dumper $res; 
      send_json($res);
}



sub send_json {
        my $output = shift;
        print "Content-type: text/plain\n\n" . encode_json($output);
}

