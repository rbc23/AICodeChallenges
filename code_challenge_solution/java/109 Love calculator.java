// Function to calculate love percentage between two names
function loveCalculator(name1, name2) {
   var lovePercentage = Math.random() * 100;
   lovePercentage = Math.floor(lovePercentage) + 1;
   return "Love percentage between " + name1 + " and " + name2 + " is " + lovePercentage + "%";
}

// Example usage
var name1 = "John";
var name2 = "Jane";
console.log(loveCalculator(name1, name2));