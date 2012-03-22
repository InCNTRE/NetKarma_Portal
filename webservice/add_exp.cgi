#!/usr/bin/perl



use warnings;
use strict;
use CGI;
use Data::Dumper;

my $form = new CGI;


my $exp_db = "/var/www/html/portal/uploader/uploads/exp.db";



open(EXP_DB,">>$exp_db") || die "Cant open $exp_db";

print $form->header;


# 
my $handle = get_ark();

print $handle . "|" . $form->param('name') . "|0|0|chsmall\@indiana.edu";
print EXP_DB $handle . "|" . $form->param('name') . "|0|0|chsmall\@indiana.edu\n";

close EXP_DB; 



sub get_ark() {
 	 my $rand_str = join'', map +(0..9,'a'..'z')[rand(10+26)], 1..6;
	 my $res = "ark:/99999/fk4" . $rand_str; 
	 return $res;
}
