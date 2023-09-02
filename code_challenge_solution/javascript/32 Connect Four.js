```javascript
const ROWS = 6;
const COLS = 7;

let board = [];

// Function to create the game board
function createBoard() {
  board = Array.from({ length: ROWS }, () => Array.from({ length: COLS }, () => null));
}

// Function to check if a column is full
function isColumnFull(col) {
  return board[0][col] !== null;
}

// Function to drop a token into a column
function dropToken(col, player) {
  if (isColumnFull(col)) {
    return false;
  }

  for (let row = ROWS - 1; row >= 0; row--) {
    if (board[row][col] === null) {
      board[row][col] = player;
      return true;
    }
  }
}

// Function to check if a player has won
function checkWin(player) {
  // Check horizontal
  for (let row = 0; row < ROWS; row++) {
    for (let col = 0; col <= COLS - 4; col++) {
      if (
        board[row][col] === player &&
        board[row][col + 1] === player &&
        board[row][col + 2] === player &&
        board[row][col + 3] === player
      ) {
        return true;
      }
    }
  }

  // Check vertical
  for (let row = 0; row <= ROWS - 4; row++) {
    for (let col = 0; col < COLS; col++) {
      if (
        board[row][col] === player &&
        board[row + 1][col] === player &&
        board[row + 2][col] === player &&
        board[row + 3][col] === player
      ) {
        return true;
      }
    }
  }

  // Check diagonal - bottom left to top right
  for (let row = ROWS - 1; row >= 3; row--) {
    for (let col = 0; col <= COLS - 4; col++) {
      if (
        board[row][col] === player &&
        board[row - 1][col + 1] === player &&
        board[row - 2][col + 2] === player &&
        board[row - 3][col + 3] === player
      ) {
        return true;
      }
    }
  }

  // Check diagonal - top left to bottom right
  for (let row = 0; row <= ROWS - 4; row++) {
    for (let col = 0; col <= COLS - 4; col++) {
      if (
        board[row][col] === player &&
        board[row + 1][col + 1] === player &&
        board[row + 2][col + 2] === player &&
        board[row + 3][col + 3] === player
      ) {
        return true;
      }
    }
  }

  return false;
}

// Create the game board
createBoard();