let coins = ["Heads", "Tails"];
let randomCoin = Math.floor(Math.random() * 2);
let userChoice = prompt("Guess higher or lower (h/l) or flip coins (f):");

if (userChoice === "h" || userChoice === "l") {
  let randomNum = Math.floor(Math.random() * 100) + 1;
  let computerGuess = Math.floor(Math.random() * 100) + 1;
  console.log("Random Number: " + randomNum);
  console.log("Computer's Guess: " + computerGuess);
  
  if ((randomNum > computerGuess && userChoice === "h") || (randomNum < computerGuess && userChoice === "l")) {
    console.log("You guessed correctly!");
  } else {
    console.log("Wrong guess, try again.");
  }
} else if (userChoice === "f") {
  console.log("Coin flipped: " + coins[randomCoin]);
  let userGuess = prompt("Heads or Tails (h/t):");
  
  if (userGuess === coins[randomCoin]) {
    console.log("You guessed correctly!");
  } else {
    console.log("Wrong guess, try again.");
  }
} else {
  console.log("Invalid choice.");
}