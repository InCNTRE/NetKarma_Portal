     var ge;
         var tour;
         google.load("earth", "1");

         function init() {
            google.earth.createInstance('map3d', initCB, failureCB);
         }

         function initCB(instance) {
            ge = instance;
            ge.getWindow().setVisibility(true);
            ge.getNavigationControl().setVisibility(ge.VISIBILITY_SHOW);

            //var href = 'http://code.google.com/apis/kml/documentation/kmlfiles/complete_tour_example.kml';
	    var href = 'http://netkarma.testlab.grnoc.iu.edu/portal/uploader/pl5.kml';
            google.earth.fetchKml(ge, href, fetchCallback);

            function fetchCallback(fetchedKml) {
               // Alert if no KML was found at the specified URL.
               if (!fetchedKml) {
                  setTimeout(function() {
                     alert('Bad or null KML');
                  }, 0);
                  return;
               }

               // Add the fetched KML into this Earth instance.
               ge.getFeatures().appendChild(fetchedKml);

               // Walk through the KML to find the tour object; assign to variable 'tour.'
               walkKmlDom(fetchedKml, function() {
                  if (this.getType() == 'KmlTour') {
                     tour = this;
                     return false;
                  }
               });
		
	      ge.getTourPlayer().setTour(tour);
            }
         }

         function failureCB(errorCode) {
         }

         // Tour control functions.
         function enterTour() {
            if (!tour) {
               alert('No tour found!');
               return;
            }
            ge.getTourPlayer().setTour(tour);
         }
         function playTour() {
            ge.getTourPlayer().play();
         }
         function pauseTour() {
            ge.getTourPlayer().pause();
         }
         function resetTour() {
            ge.getTourPlayer().reset();
         }
         function exitTour() {
            ge.getTourPlayer().setTour(null);
         }

         google.setOnLoadCallback(init);

