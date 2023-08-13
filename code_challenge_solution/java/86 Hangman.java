```javascript
// Array of words to choose from
var words = ["javascript", "hangman", "game", "programming", "developer"];

// Select a random word from the array
var word = words[Math.floor(Math.random() * words.length)];

// Array to store the guessed letters
var guessedLetters = [];

// Number of remaining attempts
var attempts = 6;

// Function to display the board
function displayBoard() {
    var board = "";
    for (var i = 0; i < word.length; i++) {
        if (guessedLetters.indexOf(word[i]) !== -1) {
            board += word[i];
        } else {
            board += "_";
        }
    }
    return board;
}

// Function to check if the game is won
function isGameWon() {
    for (var i = 0; i < word.length; i++) {
        if (guessedLetters.indexOf(word[i]) === -1) {
            return false;
        }
    }
    return true;
}

// Function to check if the game is lost
function isGameLost() {
    return attempts === 0;
}

// Function to process the user's guess
function makeGuess(guess) {
    guessedLetters.push(guess);
    if (word.indexOf(guess) === -1) {
        attempts--;
    }
}

// Main game loop
while (!isGameWon() && !isGameLost()) {
    var guess = prompt("Guess a letter:");
    makeGuess(guess);
    console.log("Attempts remaining: " + attempts);
    console.log("Board: " + displayBoard());
}

// Game over message
if (isGameWon()) {
    console.log("Congratulations, you won!");
} else if (isGameLost()) {
    console.log("Sorry, you lost. The word was: " + word);
}
```

Note: This is a simplified version of Hangman without any user interface. The user is prompted to enter a letter and the game logic is displayed in the console.