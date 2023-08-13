let weight = prompt("Enter your weight in kilograms:");
let height = prompt("Enter your height in meters:");

let bmi = weight / (height * height);

console.log("Your BMI is: " + bmi.toFixed(2));