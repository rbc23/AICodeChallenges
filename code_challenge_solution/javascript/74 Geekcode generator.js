let name = prompt("What is your name?");
let age = prompt("How old are you?");
let occupation = prompt("What is your occupation?");
let favoriteLanguage = prompt("What is your favorite programming language?");

let geekCode = `GEEKCODE START - ${name}'s GeekCodeSignature
AGE: ${age}
OCCUPATION: ${occupation}
FAVORITE_LANGUAGE: ${favoriteLanguage}
GEEKCODE END`;

console.log(geekCode);