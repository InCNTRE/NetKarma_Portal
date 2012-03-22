NetKarma Portal 
================

The NetKarma portal provides a easy way to load data into the NetKarma Provenance store and visualising the workflow information. It is closely coupled with other GENI systems to allow 

The NetKarma Portal provides a easy way for experimenters to:

 * Create a new experiment,pointed to by a universial handle (DOI or ARK)
 * Capture experiment workflow information from log files
 * Integrate GENI topology information to an experiment
 * Intigrate measurements from GENI I&M implementations to an experiment
 * Visualise workflow, topology, measurement, status
 * Produce unified experment data representations such as a KML "movie"
 * Interface to archival services (local and iRODS)
 * Browse the work of other experimenters (given proper permissions)

More info on the Portal is available at:
 * http://groups.geni.net/geni/wiki/netKarma/GEC13_report 
 * http://groups.geni.net/geni/attachment/wiki/netKarma/GEC13_report/NetKarma_Portal.pdf
 
Information about NetKarma is located at:
 * http://pti.iu.edu/d2i/provenance_netKarma
 * http://groups.geni.net/geni/wiki/netKarma

Dependancies 
------------

The dependancies for the NetKarma portal are: 

 * jQuery - http://jquery.com/
 * CytoscapeWeb - http://cytoscapeweb.cytoscape.org/
 * DataTable jQuery plugin - http://datatables.net/
 * jQuery File Tree - http://www.abeautifulsite.net/blog/2008/03/jquery-file-tree/
 
Optional dependancies include:

 * jqPlot - http://www.jqplot.com/
 * Openlayers - http://openlayers.org/
 
The easest way to link with the NetKarma code is to create a /js directory in the Document Root of your web server
and install the libraries.  

All of the Javascript locations should be located at the top of the header.html file

Most of the JavaScript dependancies also have CDN hosted versions but local instalation will help performance

Licence 
-------

The NetKarma Portal is released under the GENI Public Licence.


Copyright (c) 2012 The Trustees of Indiana University 
  
Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
and/or hardware specification (the “Work”) to deal in the Work without restriction, including 
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or 
sell copies of the Work, and to permit persons to whom the Work is furnished to do so, subject to 
the following conditions:  

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Work.  

THE WORK IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
OUT OF OR IN CONNECTION WITH THE WORK OR THE USE OR OTHER DEALINGS 
IN THE WORK. 

