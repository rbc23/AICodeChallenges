let secretCode = ['R', 'G', 'B', 'Y'];
let maxGuesses = 10;

let currentGuess = 1;
let correctPosition = 0;
let correctColor = 0;

function getRandomCode() {
    let code = [];
  
    for (let i = 0; i < secretCode.length; i++) {
        let randomColor = Math.floor(Math.random() * 4);
        code.push(secretCode[randomColor]);
    }
  
    return code;
}

function evaluateGuess(guess, code) {
    let tempSecretCode = secretCode.slice();
    let tempGuess = guess.slice();
  
    for (let i = 0; i < code.length; i++) {
        if (tempGuess[i] === tempSecretCode[i]) {
            correctPosition++;
            tempGuess[i] = null;
            tempSecretCode[i] = null;
        }
    }
  
    for (let i = 0; i < code.length; i++) {
        let codeIndex = tempSecretCode.indexOf(tempGuess[i]);
        if (codeIndex > -1) {
            correctColor++;
            tempGuess[i] = null;
            tempSecretCode[codeIndex] = null;
        }
    }
}

function playGame() {
    let code = getRandomCode();
  
    while (currentGuess <= maxGuesses) {
        let guess = prompt("Enter your guess (choose 4 colors from R, G, B, Y):");
      
        if (guess && guess.length === 4) {
            let guessArray = guess.toUpperCase().split('');
            evaluateGuess(guessArray, code);
          
            if (correctPosition === 4) {
                alert("Congratulations! You cracked the code");
                break;
            } else {
                alert(`Incorrect guess. You have ${maxGuesses - currentGuess} guesses remaining. ${correctPosition} colors in the correct position and ${correctColor} colors in the wrong position.`);
                correctPosition = 0;
                correctColor = 0;
                currentGuess++;
            }
        } else {
            alert("Invalid guess. Please enter exactly 4 colors");
        }
    }
  
    if (currentGuess > maxGuesses) {
        alert("Game over. You couldn't crack the code");
    }
}

playGame();