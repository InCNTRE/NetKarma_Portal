	var cache = {
		"target": "workspace",
		"workspace": {
			"query": "",
			"from": "",
			"to": "",
			"user": "",
			"selected": null,
		},
		"archive": {
			"query": "",
			"from": "",
			"to": "",
			"user": "",
			"selected": null,
		}
	};
	var dataArray = new Array();
	dataArray['root'] = 'query/';
	dataArray['script'] = cache["target"];
	dataArray['folderEvent'] = 'click';
	dataArray['expandSpeed'] = 750;
	dataArray['collapseSpeed'] = 750;
	dataArray['expandEasing'] = 'easeOutBounce';
	dataArray['collapseEasing'] = 'easeOutBounce';
	dataArray['loadMessage'] = 'Loading...';
	var fileHandler = function(obj) {
		var target = cache["target"];
		var file = $(obj).attr('rel');
		$(".selectedtree").removeClass('selectedtree');
		$(obj).addClass('selectedtree');
		cache[target]["selected"] = file;
		return true;
	};
	var directoryHandler = function(obj) {
		var target = cache["target"];
		var dir = $(obj).attr('rel');
		$(".selectedtree").removeClass('selectedtree');
		$(obj).addClass('selectedtree');
		cache[target]["selected"] = dir;
		updateAttributesAndMetadata(target);
		return true;
	};
	var showHandler = function() {
		var target = cache["target"];
		$("#data").fadeTo(0,1);
	};
	
	$.fx.speeds._default = 1000;
	
	
	function bootstrap(query, target) {
		$("#" + target + "tab").click();
		$("#search").val(query);
		$("#searchform").submit();
		$.get("data?dir=query/" + escape(query.replace('/','_____') + "/METADATA.txt") + "&format=uncompressed&response=retrieve&target=" + target, function(data) {
			$("#metadata").html(handleMetadata(data));
			$("#metadata").fadeTo(0,1);
		});
		$.get("http://mda.doregistry.org/data?dir=query/" + escape(query.replace('/','_____') + "/internal.attributes") + "&format=uncompressed&response=retrieve&target=" + target, function(data) {
		       $("#attributes").html(handleAttributes(data));
		       $("#attributes").fadeTo(0,1);
		});
	};
	function updateAttributesAndMetadata(target) {
		
		$("#metadata").fadeTo(0, 0.2);
		$("#attributes").fadeTo(0, 0.2);
		var metadata = getMetadataPath();
		if(metadata != null) {
			$.get("http://mda.doregistry.org/data?dir=" + escape(metadata) + "&format=uncompressed&response=retrieve&target=" + target, function(data) {
				$("#metadata").html(handleMetadata(data));
				$("#metadata").fadeTo(0,1);
			});
		}
		var attributes = getAttributePath();
		if(attributes != null) {
			$.get("http://mda.doregistry.org/data?dir=" + escape(attributes) + "&format=uncompressed&response=retrieve&target=" + target, function(data) {
				$("#attributes").html(handleAttributes(data));
				$("#attributes").fadeTo(0,1);
			});
		}
	};
	function handleQueryUI() {
		$("#query").html('<div class="search"><table><tbody><tr><td><input id="search" size="55"/><span id="querywarning" class="ui-state-error ui-corner-all"></span><button>Search</button></td></tr><tr><td><label for="from">From&nbsp;</label><input type="text" id="from" name="from"/>&nbsp;<label for="to">To&nbsp;</label><input type="text" id="to" name="to"/></td></tr><tr><td><label for="user">User&nbsp;</label><input type="text" id="user" name="user"/></td></tr></div>');
            var dates = $("#from, #to")
                    .datepicker(
                        {
                            defaultDate : "+1w",
                            changeMonth : true,
                            numberOfMonths : 2,
                            onSelect:   function(selectedDate) {
                                        var option = this.id == "from" ? "minDate" : "maxDate",
                                        instance = $(this).data("datepicker");
                                        date = $.datepicker
                                        .parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat, selectedDate, instance.settings);
                                        dates.not(this).datepicker("option", option, date);
                                    }
                        });
        $("#querywarning").hide();
		$("button, input:text", ".search").button();
	};
	/*
	function handleFilters() {
		var target = cache["target"];
		cache[target]["filter"] = $(this).attr('id');
		if ($(this).attr('id') == "time") {

			$("#query").html('<div class="search"><label for="from">From</label><input type="text" id="from" name="from"/><label for="to">to</label><input type="text" id="to" name="to"/><span id="querywarning" class="ui-state-error ui-corner-all"></span><button>Search</button></div>');
			var dates = $("#from, #to")
					.datepicker(
						{
							defaultDate : "+1w",
							changeMonth : true,
							numberOfMonths : 2,
							onSelect: 	function(selectedDate) {
										var option = this.id == "from" ? "minDate" : "maxDate",
										instance = $(this).data("datepicker");
										date = $.datepicker
										.parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat, selectedDate, instance.settings);
										dates.not(this).datepicker("option", option, date);
									}
						});
			
		} else {
			$("#query").html('<div class="search"><input id="search" size="55"/><span id="querywarning" class="ui-state-error ui-corner-all"></span><button>Search</button></div>');
		}
		$("#querywarning").hide();
		$("button, input:text", ".search").button();
	};
	*/
	function handleLinks(action, type) {
		var target = cache["target"];
		var selected = cache[target]["selected"];
		if (selected == null) {
		    $("#dialog").html("<p>No object previously selected</p>");
		    $("#dialog").dialog("open");
		}
		else {
			var message;
			if(action == 'archive') {  
				$.ajax({
				    url: 'http://mda.doregistry.org/data',
				    data:  'dir=' + getObjectPath() + '&command=archive&target=workspace',
				    dataType: 'json',
				    type: "GET",
				    success: function(response) {
					    message = response['message'];
					    $("#dialog").html(message);
					    $("#dialog").dialog("open");
				    }
				});

			}
			else if(action == 'download') {
				if(type == 'object') {
					$("#downloadFrame").get(0).src = "data?dir=" + escape(selected) + "&format=zip&response=download&target=" + target;
				}
				else {
					var metadata = getMetadataPath();
					if(metadata != null) {
					    $("#downloadFrame").get(0).src = "http://mda.doregistry.org/data?dir=" + escape(metadata) + "&format=uncompressed&response=download&target=" + target;
					}
				}
			}
			else if(action == 'reference') {
				window.open('http://hdl.handle.net/' + escape(getDigitalObjectPath()));
				return false;
			}
		}
	};
	function handleMetadata(data) {
		var html = "";
		if(data.indexOf("\n") > 0) {
			var lines = data.split("\n");
			for(var num in lines) {
				var index = lines[num].indexOf(":");
				if(index > 0) {
					html += "<i>" + lines[num].substring(0, (index)) + "</i>: " + lines[num].substring(index+1) + "<br/>";
				}
				else {
					html += lines[num] + "<br/>";
				}
			}
		}
		else {
			var index = data.indexOf(":");
			if(index > 0) {
				html += "<i>" + data.substring(0, (index)) + "</i>: " + data.substring(index+1);
			}
			else {
				html += data;
			}
		}
		return html;
	};
	function handleAttributes(data) {
		var html = "";
		for (var key in data) {
			html += "<i>" + key + "</i>: " + data[key] + "<br/>";
		}
		return html;
	};
	function getMetadataPath() {
		var target = cache["target"];
		var selected = 	cache[target]["selected"];
		if(selected != null && selected.length > 0) {
			var queryIndex = selected.indexOf("/", 0);
			var objectIndex = selected.indexOf("/", queryIndex+1);
			var metadata = selected.substring(0,objectIndex+1) + "METADATA.txt";
			return metadata;
		}
		return null;
	};
	function getAttributePath() {
		var target = cache["target"];
		var selected = 	cache[target]["selected"];
		if(selected != null && selected.length > 0) {
			var queryIndex = selected.indexOf("/", 0);
			var objectIndex = selected.indexOf("/", queryIndex+1);
			var attributes = selected.substring(0,objectIndex+1) + "internal.attributes";
			return attributes;
		}
		return null;
	};

	function getObjectPath() {
		var target = cache["target"];
		var selected = 	cache[target]["selected"];
		if(selected != null && selected.length > 0) {
			var queryIndex = selected.indexOf("/", 0);
			var objectIndex = selected.indexOf("/", queryIndex+1);
			var object = selected.substring(0,objectIndex);
			return object;
		}
		return null;
	};
	function getDigitalObjectPath() {
		var target = cache["target"];
		var selected = 	cache[target]["selected"];
		if(selected != null && selected.length > 0) {
			var queryIndex = selected.indexOf("/", 0);
			var objectIndex = selected.indexOf("/", queryIndex+1);
			var object = selected.substring(queryIndex+1,objectIndex).replace('_____','/');
			return object;
		}
		return null;
	}
	function getSelectedPath() {
		var target = cache["target"];
		var selected = 	cache[target]["selected"];
		if(selected != null && selected.length > 0) {
			var queryIndex = selected.indexOf("/", 0);
			var path = selected.substring(queryIndex+1);
			return path;
		}
		return "";
	};
	function validateAndSearch() {
		clear();
		var valid = false;
		if($("#from").val().length > 0 || $("#to").val().length > 0) {
			var regex = /(^[0-3]?[0-9])\/([01]?[0-9])\/([12][90][0-9][0-9]$)/;
			if ($("#from").val().match(regex)==null || $("#to").val().match(regex)==null) {
			}
			else {
				valid = true;
			}
		}
		if(!valid) {
			if($("#search").val().length > 0) {
				valid = true;
			}
		}
		if(!valid) {
			if($("#user").val().length > 0) {
				valid = true;
			}
		}
		if(!valid) {
			$("#querywarning").html("Invalid query.");
			$("#querywarning").show();
			return false;
		}
		return search();
	};
	
	function search() {
		var target = cache["target"];
		
		var query = "";
		if($("#search").val().length > 0) {
			query = "text:" + $("#search").val();
		}
		if($("#from").val().length > 0 && $("#to").val().length > 0) {
			if(query.length > 0)
				query += "&";
			query += "from:" + $("#from").val() + "&to:" + $("#to").val();
		}
		if($("#user").val().length > 0) {
			if(query.length > 0)
				query += "&";
			query += "user:" + $("#user").val();
		}
		query = $().crypt({method:"b64enc",source:query}) + "/";
		dataArray['root'] = query;
		$("#results").show();
		
		$("#data").fadeTo(0, 0.2);
		$("#metadata").fadeTo(0, 0.2);
		$("#attributes").fadeTo(0, 0.2);
		$("#data").fileTree(dataArray, fileHandler, directoryHandler, showHandler);  
		return false;
	};
	
	function clear() {
		var target = cache["target"];
		
		cache[target]["selected"] = null;
		$("#querywarning").hide();
		$("#results").hide();
		$("#metadata").html("");
		$("#attributes").html("");
	};
	function reset() {
		
		swap();
		
	};
	function swap() {
		var target = null;
		if(cache["target"] == 'workspace') {
			target = 'archive';
		}
		else {
			target = 'workspace';
		}
		
		var query = $("#search").val();
		var from = $("#from").val();
		var to = $("#to").val();
		var user = $("#user").val();
		
		cache[target] = {
			"query": query,
			"from": from,
			"to": to,
			"user": user,
			"selected": cache[target]["selected"]
		};
		
		target = cache["target"];
		
		handleQueryUI();
		$("#search").val(cache[target]["query"]);
		$("#from").val(cache[target]["from"]);
		$("#to").val(cache[target]["to"]);
		$("#user").val(cache[target]["user"]);
		if(cache[target]["query"].length > 0 || (cache[target]["from"].length > 0 && cache[target]["to"].length > 0) || (cache[target]["user"].length > 0)) {	
			updateAttributesAndMetadata(target);
			$("#searchform").submit();				
		}
		else {
			$("#results").hide();
		}
		
	};
