```javascript
// Hangman word list
var words = ["hangman", "javascript", "programming", "computer", "game", "technology"];

// Select a random word from the list
var word = words[Math.floor(Math.random() * words.length)];

// Generate the initial hidden word
var hiddenWord = "";
for (var i = 0; i < word.length; i++) {
  hiddenWord += "_";
}

// Tracks the remaining number of guesses
var remainingGuesses = 6;

// Tracks the letters that have been guessed
var guessedLetters = [];

// Game loop
while (remainingGuesses > 0 && hiddenWord.includes("_")) {
  console.log(hiddenWord);
  console.log("Remaining guesses: " + remainingGuesses);
  console.log("Guessed letters: " + guessedLetters);

  var guess = prompt("Guess a letter:").toLowerCase();

  // Validate input
  if (guess.length !== 1 || !/[a-z]/.test(guess)) {
    console.log("Please enter a single letter.");
    continue;
  }

  // Check if the letter has already been guessed
  if (guessedLetters.includes(guess)) {
    console.log("You have already guessed that letter.");
    continue;
  }

  // Add the guessed letter to the list
  guessedLetters.push(guess);

  // Update the hidden word with the guessed letter
  var newHiddenWord = "";
  var found = false;
  for (var j = 0; j < word.length; j++) {
    if (word[j] === guess) {
      newHiddenWord += guess;
      found = true;
    } else {
      newHiddenWord += hiddenWord[j];
    }
  }

  // Incorrect guess
  if (!found) {
    remainingGuesses--;
    console.log("Incorrect guess.");
  } else {
    hiddenWord = newHiddenWord;
    console.log("Correct guess.");
  }
}

// Game over
if (hiddenWord.includes("_")) {
  console.log("Game over. You lost. The word was: " + word);
} else {
  console.log("Congratulations! You won!");
}
```