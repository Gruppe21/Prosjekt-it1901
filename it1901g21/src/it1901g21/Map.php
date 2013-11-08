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

	<?php
	$FarmerID = $_GET['farmerid'];
	$db = mysql_connect("mysql.stud.ntnu.no", "kennew_IT1901", "imsdal");
	mysql_select_db("kennew_IT1901G21", $db);
	
	$result = mysql_query("SELECT Id, Xpos, Ypos FROM Sheep WHERE FarmerId = '$FarmerID'", $db);
	$start = '';
	$arr = array();
	
	while($row = mysql_fetch_assoc($result)){
		if ($start == '') {
			$start = $row['Xpos'].', '.$row['Ypos'];
		}
		$arr[] = '['.$row['Xpos'].', '.$row['Ypos'].', \''.$row['Id'].'\']';
	}
	
	?>
      
      <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDt6UzO_jH4YBZC1gvCfYJM5jI_a0h-W8M&sensor=false"></script>
      <script type="text/javascript">
      	 
      	 var centr = new google.maps.LatLng(<?php echo $start; ?>);
      	 
         var locations = [
         	<?php echo implode(',', $arr); ?>
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
        		var myLatLng = new google.maps.LatLng(entity[0], entity[1]);
        		var mark = new google.maps.Marker({
           			position: myLatLng,
            		map: map,
      	  		});
  				iWindow(mark, entity[2]);
  			 }
		}
	
		function iWindow(marker, title) {
    		google.maps.event.addListener(marker, 'click', function () {
        		infowindow.setContent("Sheep ID: "+title);
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
