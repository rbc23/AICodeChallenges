// BMI calculator
var weight = prompt("Enter your weight in kilograms: ");
var height = prompt("Enter your height in meters: ");

var bmi = weight / (height * height);
console.log("Your BMI is: " + bmi.toFixed(2));