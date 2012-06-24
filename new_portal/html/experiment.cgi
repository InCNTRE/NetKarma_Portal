#!/usr/bin/perl

use strict;
use CGI;
use DBI;
use Config::Simple;
my $conf_file = "/etc/netkarma/netkarma.ini";


my $exp_html = new CGI;

print $exp_html->header;

my $exp_id = $exp_html->param('id') || "15";


# --- OO interface:
my $cfg = new Config::Simple($conf_file);
#
my $db_name =  $cfg->param('DB_Name');
my $db_user = $cfg->param('DB_User');
my $db_pass = $cfg->param('DB_Password');


# print header file
open (HEADER,"exp_header.html") || die "can not open header";
while (<HEADER>) { print; }
close HEADER;

# Tab 1 
#
print "<div id=\"tabs-1\">\n<table>\n<tr>\n";

print "<td width='40%' id='exp_info'>";


# Experiment Info
print "<fieldset>
  <legend>Experiment Info</legend>";


get_experiment($exp_id);

print_qr_code();

print "</fieldset></td><td>";


# Add Data 
print <<EOF;

<fieldset>
   <legend>Add Data/Files to Experiment</legend>

    <div class='title_2'>Add URL/DOI/ACM Ref/Unstructured Data<\div>
    <textarea cols=50 rows=10 name='unstr_data' id='unstr_data'> 
     </textarea>

 <div id="exp_name_set">
     
     <div id="click_me2">
     <input type="button" name="click_me" id="click_me" value="Submit" /> 
     </div>

   </div>


    <div id="upload" align="top">
      <form id="upload" action="../webservice/upload.php" method="POST" enctype="multipart/form-data">
   </div>
  <input type="hidden" id="MAX_FILE_SIZE" name="MAX_FILE_SIZE" value="1000000000" />
  <div>
        <label for="fileselect">Files to upload:</label>
        <input type="file" id="fileselect" name="fileselect[]" multiple="multiple" />
        <div id="filedrag">or drop files here</div>
  </div>

 <div id="supported_files">
        The following files are parsed for workflow and resource provenance:
        <ul>
         <li><a href="http://gush.cs.williams.edu/trac/gush">Gush log files</a></li>
         <li><a href="http://nmwg.internet2.edu/">UNIS/NMWG Topology file</a></li>
         <li><a href="http://groups.geni.net/geni/wiki/GeniRspec">GENI RSPEC V3</a></li>
        </ul>
         All files are saved as artifacts.
 </div>

</fieldset>

</td></table></div>

EOF


#Tab2
print "<div id=\"tabs-2\">";


print <<TAB2;


<fieldset>
  <legend>Workflows</legend>
     

     <div class="demo">
      <table cellpadding="0" cellspacing="0" border="0" class="display" id="workflows">
        <thead>
          <tr>
            <th>Karma WorkFlow ID</th>
            <th>Uploader</th>
            <th>Upload Time</th>
          </tr>
        </thead>
       </table>
   </div>

</fieldset>

TAB2

# close Tab2
print "</div>\n";

#Tab3
print "<div id=\"tabs-3\">";

# close Tab 3
print "</div>\n";

#Tab4
print "<div id=\"tabs-4\">";
#
## close Tab 3
print "</div>\n";


# Close Tabs
print "</div>\n";
# Close Box
print "</div>\n";

# print header file
open (FOOTER,"footer.html") || die "can not open header";
while (<FOOTER>) { print; }
close FOOTER;

sub get_experiment {
      my $exp_id = shift;

      #DATA SOURCE NAME
      my $dsn = "dbi:mysql:$db_name:localhost:3306";
      my $dbh = DBI->connect($dsn,$db_user,$db_pass) || die "Can not connect to $db_name: $DBI::errstr";
      my $sql = "SELECT name,creator_email,creation_date from experiments where experiments.exp_id = $exp_id";

      #print $sql;

      my $sth = $dbh->prepare($sql);
      my $rv = $sth->execute;
      my $hash_ref = $sth->fetchrow_hashref;
      print "<div id='name_title' class='title_2'>Experiment Name:</div>\n";
      print "<div id='name'class='value_2'>$hash_ref->{name}</div>\n";

      print "<div id='name_title' class='title_2'>Creater Email:</div>\n";
      print "<div id='name'class='value_2'>$hash_ref->{creator_email}</div>\n";

      print "<div id='name_title' class='title_2'>Creation Date:</div>\n";
      print "<div id='name'class='value_2'>$hash_ref->{creation_date}</div>\n";
}

sub print_qr_code {
   
print "<div id='name_title' class='title_2'>Experiment QR Code:</div>\n";
print "<div class=\"grid_3\">\n";

print "   <img src=\"https://chart.googleapis.com/chart?chs=120x120&cht=qr&chld=L|0&chl=http%3A//dx.doi.org/10.5072/FK2B27X14\"
 alt=\"QR Code for http://dx.doi.org/10.5072/FK2B27X14\" title=\"QR Code for http://dx.doi.org/10.5072/FK2B27X14\"/>\n";
print "</div>";
}
