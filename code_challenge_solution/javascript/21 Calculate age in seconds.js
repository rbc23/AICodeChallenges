let birthYear = prompt("Enter your birth year:");
let currentYear = new Date().getFullYear();
let ageInYears = currentYear - birthYear;
let ageInSeconds = ageInYears * 365 * 24 * 60 * 60;

console.log("Your age in seconds is: " + ageInSeconds);