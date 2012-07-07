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



my $id = "40";

if ($form->param('exp_id') ne "") {
	$id = $form->param('exp_id');
}



my @results; 

my $upload_path = "/home/chsmall/git/NetKarma_Portal/new_portal/webservice/uploads/" . $id;

my @files = <$upload_path/*>;
foreach my $file (@files) {

	if (is_nmwg($file)) { 
		my ($dev,$ino,$mode,$nlink,$uid,$gid,$rdev,$size,$atime,$mtime,$ctime,
$blksize,$blocks) = stat($file);
       	 	my @res_arr = [ $file , "chsmall", localtime($mtime) ];
        	push @results, @res_arr; 
	}

}
      my $res = { "aaData" => \@results}; 
     
      send_json($res);


sub send_json {
 	my $output = shift;
	print "Content-type: text/plain\n\n" . encode_json($output);
  } 

sub is_nmwg {
    my $file = shift;
    if ($file =~/.nmwg$/) { return 1; }
    return 0;
}

