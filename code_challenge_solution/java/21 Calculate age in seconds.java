let currentDate = new Date();
let birthDate = new Date("1990-01-01");

let ageInSeconds = (currentDate.getTime() - birthDate.getTime()) / 1000;

console.log("Age in seconds: " + ageInSeconds);