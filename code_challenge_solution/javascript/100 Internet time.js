var date = new Date();
var minutes = date.getMinutes();
var seconds = date.getSeconds();
var decimalTime = (minutes * 60 + seconds) / 86400;
var swatchInternetTime = Math.floor(decimalTime * 1000);
console.log("Swatch Internet Time: " + swatchInternetTime);