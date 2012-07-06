#!/usr/bin/perl

use strict;
use CGI;

my $exp_html = new CGI;

print $exp_html->header;

my $exp_id = $exp_html->param('id') || "53";

my $dir = "/webservice/uploads/$exp_id/";
print <<HEAD;

<html>
<head>
  <title>Archive</title>

<script src="/js/DataTables-1.9.1/media/js/jquery.js"></script>
<script src="/js/jquery.easing.1.3.js"></script>
<script src="/js/jqueryFileTree/jqueryFileTree.js"></script>
<link href="/js/jqueryFileTree/jqueryFileTree.css" rel="stylesheet" type="text/css" media="screen" />

<style type="text/css">
			BODY,
			HTML {
				padding: 0px;
				margin: 0px;
			}
			BODY {
				font-family: Verdana, Arial, Helvetica, sans-serif;
				font-size: 11px;
				background: #EEE;
				padding: 15px;
			}
			
			H1 {
				font-family: Georgia, serif;
				font-size: 20px;
				font-weight: normal;
			}
			
			H2 {
				font-family: Georgia, serif;
				font-size: 16px;
				font-weight: normal;
				margin: 0px 0px 10px 0px;
			}
			
			.example {
				float: left;
				margin: 15px;
			}
			
			.demo {
				width: 200px;
				height: 400px;
				border-top: solid 1px #BBB;
				border-left: solid 1px #BBB;
				border-bottom: solid 1px #FFF;
				border-right: solid 1px #FFF;
				background: #FFF;
				overflow: scroll;
				padding: 5px;
			}
			
		</style>

<script type="text/javascript">
  \$(document).ready( function() {
    \$('#container_id').fileTree({ root: '$dir', script:'../webservice/jqueryfiletree.cgi'}, function(file) {
        alert(file);
    });

});



</script>
</head>

<body>

<div class="example">
			<h2>Default options</h2>
			<div id="container_id" class="demo"></div>
</div>


</body>
</html>

HEAD

