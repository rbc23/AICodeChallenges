var name1 = "John";
var name2 = "Sarah";

name1 = name1.toLowerCase().replace(/\s/g, "");
name2 = name2.toLowerCase().replace(/\s/g, "");

var combinedName = name1 + name2;
var loveScore = 0;

for (var i = 0; i < combinedName.length; i++) {
  loveScore += combinedName.charCodeAt(i);
}

var lovePercentage = loveScore % 101;

console.log("The love percentage between " + name1 + " and " + name2 + " is " + lovePercentage + "%.");