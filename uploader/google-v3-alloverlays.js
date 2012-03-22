var map;

function init() {
    map = new OpenLayers.Map('map', {allOverlays: true});
    map.addControl(new OpenLayers.Control.LayerSwitcher());
    
    // the SATELLITE layer has all 22 zoom level, so we add it first to
    // become the internal base layer that determines the zoom levels of the
    // map.
    var gsat = new OpenLayers.Layer.Google(
        "Google Satellite",
        {type: google.maps.MapTypeId.SATELLITE, numZoomLevels: 22, visibility: false}
    );
    var gphy = new OpenLayers.Layer.Google(
        "Google Physical",
        {type: google.maps.MapTypeId.TERRAIN, visibility: true}
    );
    var gmap = new OpenLayers.Layer.Google(
        "Google Streets", // the default
        {numZoomLevels: 20, visibility: false}
    );
    var ghyb = new OpenLayers.Layer.Google(
        "Google Hybrid",
        {type: google.maps.MapTypeId.HYBRID, numZoomLevels: 22, visibility: false}
    );

    var kml = new OpenLayers.Layer.Vector(
        "KML",
        { strategies: [new OpenLayers.Strategy.Fixed()],
          protocol: new OpenLayers.Protocol.HTTP({
                url: "pl6.kml",
                format: new OpenLayers.Format.KML({
                    extractStyles: true,
                    extractAttributes: true,
		    maxDepth: 2
                })
            })
	});

   var mapnik = new OpenLayers.Layer.OSM();

    map.addLayers([gsat, gphy, gmap, ghyb, mapnik,kml]);

    // Google.v3 uses EPSG:900913 as projection, so we have to
    // transform our coordinates
    map.setCenter(new OpenLayers.LonLat(-100, 38).transform(
        new OpenLayers.Projection("EPSG:4326"),
        map.getProjectionObject()
    ), 4);
}


