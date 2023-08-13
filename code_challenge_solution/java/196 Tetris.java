```
<!DOCTYPE html>
<html>
<head>
    <title>Tetris Clone</title>
    <style>
        #tetris {
            display: flex;
            flex-wrap: wrap;
            width: 300px;
        }

        .cell {
            width: 30px;
            height: 30px;
            border: 1px solid #000;
        }
    </style>
</head>
<body>
    <div id="tetris"></div>

    <script>
        const ROWS = 20;
        const COLS = 10;

        const tetris = document.getElementById('tetris');
        const grid = createGrid();

        let currentPiece = null;
        let interval = null;

        function createGrid() {
            let grid = [];
            for (let row = 0; row < ROWS; row++) {
                let newRow = [];
                for (let col = 0; col < COLS; col++) {
                    newRow.push(0);
                }
                grid.push(newRow);
            }
            return grid;
        }

        function drawGrid() {
            tetris.innerHTML = '';
            for (let row = 0; row < ROWS; row++) {
                for (let col = 0; col < COLS; col++) {
                    let cell = document.createElement('div');
                    cell.classList.add('cell');
                    if (grid[row][col]) {
                        cell.style.backgroundColor = 'red';
                    }
                    tetris.append(cell);
                }
            }
        }

        function rotatePiece(piece) {
            let rotatedPiece = [];
            for (let col = 0; col < piece[0].length; col++) {
                let newRow = [];
                for (let row = piece.length - 1; row >= 0; row--) {
                    newRow.push(piece[row][col]);
                }
                rotatedPiece.push(newRow);
            }
            return rotatedPiece;
        }

        function checkCollision(piece, rowOffset, colOffset) {
            for (let row = 0; row < piece.length; row++) {
                for (let col = 0; col < piece[row].length; col++) {
                    let newX = currentPiece.row + row + rowOffset;
                    let newY = currentPiece.col + col + colOffset;

                    if (newX < 0 || newX >= ROWS || newY < 0 || newY >= COLS) {
                        if (piece[row][col]) {
                            return true;
                        }
                    } else if (piece[row][col] && grid[newX][newY]) {
                        return true;
                    }
                }
            }
            return false;
        }

        function mergePiece() {
            for (let row = 0; row < currentPiece.piece.length; row++) {
                for (let col = 0; col < currentPiece.piece[row].length; col++) {
                    if (currentPiece.piece[row][col]) {
                        grid[currentPiece.row + row][currentPiece.col + col] = 1;
                    }
                }
            }

            currentPiece = null;
        }

        function generateRandomPiece() {
            const pieces = [
                [[1]],
                [[1, 1]],
                [[1, 1], [1, 1]],
                [[1, 0], [1, 1], [0, 1]],
                [[1, 1, 0], [0, 1, 1]],
                [[0, 1, 1], [1, 1, 0]],
                [[1, 1, 1, 1]]
            ];
            let randomIndex = Math.floor(Math.random() * pieces.length);
            let piece = pieces[randomIndex];
            let row = -piece.length;
            let col = Math.floor((COLS - piece[0].length) / 2);
            return { piece, row, col };
        }

        function movePieceDown() {
            if (currentPiece) {
                if (!checkCollision(currentPiece.piece, 1, 0)) {
                    currentPiece.row++;
                } else {
                    mergePiece();
                }
            } else {
                currentPiece = generateRandomPiece();
            }
        }

        function movePieceLeft() {
            if (currentPiece && !checkCollision(currentPiece.piece, 0, -1)) {
                currentPiece.col--;
            }
        }

        function movePieceRight() {
            if (currentPiece && !checkCollision(currentPiece.piece, 0, 1)) {
                currentPiece.col++;
            }
        }

        function rotatePieceClockwise() {
            if (currentPiece) {
                let rotatedPiece = rotatePiece(currentPiece.piece);
                if (!checkCollision(rotatedPiece, 0, 0)) {
                    currentPiece.piece = rotatedPiece;
                }
            }
        }

        function startGame() {
            interval = setInterval(() => {
                movePieceDown();
                drawGrid();
            }, 500);
        }

        function endGame() {
            clearInterval(interval);
            alert('Game Over');
        }

        document.addEventListener('keydown', (event) => {
            switch (event.key) {
                case 'ArrowLeft':
                    movePieceLeft();
                    break;
                case 'ArrowRight':
                    movePieceRight();
                    break;
                case 'ArrowUp':
                    rotatePieceClockwise();
                    break;
                case 'ArrowDown':
                    movePieceDown();
                    break;
                case 'Enter':
                    startGame();
                    break;
            }
            drawGrid();
        });

        drawGrid();
    </script>
</body>
</html>
```