```javascript
// Initialize game variables
let sequence = [];
let clickedSequence = [];
let level = 0;
let gameStarted = false;
let gameLost = false;

// Generate a random button sequence
function generateSequence() {
  sequence = [];
  for (let i = 0; i < 10; i++) {
    const randomNum = Math.floor(Math.random() * 4);
    sequence.push(randomNum);
  }
}

// Play next sequence
function playSequence() {
  clickedSequence = [];
  for (let i = 0; i <= level; i++) {
    const button = document.querySelector(`[data-id='${sequence[i]}']`);
    setTimeout(() => {
      highlightButton(button);
    }, 1000 * i);
  }
}

// Highlight button
function highlightButton(button) {
  button.classList.add('active');
  setTimeout(() => {
    button.classList.remove('active');
  }, 500);
}

// Start the game
function startGame() {
  if (!gameStarted) {
    gameStarted = true;
    generateSequence();
    playSequence();
  }
}

// Button click event
function handleClick(e) {
  if (!gameStarted) return;
  
  const button = e.target;
  const id = parseInt(button.getAttribute('data-id'));
  clickedSequence.push(id);
  highlightButton(button);
  checkSequence();
}

// Check if sequence is correct
function checkSequence() {
  if (clickedSequence.length === level + 1) {
    if (clickedSequence.every((value, index) => value === sequence[index])) {
      if (level === 9) {
        endGame('You won!');
      } else {
        level++;
        playSequence();
      }
    } else {
      endGame('Game over!');
    }
  }
}

// End the game
function endGame(message) {
  gameStarted = false;
  gameLost = true;
  alert(message);
}

// Clear game variables
function resetGame() {
  sequence = [];
  clickedSequence = [];
  level = 0;
  gameStarted = false;
  gameLost = false;
}

// Event listeners for button clicks
const buttons = document.querySelectorAll('.button');
buttons.forEach(button => {
  button.addEventListener('click', handleClick);
});

// Event listener for the start button
const startButton = document.querySelector('#start-button');
startButton.addEventListener('click', startGame);

// Event listener for the reset button
const resetButton = document.querySelector('#reset-button');
resetButton.addEventListener('click', resetGame);
```

This code assumes that there is an HTML file with buttons having the class "button" and a start button with the ID "start-button" and a reset button with the ID "reset-button". Each button should have a unique data-id attribute ranging from 0 to 3.