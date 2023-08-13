let targetNumber;
let guessHigher;
let guessLower;

function generateRandomNumber() {
  targetNumber = Math.floor(Math.random() * 101);
}

function flipCoin() {
  const randomNumber = Math.random();

  if (randomNumber < 0.5) {
    return "Heads";
  } else {
    return "Tails";
  }
}

function playGame() {
  generateRandomNumber();
  
  console.log("Welcome to Higher or Lower, Heads and Tails!");
  console.log("--- Higher or Lower ---");
  console.log("Guess if the next number will be higher or lower than the target number.");
  
  const guessedNumber = Math.floor(Math.random() * 101);
  
  console.log("The target number is: " + targetNumber);
  console.log("Your guess is: " + guessedNumber);
  
  if ((guessedNumber < targetNumber && guessLower) || (guessedNumber > targetNumber && guessHigher)) {
    console.log("Congratulations! You guessed correctly!");
  } else {
    console.log("Sorry, better luck next time!");
  }
  
  console.log("--- Heads and Tails ---");
  
  const coinFlipResult = flipCoin();
  console.log("The coin landed on: " + coinFlipResult);
}

playGame();