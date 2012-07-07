#!/usr/bin/perl
#

use Encode;
use HTTP::Request::Common;
use LWP::UserAgent;
use URI::Escape;

sub escape {
  (my $s = $_[0]) =~ s/([%:\r\n])/uri_escape($1)/eg;
  return $s;
}

%metadata = ( "_target" => "http://incntre.iu.edu/",
    "creator" => "Beth Plale, Chris Small, Scott Jensen",
    "publicationyear" => "2012",
    "publisher" => "Data To Insight Center" );


$ua = LWP::UserAgent->new;
$ua->credentials("n2t.net:443", "EZID", "iusead", "d2icenter");
$r = $ua->request(PUT "https://n2t.net:443/ezid/id/doi:10.5072/FK2",
  "Content-Type" => "text/plain; charset=UTF-8",
  Content => encode("UTF-8", join("\n",
    map { escape($_) . ": " . escape($metadata{$_}) } keys %metadata)));
print $r->code, $r->decoded_content unless $r->is_success;

print $r->code, $r->decoded_content;
