```javascript
const words = [
  { word: 'cat', clue: 'A small domesticated carnivorous mammal' },
  { word: 'dog', clue: 'A domesticated carnivorous mammal' },
  { word: 'bird', clue: 'A warm-blooded vertebrate animal' },
  { word: 'snake', clue: 'A long, legless carnivorous reptile' },
  { word: 'fish', clue: 'A limbless cold-blooded vertebrate animal' }
];

const boardSize = 10;
const emptyCell = '-';
const board = Array.from(Array(boardSize), () => Array(boardSize).fill(emptyCell));

function generateCrossword() {
  for (const { word, clue } of words) {
    const direction = Math.random() < 0.5 ? 'horizontal' : 'vertical';
    const reversed = Math.random() < 0.5 ? true : false;
    const wordLength = word.length;

    let emptyCellPositions = [];
    for (let i = 0; i < boardSize; i++) {
      for (let j = 0; j < boardSize; j++) {
        if (board[i][j] === emptyCell) {
          emptyCellPositions.push({ x: j, y: i });
        }
      }
    }

    let success = false;
    while (!success && emptyCellPositions.length > 0) {
      const position = emptyCellPositions[Math.floor(Math.random() * emptyCellPositions.length)];
      const { x, y } = position;
      let valid = true;

      if (direction === 'horizontal') {
        if (x + wordLength > boardSize) {
          valid = false;
        } else {
          for (let i = 0; i < wordLength; i++) {
            if (board[y][x + i] !== emptyCell && board[y][x + i] !== word[i]) {
              valid = false;
              break;
            }
          }
        }
      } else {
        if (y + wordLength > boardSize) {
          valid = false;
        } else {
          for (let i = 0; i < wordLength; i++) {
            if (board[y + i][x] !== emptyCell && board[y + i][x] !== word[i]) {
              valid = false;
              break;
            }
          }
        }
      }

      if (valid) {
        success = true;
        for (let i = 0; i < wordLength; i++) {
          if (direction === 'horizontal') {
            board[y][x + i] = word[i];
          } else {
            board[y + i][x] = word[i];
          }
        }
      } else {
        emptyCellPositions = emptyCellPositions.filter(position => position !== position);
      }
    }
  }

  printBoard();
}

function printBoard() {
  for (const row of board) {
    console.log(row.join(' '));
  }
}

generateCrossword();
```
Note: This program generates a crossword puzzle by randomly placing words in a crossword grid of specified size. The crossword board is represented using a 2D array. The words and their clues are defined in the `words` array. The function `generateCrossword` randomly selects a word, its direction (horizontal or vertical), and its starting position on the board. It then checks if the word can fit in that position without any collisions with existing words. If a valid position is found, the word is placed on the board. The process is repeated for all words. Finally, the function `printBoard` prints the crossword board.