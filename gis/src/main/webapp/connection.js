// set variables (should be read from server per ajax)
//var ubuntu1404tileserver = 'http://10.63.22.188/osm/';
// var ubuntu1404tileserver = 'http://192.168.178.102/osm/';
var ubuntu1404tileserver = 'http://ubuntu1404tileserver/osm/';
var tilesUrl = ubuntu1404tileserver + '{z}/{x}/{y}.png';
var zoom = 15;
var maxZoom = 18;
var zoomSpielplatzLayerTo = 13;
var center = [ 50.94135, 6.95819 ];
var attribution = 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, '
		+ '<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, '
		+ 'Imagery &copy; <a href="http://mapbox.com">WebBox</a>, '
		+ '<a href=\'' + ubuntu1404tileserver + 'slippymap.html\'>Tile Server</a>';
var infoboxContent = document.title;
