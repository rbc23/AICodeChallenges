// Generate crossword puzzle grid
const grid = [
  ['a', 'b', 'c', 'd', 'e'],
  ['f', 'g', 'h', 'i', 'j'],
  ['k', 'l', 'm', 'n', 'o'],
  ['p', 'q', 'r', 's', 't'],
  ['u', 'v', 'w', 'x', 'y']
];

// Create word list
const words = ['hello', 'world', 'javascript', 'crossword'];

// Function to check if word fits horizontally
function fitsHorizontally(word, row, col) {
  if (col + word.length > grid[row].length) {
    return false;
  }
  for (let i = 0; i < word.length; i++) {
    if (grid[row][col + i] !== ' ' && grid[row][col + i] !== word[i]) {
      return false;
    }
  }
  return true;
}

// Function to check if word fits vertically
function fitsVertically(word, row, col) {
  if (row + word.length > grid.length) {
    return false;
  }
  for (let i = 0; i < word.length; i++) {
    if (grid[row + i][col] !== ' ' && grid[row + i][col] !== word[i]) {
      return false;
    }
  }
  return true;
}

// Function to place word horizontally
function placeHorizontally(word, row, col) {
  for (let i = 0; i < word.length; i++) {
    grid[row][col + i] = word[i];
  }
}

// Function to place word vertically
function placeVertically(word, row, col) {
  for (let i = 0; i < word.length; i++) {
    grid[row + i][col] = word[i];
  }
}

// Randomly place words on the grid
for (const word of words) {
  let placed = false;
  while (!placed) {
    const row = Math.floor(Math.random() * grid.length);
    const col = Math.floor(Math.random() * grid[row].length);
    if (fitsHorizontally(word, row, col)) {
      placeHorizontally(word, row, col);
      placed = true;
    } else if (fitsVertically(word, row, col)) {
      placeVertically(word, row, col);
      placed = true;
    }
  }
}

// Display the crossword puzzle
for (const row of grid) {
  console.log(row.join(' '));
}