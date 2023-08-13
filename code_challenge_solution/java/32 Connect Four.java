Sure! Here's the JavaScript code for a Connect Four game:

```javascript
// Define variables
const player1 = "Red";
const player2 = "Yellow";
let currentPlayer = player1;
let gameBoard = [];
const numRows = 6;
const numCols = 7;

// Create game board
function createGameBoard() {
  for (let row = 0; row < numRows; row++) {
    gameBoard[row] = [];
    for (let col = 0; col < numCols; col++) {
      gameBoard[row][col] = null;
    }
  }
}

// Display game board
function displayGameBoard() {
  const boardContainer = document.getElementById("board-container");
  boardContainer.innerHTML = "";
  
  for (let row = 0; row < numRows; row++) {
    for (let col = 0; col < numCols; col++) {
      const cell = document.createElement("div");
      cell.className = "cell";
      cell.dataset.row = row;
      cell.dataset.col = col;
      
      if (gameBoard[row][col] === "Red") {
        cell.classList.add("red");
      } else if (gameBoard[row][col] === "Yellow") {
        cell.classList.add("yellow");
      }
      
      boardContainer.appendChild(cell);
    }
    
    boardContainer.appendChild(document.createElement("br"));
  }
}

// Check for a win
function checkWin() {
  // Check rows
  for (let row = 0; row < numRows; row++) {
    for (let col = 0; col < numCols - 3; col++) {
      if (
        gameBoard[row][col] &&
        gameBoard[row][col] === gameBoard[row][col + 1] &&
        gameBoard[row][col] === gameBoard[row][col + 2] &&
        gameBoard[row][col] === gameBoard[row][col + 3]
      ) {
        return true;
      }
    }
  }
  
  // Check columns
  for (let col = 0; col < numCols; col++) {
    for (let row = 0; row < numRows - 3; row++) {
      if (
        gameBoard[row][col] &&
        gameBoard[row][col] === gameBoard[row + 1][col] &&
        gameBoard[row][col] === gameBoard[row + 2][col] &&
        gameBoard[row][col] === gameBoard[row + 3][col]
      ) {
        return true;
      }
    }
  }
  
  // Check diagonal (top-left to bottom-right)
  for (let row = 0; row < numRows - 3; row++) {
    for (let col = 0; col < numCols - 3; col++) {
      if (
        gameBoard[row][col] &&
        gameBoard[row][col] === gameBoard[row + 1][col + 1] &&
        gameBoard[row][col] === gameBoard[row + 2][col + 2] &&
        gameBoard[row][col] === gameBoard[row + 3][col + 3]
      ) {
        return true;
      }
    }
  }
  
  // Check diagonal (bottom-left to top-right)
  for (let row = 3; row < numRows; row++) {
    for (let col = 0; col < numCols - 3; col++) {
      if (
        gameBoard[row][col] &&
        gameBoard[row][col] === gameBoard[row - 1][col + 1] &&
        gameBoard[row][col] === gameBoard[row - 2][col + 2] &&
        gameBoard[row][col] === gameBoard[row - 3][col + 3]
      ) {
        return true;
      }
    }
  }
  
  return false;
}

// Handle cell click event
function handleCellClick(event) {
  const cell = event.target;
  const row = parseInt(cell.dataset.row);
  const col = parseInt(cell.dataset.col);
  
  // Check if cell is already occupied
  if (gameBoard[row][col]) {
    return;
  }
  
  // Place token in cell
  gameBoard[row][col] = currentPlayer;
  
  // Check for win
  if (checkWin()) {
    alert(currentPlayer + " wins!");
    resetGame();
    return;
  }
  
  // Switch players
  currentPlayer = currentPlayer === player1 ? player2 : player1;
  
  // Redraw game board
  displayGameBoard();
}

// Reset game
function resetGame() {
  createGameBoard();
  displayGameBoard();
}

// Initialize game
function init() {
  createGameBoard();
  displayGameBoard();
  
  const cells = document.getElementsByClassName("cell");
  for (let i = 0; i < cells.length; i++) {
    cells[i].addEventListener("click", handleCellClick);
  }
  
  const resetButton = document.getElementById("reset-button");
  resetButton.addEventListener("click", resetGame);
}

// Run the game
init();
```

This JavaScript code creates a Connect Four game with a game board, tokens for two players (red and yellow), and functionality to check for a win and switch players. The game board is displayed as a grid of cells, and players can click on cells to place their tokens.