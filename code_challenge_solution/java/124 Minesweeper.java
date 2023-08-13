```
class Minesweeper {
  constructor(rows, cols, mines) {
    this.rows = rows;
    this.cols = cols;
    this.mines = mines;
    this.board = [];
    this.mineLocations = [];
    this.gameOver = false;
    this.setup();
  }

  setup() {
    this.createBoard();
    this.placeMines();
    this.calculateNumbers();
  }

  createBoard() {
    for (let i = 0; i < this.rows; i++) {
      this.board.push([]);
      for (let j = 0; j < this.cols; j++) {
        this.board[i].push({
          isMine: false,
          isRevealed: false,
          neighboringMines: 0
        });
      }
    }
  }

  placeMines() {
    let count = 0;
    while (count < this.mines) {
      const randomRow = Math.floor(Math.random() * this.rows);
      const randomCol = Math.floor(Math.random() * this.cols);
      if (!this.board[randomRow][randomCol].isMine) {
        this.board[randomRow][randomCol].isMine = true;
        this.mineLocations.push([randomRow, randomCol]);
        count++;
      }
    }
  }

  calculateNumbers() {
    for (let [row, col] of this.mineLocations) {
      for (let i = -1; i <= 1; i++) {
        for (let j = -1; j <= 1; j++) {
          if (this.isValidCell(row + i, col + j) && !this.board[row + i][col + j].isMine) {
            this.board[row + i][col + j].neighboringMines++;
          }
        }
      }
    }
  }

  isValidCell(row, col) {
    return row >= 0 && row < this.rows && col >= 0 && col < this.cols;
  }

  revealCell(row, col) {
    if (!this.isValidCell(row, col) || this.board[row][col].isRevealed) return;
    this.board[row][col].isRevealed = true;
    if (this.board[row][col].isMine) {
      this.gameOver = true;
      return;
    }
    if (this.board[row][col].neighboringMines === 0) {
      this.revealNeighborCells(row, col);
    }
  }

  revealNeighborCells(row, col) {
    for (let i = -1; i <= 1; i++) {
      for (let j = -1; j <= 1; j++) {
        if (this.isValidCell(row + i, col + j) && !this.board[row + i][col + j].isMine && !this.board[row + i][col + j].isRevealed) {
          this.board[row + i][col + j].isRevealed = true;
          if (this.board[row + i][col + j].neighboringMines === 0) {
            this.revealNeighborCells(row + i, col + j);
          }
        }
      }
    }
  }
}

const rows = 10; // Enter the number of rows for the board
const cols = 10; // Enter the number of columns for the board
const mines = 20; // Enter the number of mines for the board

const minesweeper = new Minesweeper(rows, cols, mines);
```
