#!/usr/bin/perl

use strict;
use CGI;
use DBI;
use Config::Simple;
my $conf_file = "/etc/netkarma/netkarma.ini";

my $exp_name = "";
my $exp_html = new CGI;

print $exp_html->header;

my $exp_id = $exp_html->param('id') || "53";


# --- OO interface:
my $cfg = new Config::Simple($conf_file);
#
my $db_name =  $cfg->param('DB_Name');
my $db_user = $cfg->param('DB_User');
my $db_pass = $cfg->param('DB_Password');

#
my $dir = "/webservice/uploads/$exp_id/";
# print header file
open (HEADER,"exp_header.html") || die "can not open header";
while (<HEADER>) { print; }
close HEADER;

print "<script type='text/javascript' charset='utf-8'>

\$(document).ready(function() {
    oTable = \$('#workflows').dataTable({
        'sAjaxSource': '../webservice/get_workflow_db.cgi?exp_id=$exp_id'
    });
    oTable2 = \$('#topologies').dataTable({
        'sAjaxSource': '../webservice/get_topology.cgi?exp_id=$exp_id'
    });
    cont = \$('#container_id').fileTree({ root: '$dir', script:'../webservice/jqueryfiletree.cgi'}, function(file) {
	var sh_file = file.substring(0,file.length-1);   	
         window.open(sh_file);
});
 
});




</script>";



# Tab 1 
#
print "<div id=\"tabs-1\">\n<table>\n<tr>\n";

print "<td width='40%' id='exp_info'>";


# Experiment Info
print "<fieldset>
  <legend>Experiment Info</legend>";


get_experiment($exp_id);

print_qr_code($exp_id);

print "</fieldset></td><td>";


# Add Data 
print <<EOF;

<fieldset>
   <legend>Add Data/Files to Experiment</legend>

    <div class='title_2'>Add URL/DOI/Unstructured Data<\div>
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
EOF
  print "  <input type=\"hidden\" id=\"EXP_ID\" name=\"EXP_ID\" value=$exp_id />\n";
print <<EOF;
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


   <div id="progress"></div>

 <div id="messages">
 </div>

</fieldset>

</td></table></div>

EOF


#Tab2
print "<div id=\"tabs-2\" onclick=\"oTable.fnDraw();\">";


print <<TAB2;


<fieldset>
  <legend>Workflows</legend>
     

     <div class="demo">

      <table cellpadding="0" cellspacing="0" border="0" class="display" id="workflows">
        <thead>
          <tr>
            <th>Karma WorkFlow ID</th>
            <th>Open Provenance Model XML</th>
            <th>Graph Representation</th>
          </tr>
        </thead>
       </table>
   </div>

</fieldset>
<div id="wf_name">
WorkFlow Name 
</div>
<div id="cytoscapeweb">
        <center> No WorkFlow Chosen/Available</center>    
</div>

<div id="node_wf">
</div>


</div>
TAB2

# Tab 3

print <<TAB3;

<div id="tabs-3">
<fieldset>
  <legend>Topologies</legend>
     

     <div class="demo">

      <table cellpadding="0" cellspacing="0" border="0" class="display" id="topologies">
        <thead>
          <tr>
            <th>Topology File</th>
            <th>Uploader</th>
            <th>Upload Time</th>
          </tr>
        </thead>
       </table>
   </div>
 
</fieldset>

<div id="cytoscapeweb2">
        <center> No Topology Chosen/Available</center>    
</div>
</div>
TAB3



#Tab4
print "<div id=\"tabs-4\">";

print <<TAB4;
<fieldset>
  <legend>Archives</legend>
  

<div class="example_rf">
 Experiment: $exp_name		
 <br>
 <hr>
 Files:
 <br>
 <div id="container_id" class="demo_rf"></div>
</div>

</fieldset>
TAB4


## close Tab 4
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


      $exp_name = $hash_ref->{name};
      print "<div id='name_title' class='title_2'>Experiment Name:</div>\n";
      print "<div id='name'class='value_2'>$hash_ref->{name}</div>\n";

      print "<div id='name_title' class='title_2'>Email:</div>\n";
      print "<div id='name'class='value_2'>$hash_ref->{creator_email}</div>\n";

      print "<div id='name_title' class='title_2'>Creation Date:</div>\n";
      print "<div id='name'class='value_2'>$hash_ref->{creation_date}</div>\n";

     #$dbh->disconnect();
}

sub print_qr_code {

      my $exp_id = shift;

      my $hand_suffix="";


      #DATA SOURCE NAME
      my $dsn = "dbi:mysql:$db_name:localhost:3306";
      my $dbh = DBI->connect($dsn,$db_user,$db_pass) || die "Can not connect to $db_name: $DBI::errstr";
      my $sql = "SELECT handle_name from handles where handles.exp_id = $exp_id";
      #
      my $sth = $dbh->prepare($sql);
      my $rv = $sth->execute;
      my $hash_ref = $sth->fetchrow_hashref();

      my $handle = $hash_ref->{handle_name};
      if ($handle =~ /doi:\/\/(.*)$/) { $hand_suffix = $1;}
  

print "<div id='handle_title' class='title_2'>Handle:</div>";
print "<div class='value_2'><a href='http://n2t.net/ezid/id/$handle'>$handle</a></div>";
print "<div id='name_title' class='title_2'>Experiment QR Code:</div>\n";
print "<div class=\"grid_3\">\n";

print "   <img src=\"https://chart.googleapis.com/chart?chs=120x120&cht=qr&chld=L|0&chl=http%3A//dx.doi.org/$hand_suffix\"
 alt=\"QR Code for http://dx.doi.org/$hand_suffix\" title=\"QR Code for http://dx.doi.org/$hand_suffix\"/>\n";
print "</div>";
}
