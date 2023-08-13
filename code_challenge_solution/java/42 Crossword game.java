```javascript
// Create a crossword puzzle class
class CrosswordPuzzle {
  constructor(size) {
    this.size = size; // size of the puzzle
    this.grid = new Array(size); // crossword grid
    for (let i = 0; i < size; i++) {
      this.grid[i] = new Array(size);
    }
  }

  // Add a word to the crossword grid horizontally
  addWordHorizontal(word, row, col) {
    if (col + word.length <= this.size) {
      for (let i = 0; i < word.length; i++) {
        this.grid[row][col + i] = word[i];
      }
      return true;
    }
    return false;
  }

  // Add a word to the crossword grid vertically
  addWordVertical(word, row, col) {
    if (row + word.length <= this.size) {
      for (let i = 0; i < word.length; i++) {
        this.grid[row + i][col] = word[i];
      }
      return true;
    }
    return false;
  }

  // Print the crossword grid
  printGrid() {
    for (let row = 0; row < this.size; row++) {
      let rowString = '';
      for (let col = 0; col < this.size; col++) {
        rowString += this.grid[row][col] ? this.grid[row][col] + ' ' : '_ ';
      }
      console.log(rowString.trim());
    }
  }
}

// Create a new crossword puzzle object
let crosswordPuzzle = new CrosswordPuzzle(5);

// Add words to the crossword puzzle
crosswordPuzzle.addWordHorizontal('HELLO', 1, 1);
crosswordPuzzle.addWordVertical('WORLD', 1, 3);

// Print the crossword puzzle grid
crosswordPuzzle.printGrid();
```
