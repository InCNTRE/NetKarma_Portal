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




#$fn = (isset($_SERVER['HTTP_X_FILENAME']) ? $_SERVER['HTTP_X_FILENAME'] : false);

#if ($fn) {

#	file_put_contents(
#		'/var/www/html/portal/uploader/uploads/' . $fn,
#		file_get_contents('php://input')
#	);
#	echo "$fn uploaded";
