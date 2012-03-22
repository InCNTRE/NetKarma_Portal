window.onload=cyto_wf();

function load_cyto_wf() {

   request = createRequest();

   if (request == null) {
	alert ("Unable to create request");
	return;
   }

   var url = "Ans.graphml";

   request.open("GET",url,true);
   request.onreadystatechange = update_cyto;
   request.send(null);

   
	
} 


function  cyto_wf() {
                // id of Cytoscape Web container div
                var div_id = "cytoscapeweb";
                
                // you could also use other formats (e.g. GraphML) or grab the network data via AJAX
                var networ_json = {
		    // Data Schema for custom attributes
		    dataSchema: {
			nodes: [ { name: "label", type: "string" },
				 {  name: "type", type: "string" }
			       ],				 
			edges: [ { name: "label", type: "string" },
                                 {  name: "type", type: "string" }
                               ]
		    },

		    data: {
                        nodes: [ { id: "1", label: "chsmall", type: "agent" },
				 { id: "2", label: "sample init", type: "process" }, 
				 { id: "3", label: "pl1.iub.indiana.edu", type: "artifact" },
				 { id: "4", label: "pl2.iub.indiana.edu", type: "artifact" },
			       ],
                        edges: [ { id: "2to1", target: "1", source: "2", type: "WasControlledBy", label: "WasControlledBy", directed: true },
				 { id: "2to3", target: "3", source: "2", type: "Used", label: "Used" , directed: true },
				 { id: "2to4", target: "4", source: "2", type: "Used", label: "Used" , directed: true },
				]
                    }
                };

  		var visual_style = {
                    global: {
                        backgroundColor: "#ABCFD6"
                    },
                    nodes: {
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

		  var draw_options = {
		    // your data goes here
                    network: networ_json,
                    // show edge labels too
                    edgeLabelsVisible: true,
		    // set the style at initialisation
                    visualStyle: visual_style
		 }

                vis.draw(draw_options);
}
