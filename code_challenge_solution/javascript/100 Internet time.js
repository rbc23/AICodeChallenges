var date = new Date();
var hours = date.getUTCHours();
var minutes = date.getUTCMinutes();
var seconds = date.getUTCSeconds();

var swatchTime = (hours * 3600 + minutes * 60 + seconds) / 86.4;

console.log("The current Swatch Internet Time is: " + swatchTime);