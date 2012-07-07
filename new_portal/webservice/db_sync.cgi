#!/usr/bin/perl
#

use strict;
use Config::Simple;
use Net::Dropbox::API;
use CGI;

# Find the file
#
my $exp_id = 58;

my $form = new CGI;
print $form->header;


my $conf_file = "/etc/netkarma/netkarma.ini";

# --- Get config values
my $cfg = new Config::Simple($conf_file);
# 
my $drop_key = $cfg->param('Dropbox_Key');
my $drop_sec = $cfg->param('Dropbox_Secret');
#
my $callback = "netkarma-demo.incntre.iu.edu/webservice/db_sync.cgi"; 

my $box = Net::Dropbox::API->new({key => $drop_key, secret => $drop_sec, callback_url => $callback });
my $login_link = $box->login; # user needs to klick this link and login

print <<DB;
<html>
<body>
 <a href="$login_link">Dropbox Auth</a>
</body>
</html>

DB


$box->auth;                   # oauth keys get exchanged
my $info = $box->info;        # and here we have our account info
