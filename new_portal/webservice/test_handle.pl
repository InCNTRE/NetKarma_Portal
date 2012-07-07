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


# Validate data
#validate_data();



    my $hand_url = $exp_loc . "_testhandle";

    my $doi = "handle not created";

    my %metadata = ( "_target" => $hand_url,
    "creator" => "Beth Plale, Chris Small, Scott Jensen",
    "publicationyear" => "2012",
    "publisher" => "Data To Insight Center"
    );

   my $ua = LWP::UserAgent->new;
   $ua->credentials("n2t.net:443", "EZID", $datacite_user, $datacite_pass);

   my $meta = encode("UTF-8", join("\n",
       map { escape($_) . ": " . escape($metadata{$_}) } keys %metadata));

   print Dumper $meta;

   #$r = $ua->request(POST "https://n2t.net:443/ezid/shoulder/doi:10.5967/M0",
   my $r = $ua->request(POST "https://n2t.net/ezid/shoulder/doi:10.5072/FK2",
      "Content-Type" => "text/plain; charset=UTF-8",
      Content => $meta );

      
     if ( $r->decoded_content =~ /success: doi:(\S+)/) {
        $doi = "doi:" . $1;
     }

    print $doi ;



sub escape {
  (my $s = $_[0]) =~ s/([%:\r\n])/uri_escape($1)/eg;
  return $s;
}


