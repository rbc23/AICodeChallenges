```javascript
// Create a Minesweeper object to manage the game
const Minesweeper = {
  rows: 0,
  cols: 0,
  totalMines: 0,
  grid: [],
  revealedGrid: [],
  mines: [],
  gameOver: false,
  
  // Method to initialize the game
  init: function(rows, cols, totalMines) {
    this.rows = rows;
    this.cols = cols;
    this.totalMines = totalMines;
    this.gameOver = false;
    this.grid = [];
    this.revealedGrid = [];
    this.mines = [];
    this.createGrid();
    this.placeMines();
    this.calculateNumbers();
  },
  
  // Method to create the game grid
  createGrid: function() {
    for (let i = 0; i < this.rows; i++) {
      this.grid[i] = [];
      this.revealedGrid[i] = [];
      for (let j = 0; j < this.cols; j++) {
        this.grid[i][j] = {
          mine: false,
          number: 0,
          revealed: false,
          flag: false,
        }
        this.revealedGrid[i][j] = false;
      }
    }
  },
  
  // Method to randomly place mines on the grid
  placeMines: function() {
    let totalPlacedMines = 0;
    while (totalPlacedMines < this.totalMines) {
      const randomRow = Math.floor(Math.random() * this.rows);
      const randomCol = Math.floor(Math.random() * this.cols);
      if (!this.grid[randomRow][randomCol].mine) {
        this.grid[randomRow][randomCol].mine = true;
        this.mines.push([randomRow, randomCol]);
        totalPlacedMines++;
      }
    }
  },
  
  // Method to calculate the numbers on the grid based on the adjacent mines
  calculateNumbers: function() {
    for (let i = 0; i < this.rows; i++) {
      for (let j = 0; j < this.cols; j++) {
        if (!this.grid[i][j].mine) {
          let count = 0;
          for (let x = -1; x <= 1; x++) {
            for (let y = -1; y <= 1; y++) {
              const newRow = i + x;
              const newCol = j + y;
              if (newRow >= 0 && newRow < this.rows && newCol >= 0 && newCol < this.cols) {
                if (this.grid[newRow][newCol].mine) {
                  count++;
                }
              }
            }
          }
          this.grid[i][j].number = count;
        }
      }
    }
  },
  
  // Method to reveal a cell
  revealCell: function(row, col) {
    if (!this.grid[row][col].revealed && !this.grid[row][col].flag) {
      this.revealedGrid[row][col] = true;
      
      if (this.grid[row][col].mine) {
        this.gameOver = true;
        this.revealAllMines();
        return;
      }
      
      if (this.grid[row][col].number === 0) {
        this.revealAdjacentCells(row, col);
      }
    }
  },
  
  // Method to reveal adjacent cells if the clicked cell has number 0
  revealAdjacentCells: function(row, col) {
    for (let x = -1; x <= 1; x++) {
      for (let y = -1; y <= 1; y++) {
        const newRow = row + x;
        const newCol = col + y;
        if (newRow >= 0 && newRow < this.rows && newCol >= 0 && newCol < this.cols) {
          this.revealCell(newRow, newCol);
        }
      }
    }
  },
  
  // Method to reveal all the mines on the grid
  revealAllMines: function() {
    for (let i = 0; i < this.mines.length; i++) {
      const [row, col] = this.mines[i];
      this.revealedGrid[row][col] = true;
    }
  },
  
  // Method to toggle flagged status of a cell
  toggleFlag: function(row, col) {
    if (!this.grid[row][col].revealed) {
      this.grid[row][col].flag = !this.grid[row][col].flag;
    }
  },
  
  // Method to check if all non-mine cells have been revealed
  checkWin: function() {
    for (let i = 0; i < this.rows; i++) {
      for (let j = 0; j < this.cols; j++) {
        if (!this.grid[i][j].mine && !this.revealedGrid[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
};

// Example usage:
Minesweeper.init(10, 10, 15);
Minesweeper.revealCell(0, 0);
Minesweeper.toggleFlag(1, 0);
console.log(Minesweeper.grid);
console.log(Minesweeper.revealedGrid);
console.log(Minesweeper.checkWin());
```