#!/usr/bin/perl

use warnings;
use strict;
use CGI;
use Data::Dumper;

my $form = new CGI;

print $form->header; #Print HTML header

print '<pre>';
print Dumper \%ENV;
print '</pre>';

my $f_name = \%ENV;
#my $fh = $form->upload('upfile'); 

open(OUTFILE,">/var/www/html/portal/uploader/uploads/env.txt");
print Dumper OUTFILE "Filename: $f_name\n";
close OUTFILE;




#$fn = (isset($_SERVER['HTTP_X_FILENAME']) ? $_SERVER['HTTP_X_FILENAME'] : false);

#if ($fn) {

#	file_put_contents(
#		'/var/www/html/portal/uploader/uploads/' . $fn,
#		file_get_contents('php://input')
#	);
#	echo "$fn uploaded";
