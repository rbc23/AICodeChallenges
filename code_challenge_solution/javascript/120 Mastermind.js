let secretCode = [];
let guessCount = 0;

function generateSecretCode() {
  for (let i = 0; i < 4; i++) {
    secretCode.push(Math.floor(Math.random() * 6) + 1);
  }
}

function checkGuess(guess) {
  let blackPegs = 0;
  let whitePegs = 0;
  let codeCopy = secretCode.slice();
  let guessCopy = guess.slice();

  // Check for black pegs
  for (let i = 0; i < 4; i++) {
    if (guessCopy[i] === codeCopy[i]) {
      blackPegs++;
      guessCopy[i] = 0;
      codeCopy[i] = 0;
    }
  }

  // Check for white pegs
  for (let i = 0; i < 4; i++) {
    if (guessCopy[i] !== 0) {
      let index = codeCopy.indexOf(guessCopy[i]);
      if (index > -1) {
        whitePegs++;
        codeCopy[index] = 0;
      }
    }
  }

  return [blackPegs, whitePegs];
}

generateSecretCode();

while (guessCount < 10) {
  let guess = prompt("Enter a 4-digit guess (each digit between 1 and 6): ");
  guess = guess.split("").map(Number);

  if (guess.length !== 4) {
    alert("Invalid guess! Please enter exactly 4 digits.");
    continue;
  }

  let result = checkGuess(guess);

  console.log("Black pegs: " + result[0]);
  console.log("White pegs: " + result[1]);

  if (result[0] === 4) {
    console.log("Congratulations! You've cracked the code.");
    break;
  }

  guessCount++;
}

if (guessCount === 10) {
  console.log("Game over! You couldn't crack the code. The secret code was: " + secretCode.join(""));
}