```javascript
function calculateLovePercentage(name1, name2) {
  var name1Lower = name1.toLowerCase().replace(/\s/g, "");
  var name2Lower = name2.toLowerCase().replace(/\s/g, "");
  
  var name1Score = calculateNameScore(name1Lower);
  var name2Score = calculateNameScore(name2Lower);
  
  var totalScore = name1Score + name2Score;
  
  var lovePercentage = Math.round((totalScore % 100) * 100 / 100);
  
  return lovePercentage;
}

function calculateNameScore(name) {
  var score = 0;
  
  for (var i = 0; i < name.length; i++) {
    score += name.charCodeAt(i);
  }
  
  return score;
}

var name1 = prompt("Enter the first name:");
var name2 = prompt("Enter the second name:");

var percentage = calculateLovePercentage(name1, name2);
console.log("Love Percentage Between " + name1 + " and " + name2 + ": " + percentage + "%");
```
Note: This is a basic implementation of a love calculator and does not provide accurate results.