function initialize_gmap() {
        var myOptions = {
          center: new google.maps.LatLng(35, -95),
          zoom: 5,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            myOptions);

        var ctaLayer = new google.maps.KmlLayer('http://gmoc-db.grnoc.iu.edu/gmoc3d/gmoc_generate_maps.pl?aggregate=planetlab');
        ctaLayer.setMap(map);
      }

