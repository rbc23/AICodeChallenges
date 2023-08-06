```javascript
var board, currentPlayer, moves;

function initialize() {
  board = [
    ['', '', ''],
    ['', '', ''],
    ['', '', '']
  ];
  
  currentPlayer = 'X';
  moves = 0;
  
  renderBoard();
}

function renderBoard() {
  var boardContainer = document.getElementById('board-container');
  boardContainer.innerHTML = '';
  
  for (var i = 0; i < board.length; i++) {
    for (var j = 0; j < board[i].length; j++) {
      var cell = document.createElement('div');
      cell.className = 'cell';
      cell.dataset.row = i;
      cell.dataset.col = j;
      cell.addEventListener('click', makeMove);
      
      cell.textContent = board[i][j];
      
      boardContainer.appendChild(cell);
    }
  }
}

function makeMove() {
  var row = parseInt(this.dataset.row);
  var col = parseInt(this.dataset.col);
  
  if (board[row][col] === '') {
    board[row][col] = currentPlayer;
    moves++;
    
    if (checkWin(currentPlayer, row, col) || moves === 9) {
      setTimeout(function() {
        alert('Game Over!');
        initialize();
      }, 100);
    } else {
      currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
      this.removeEventListener('click', makeMove);
    }
    
    renderBoard();
  }
}

function checkWin(player, row, col) {
  return (
    checkRow(player, row) ||
    checkColumn(player, col) ||
    checkDiagonal(player) ||
    checkAntiDiagonal(player)
  );
}

function checkRow(player, row) {
  return (
    board[row][0] === player &&
    board[row][1] === player &&
    board[row][2] === player
  );
}

function checkColumn(player, col) {
  return (
    board[0][col] === player &&
    board[1][col] === player &&
    board[2][col] === player
  );
}

function checkDiagonal(player) {
  return (
    board[0][0] === player &&
    board[1][1] === player &&
    board[2][2] === player
  );
}

function checkAntiDiagonal(player) {
  return (
    board[0][2] === player &&
    board[1][1] === player &&
    board[2][0] === player
  );
}

initialize();
```

Note: This code assumes that there is an HTML element with id "board-container" where the tic-tac-toe board will be rendered.