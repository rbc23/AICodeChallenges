```javascript
class ConnectFour {
  constructor(rows, columns) {
    this.rows = rows;
    this.columns = columns;
    this.board = this.createBoard();
    this.currentPlayer = 'Player 1';
    this.gameOver = false;
  }

  createBoard() {
    const board = [];
    for (let row = 0; row < this.rows; row++) {
      board.push(Array(this.columns).fill(null));
    }
    return board;
  }

  makeMove(column) {
    if (this.gameOver) {
      console.log('Game over. Please start a new game.');
      return;
    }

    if (column < 0 || column >= this.columns) {
      console.log('Invalid column number. Please choose a valid column.');
      return;
    }

    const row = this.getNextOpenRow(column);
    if (row === -1) {
      console.log('Column is full. Please choose another column.');
      return;
    }

    this.board[row][column] = this.currentPlayer;
    this.printBoard();

    if (this.checkWin(row, column)) {
      console.log(`${this.currentPlayer} wins!`);
      this.gameOver = true;
      return;
    }

    if (this.checkDraw()) {
      console.log('The game is a draw!');
      this.gameOver = true;
      return;
    }

    this.currentPlayer = this.currentPlayer === 'Player 1' ? 'Player 2' : 'Player 1';
  }

  getNextOpenRow(column) {
    for (let row = this.rows - 1; row >= 0; row--) {
      if (this.board[row][column] === null) {
        return row;
      }
    }
    return -1;
  }

  checkWin(row, column) {
    const player = this.board[row][column];

    // Check vertical
    let count = 0;
    for (let i = row; i >= 0; i--) {
      if (this.board[i][column] === player) {
        count++;
      } else {
        break;
      }
    }
    if (count >= 4) {
      return true;
    }

    // Check horizontal
    count = 0;
    for (let i = 0; i < this.columns; i++) {
      if (this.board[row][i] === player) {
        count++;
      } else {
        count = 0;
      }
      if (count >= 4) {
        return true;
      }
    }

    // Check diagonal
    count = 0;
    let i = row;
    let j = column;
    while (i >= 0 && j < this.columns && this.board[i][j] === player) {
      count++;
      i--;
      j++;
    }
    i = row + 1;
    j = column - 1;
    while (i < this.rows && j >= 0 && this.board[i][j] === player) {
      count++;
      i++;
      j--;
    }
    if (count >= 4) {
      return true;
    }

    // Check anti-diagonal
    count = 0;
    i = row;
    j = column;
    while (i >= 0 && j >= 0 && this.board[i][j] === player) {
      count++;
      i--;
      j--;
    }
    i = row + 1;
    j = column + 1;
    while (i < this.rows && j < this.columns && this.board[i][j] === player) {
      count++;
      i++;
      j++;
    }
    if (count >= 4) {
      return true;
    }

    return false;
  }

  checkDraw() {
    for (let row = 0; row < this.rows; row++) {
      for (let col = 0; col < this.columns; col++) {
        if (this.board[row][col] === null) {
          return false;
        }
      }
    }
    return true;
  }

  printBoard() {
    console.log(this.board.map(row => row.join(' | ')).join('\n---------\n'));
  }

  restartGame() {
    this.board = this.createBoard();
    this.currentPlayer = 'Player 1';
    this.gameOver = false;
    console.log('Game restarted. Let\'s play!');
  }
}

const game = new ConnectFour(6, 7);
console.log('Connect Four Game');
console.log('-------------------');
console.log('Game started. Let\'s play!');
game.printBoard();
```