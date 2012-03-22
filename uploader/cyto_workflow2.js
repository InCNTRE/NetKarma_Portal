//window.onload=load_cyto_wf();


	

function createRequest_wf() {

  try {
     request = new XMLHttpRequest();
  } catch (tryMS) {
    try {
        request = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (failed) {
	request = null;
    }
   }

   return request;
}


function load_cyto_wf(file) {

   request = createRequest_wf();

   if (request == null) {
	alert ("Unable to create request");
	return;
   }

   //var url = "bin/test.xgmml";
   if (file) {
      var url = "bin/" + file + ".xgmml";
   } else {
      var url = "bin/test.xgmml";
   }

   request.open("GET",url,true);
   request.onreadystatechange = update_cyto_wf;
   request.send(null);

   
	
} 


function update_cyto_wf() {


  
   if (request.readyState == 4) {
	if (request.status == 200) {

	  //var resp = request.responseText;
          // var network_json = JSON.parse(resp); 
	  var network_json = request.responseText;
	  //document.getElementById("note").innerHTML += "<p>" + resp + "</p>";

	   $( "#slider" ).slider({ range: 'min' });
	   $( "#slider" ).slider( "option", "range", 'min' ); 

                // id of Cytoscape Web container div
                var div_id = "cytoscapeweb";
                

  		var visual_style = {
                    global: {
                        backgroundColor: "#ABCFD6"
                    },
                    nodes: {
			label: { passthroughMapper: { attrName: "id" } } ,
			shape: { 
				discreteMapper: {
                               		 attrName: "type",
					 entries : [ 
						{ attrValue: "agent", value: "OCTAGON"},
					        { attrValue: "process", value: "SQUARE"},
						{ attrValue: "artifact", value: "OVAL"},
						]
					}
				} 
			},
		    edges: {
		        width: 3,
			color: { 
                                discreteMapper: {
                                         attrName: "type",
                                         entries : [ 
                                                { attrValue: "WasControlledBy", value: "#0B94B1"},
                                                { attrValue: "Used", value: "#99FF66"},
						{ attrValue: "WasGeneratedBy", value: "#99FF66"},
                                                ]
                                        }
                                }
                        }
		};

					
                
                // initialization options
                var options = {
                    // where you have the Cytoscape Web SWF
                    swfPath: "/portal/cytoscapeweb/swf/CytoscapeWeb",
                    // where you have the Flash installer SWF
                    flashInstallerPath: "/portal/cytoscapeweb/playerProductInstall",
		    
                };
                
                // init and draw
                var vis = new org.cytoscapeweb.Visualization(div_id, options);


		vis.ready(function() {
		     vis.addListener("click", "nodes", function(event) {
                        handle_click(event);
                    })
                    .addListener("click", "edges", function(event) {
                        handle_click(event);
                    });

		    $("#showNodeLabels").attr("checked", vis.nodeLabelsVisible());
		    $("#showEdgeLabels").attr("checked", vis.edgeLabelsVisible());

                    
                    function handle_click(event) {
                         var target = event.target;
                         
                         clear();
                         //print("Id: " + target.data["id"] + "<br>label: " + target.data["label"] + "<br> Type: " + target.data["type"]);

			var tbl = "<table border=\"1\">\n<tr><th>Name</th><th>Value</th></tr>\n";
                        // Loop through target data
                        for (entry in target.data) {
                             tbl += "<tr><td>" + entry + "</td><td>" + target.data[entry] + "</td></tr>\n";
                        }

                        tbl += "</table>";
                        print (tbl);


                    }
                    
                    function clear() {
                        document.getElementById("note_wf").innerHTML = "";
                    }
                
                    function print(msg) {
                        document.getElementById("note_wf").innerHTML += "<p> foo: " + msg + "</p>";
                    }

		    $("#showNodeLabels").change(function(evt) {
			  vis.nodeLabelsVisible($("#showNodeLabels").is(":checked"));
		    });

		   $("#showEdgeLabels").change(function(evt) {
                          vis.edgeLabelsVisible($("#showEdgeLabels").is(":checked"));
    		   });



                });

		  var draw_options = {
		    // your data goes here
                    network: network_json,
		    // set the style at initialisation
                    visualStyle: visual_style
		 }

                vis.draw(draw_options);

	}
     }
}  
