const weight = prompt("Enter your weight in kilograms: ");
const height = prompt("Enter your height in meters: ");

const bmi = weight / (height ** 2);
console.log("Your BMI is: " + bmi.toFixed(2));