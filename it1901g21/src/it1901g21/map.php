<!DOCTYPE html>
<html>
   <head>
  	 <title>Farmers sheep map</title>
      <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
      
      <style type="text/css">
         html { height: 100% }
         body { height: 100%; margin: 0; padding: 0 }
         #map-canvas { height: 100% }
      </style>

	<?PHP
	$user_name = "kennew_IT1901";
	$password = "imsdal";
	$database = "kennew_IT1901G21";
	$server = "jdbc:mysql://mysql.stud.ntnu.no";
	mysql_connect($server, $user_name, $password);
	?>
	
	<?php
		$xCo = 63.432338;
		$yCo = 10.355423;
	?>
      
      <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDt6UzO_jH4YBZC1gvCfYJM5jI_a0h-W8M&sensor=false"></script>
      <script type="text/javascript">
      	 
      	 var xCoordinate = "<?php echo $xCo; ?>";
      	 var yCoordinate = "<?php echo $yCo; ?>";
      	 
      	 var centr = new google.maps.LatLng(xCoordinate,yCoordinate);
      	 
         var locations = [
         	['NO', 63.432069, 10.352591, 4, "Sau 1"],
         	['NO', 63.430476,10.356796, 5, "Sau 2"],
         	];
         
         var map;
      	 var infowindow;
         
         function init() {
             var mapOptions = { 
             	zoom: 15, 
             	mapTypeId: google.maps.MapTypeId.ROADMAP,
             	center: centr
             	};
             map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
          	 infowindow = new google.maps.InfoWindow();
          	 plotCoordinates();
          }
           
         function plotCoordinates() {
           	for (var i = 0; i < locations.length; i++) {
        		var entity = locations[i];
        		var myLatLng = new google.maps.LatLng(entity[1], entity[2]);
        		var mark = new google.maps.Marker({
           			position: myLatLng,
            		map: map,
      	  		});
  				iWindow(mark, entity[4]);
  			 }
		}
	
		function iWindow(marker, title) {
    		google.maps.event.addListener(marker, 'click', function () {
        		infowindow.setContent(title);
        		infowindow.open(map, marker);
    		});
		}
		  
        window.onload = init;
        
      </script>
   </head>
   <body>
      <div id="map-canvas"></div>
   </body>
</html>