```javascript
// Create the Tic-tac-toe game class
class TicTacToe {
  constructor() {
    this.board = [
      ['', '', ''],
      ['', '', ''],
      ['', '', '']
    ];
    this.currentPlayer = 'X';
    this.winner = null;
    this.moves = 0;
  }

  // Method to make a move on the board
  makeMove(row, col) {
    if (this.board[row][col] === '') {
      this.board[row][col] = this.currentPlayer;
      this.moves++;

      if (this.checkWin(row, col)) {
        this.winner = this.currentPlayer;
      } else if (this.moves === 9) {
        this.winner = 'DRAW';
      }

      this.currentPlayer = this.currentPlayer === 'X' ? 'O' : 'X';
    }
  }

  // Method to check if a player has won
  checkWin(row, col) {
    const player = this.currentPlayer;
    const board = this.board;

    // Check row
    if (board[row][0] === player && board[row][1] === player && board[row][2] === player) {
      return true;
    }

    // Check column
    if (board[0][col] === player && board[1][col] === player && board[2][col] === player) {
      return true;
    }

    // Check diagonal
    if (board[0][0] === player && board[1][1] === player && board[2][2] === player) {
      return true;
    }

    // Check reverse diagonal
    if (board[0][2] === player && board[1][1] === player && board[2][0] === player) {
      return true;
    }

    return false;
  }

  // Method to print the current board
  printBoard() {
    for (let i = 0; i < 3; i++) {
      console.log(this.board[i].join(' | '));
    }
  }
}

// Example usage
const game = new TicTacToe();
game.makeMove(0, 0);
game.makeMove(1, 1);
game.makeMove(0, 1);
game.makeMove(1, 2);
game.makeMove(0, 2);
game.makeMove(2, 2);
game.printBoard();
console.log('Winner:', game.winner || 'None');
```