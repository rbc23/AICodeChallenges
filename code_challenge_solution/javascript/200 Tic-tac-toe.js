```javascript
let board = [["", "", ""], ["", "", ""], ["", "", ""]];
let currentPlayer = "X";
let isGameOver = false;

function makeMove(row, col) {
  if (board[row][col] !== "" || isGameOver) {
    return;
  }

  board[row][col] = currentPlayer;
  checkGameStatus();
  togglePlayer();
}

function checkGameStatus() {
  if (checkWin()) {
    console.log("Player " + currentPlayer + " wins!");
    isGameOver = true;
  } else if (checkDraw()) {
    console.log("It's a draw!");
    isGameOver = true;
  }
}

function checkWin() {
  for (let i = 0; i < 3; i++) {
    if (board[i][0] === currentPlayer && board[i][1] === currentPlayer && board[i][2] === currentPlayer) {
      return true;
    }
    if (board[0][i] === currentPlayer && board[1][i] === currentPlayer && board[2][i] === currentPlayer) {
      return true;
    }
  }
  if (board[0][0] === currentPlayer && board[1][1] === currentPlayer && board[2][2] === currentPlayer) {
    return true;
  }
  if (board[0][2] === currentPlayer && board[1][1] === currentPlayer && board[2][0] === currentPlayer) {
    return true;
  }
  return false;
}

function checkDraw() {
  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      if (board[i][j] === "") {
        return false;
      }
    }
  }
  return true;
}

function togglePlayer() {
  currentPlayer = currentPlayer === "X" ? "O" : "X";
}
```
This code sets up the game of Tic-tac-toe and implements the logic for making moves, checking the game status (win or draw), and toggling players. The game is played on a 3x3 grid represented by a 2D array.