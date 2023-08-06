```javascript
// Higher or Lower

function higherOrLower() {
  let randomNumber = Math.floor(Math.random() * 100);
  let userGuess = parseInt(prompt("Guess a number between 0 and 100:"));
  
  if (userGuess > randomNumber) {
    console.log("Higher");
  } else if (userGuess < randomNumber) {
    console.log("Lower");
  } else {
    console.log("Correct guess!");
  }
}

higherOrLower();

// Heads and Tails

function headsOrTails() {
  let randomNum = Math.random();
  
  if (randomNum < 0.5) {
    console.log("Heads");
  } else {
    console.log("Tails");
  }
}

headsOrTails();

// Flip Coins

function flipCoins(numCoins) {
  let headsCount = 0;
  let tailsCount = 0;
  
  for (let i = 0; i < numCoins; i++) {
    if (Math.random() < 0.5) {
      headsCount++;
    } else {
      tailsCount++;
    }
  }
  
  console.log(`Heads: ${headsCount}`);
  console.log(`Tails: ${tailsCount}`);
}

flipCoins(10);
```

Note: The code assumes that it will run on a JavaScript environment where `console.log()` works for output.