```javascript
// Define an array of words for the game
var words = ["hangman", "javascript", "programming", "computer", "code", "developer"];

// Choose a random word from the array
var randomWord = words[Math.floor(Math.random() * words.length)];

// Create an array to hold the correctly guessed letters
var guessedLetters = [];

// Create an array to hold the incorrectly guessed letters
var incorrectLetters = [];

// Create a variable to track the number of guesses remaining
var guessesRemaining = 6;

// Function to check if a letter is in the chosen word
function checkLetter(letter) {
  // Check if the letter has already been guessed
  if (guessedLetters.indexOf(letter) !== -1 || incorrectLetters.indexOf(letter) !== -1) {
    return; // Exit the function if the letter has already been guessed
  }

  // Check if the letter is in the chosen word
  if (randomWord.indexOf(letter) !== -1) {
    // Add the letter to the guessedLetters array
    guessedLetters.push(letter);
    // Check if the player has won
    if (checkWin()) {
      console.log("Congratulations! You won!");
    }
  } else {
    // Add the letter to the incorrectLetters array
    incorrectLetters.push(letter);
    // Decrease the number of guesses remaining
    guessesRemaining--;

    // Check if the player has lost
    if (guessesRemaining === 0) {
      console.log("Game over! The word was: " + randomWord);
    }
  }
}

// Function to check if the player has won
function checkWin() {
  for (var i = 0; i < randomWord.length; i++) {
    // Check if any letters in the randomWord are not yet guessed
    if (guessedLetters.indexOf(randomWord[i]) === -1) {
      return false; // Player has not won yet
    }
  }
  return true; // Player has guessed all letters correctly
}

// Function to display the current progress
function displayProgress() {
  var progress = "";
  for (var i = 0; i < randomWord.length; i++) {
    // Check if the letter has been guessed
    if (guessedLetters.indexOf(randomWord[i]) !== -1) {
      progress += randomWord[i] + " "; // Add the guessed letter to the progress string
    } else {
      progress += "_ "; // Add an underscore for letters not yet guessed
    }
  }
  console.log("Progress: " + progress);
}

// Function to display the incorrect guesses
function displayIncorrectLetters() {
  console.log("Incorrect letters: " + incorrectLetters.join(", "));
}

// Function to display the remaining guesses
function displayGuessesRemaining() {
  console.log("Guesses remaining: " + guessesRemaining);
}

// Function to start the game
function startGame() {
  // Display initial progress, incorrect letters, and remaining guesses
  displayProgress();
  displayIncorrectLetters();
  displayGuessesRemaining();

  // Prompt the player for their next guess
  var guess = prompt("Please enter your next guess:");
  checkLetter(guess);

  // Continue prompting the player for guesses until the game is over
  if (guessesRemaining > 0 && !checkWin()) {
    startGame();
  }
}

// Start the game
startGame();
```