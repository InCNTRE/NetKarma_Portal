 var ge;
      google.load("earth", "1");

      function ge_init() {
         google.earth.createInstance('map3d', initCB, failureCB);
      }

      function initCB(instance) {
         ge = instance;
         ge.getWindow().setVisibility(true);
      }

      function failureCB(errorCode) {
      }

      google.setOnLoadCallback(init);
