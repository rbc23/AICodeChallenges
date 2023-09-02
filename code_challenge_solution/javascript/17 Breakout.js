```javascript
// Create canvas element
const canvas = document.createElement('canvas');
const context = canvas.getContext('2d');
canvas.width = 800;
canvas.height = 600;
document.body.appendChild(canvas);

// Player's paddle settings
const paddleWidth = 100;
const paddleHeight = 10;
const paddleSpeed = 10;
let paddleX = (canvas.width - paddleWidth) / 2;

// Ball settings
let ballSize = 10;
let ballX = canvas.width / 2;
let ballY = canvas.height - paddleHeight - ballSize;
let ballSpeedX = 4;
let ballSpeedY = -4;

// Brick settings
const brickRows = 3;
const brickCols = 8;
const brickWidth = 90;
const brickHeight = 20;
const brickPadding = 10;
const brickOffsetTop = 30;
const brickOffsetLeft = 30;
const bricks = [];

// Create bricks
for (let row = 0; row < brickRows; row++) {
  bricks[row] = [];
  for (let col = 0; col < brickCols; col++) {
    bricks[row][col] = { x: 0, y: 0, isVisible: true };
  }
}

// Keyboard event listeners
let leftPressed = false;
let rightPressed = false;
document.addEventListener('keydown', keyDownHandler);
document.addEventListener('keyup', keyUpHandler);

function keyDownHandler(event) {
  if (event.key === 'Left' || event.key === 'ArrowLeft') {
    leftPressed = true;
  } else if (event.key === 'Right' || event.key === 'ArrowRight') {
    rightPressed = true;
  }
}

function keyUpHandler(event) {
  if (event.key === 'Left' || event.key === 'ArrowLeft') {
    leftPressed = false;
  } else if (event.key === 'Right' || event.key === 'ArrowRight') {
    rightPressed = false;
  }
}

// Collision detection function
function detectCollisions() {
  for (let row = 0; row < brickRows; row++) {
    for (let col = 0; col < brickCols; col++) {
      const brick = bricks[row][col];
      if (brick.isVisible) {
        if (
          ballX > brick.x &&
          ballX < brick.x + brickWidth &&
          ballY > brick.y &&
          ballY < brick.y + brickHeight
        ) {
          brick.isVisible = false;
          ballSpeedY = -ballSpeedY;
        }
      }
    }
  }
}

// Draw objects on canvas
function draw() {
  context.clearRect(0, 0, canvas.width, canvas.height);
  
  // Draw paddle
  context.beginPath();
  context.rect(paddleX, canvas.height - paddleHeight, paddleWidth, paddleHeight);
  context.fillStyle = '#0095DD';
  context.fill();
  context.closePath();
  
  // Draw ball
  context.beginPath();
  context.arc(ballX, ballY, ballSize, 0, Math.PI * 2);
  context.fillStyle = '#0095DD';
  context.fill();
  context.closePath();
  
  // Draw bricks
  for (let row = 0; row < brickRows; row++) {
    for (let col = 0; col < brickCols; col++) {
      if (bricks[row][col].isVisible) {
        const brickX = col * (brickWidth + brickPadding) + brickOffsetLeft;
        const brickY = row * (brickHeight + brickPadding) + brickOffsetTop;
        bricks[row][col].x = brickX;
        bricks[row][col].y = brickY;
        context.beginPath();
        context.rect(brickX, brickY, brickWidth, brickHeight);
        context.fillStyle = '#0095DD';
        context.fill();
        context.closePath();
      }
    }
  }
}

// Move paddle function
function movePaddle() {
  if (leftPressed && paddleX > 0) {
    paddleX -= paddleSpeed;
  } else if (rightPressed && paddleX < canvas.width - paddleWidth) {
    paddleX += paddleSpeed;
  }
}

// Move ball function
function moveBall() {
  ballX += ballSpeedX;
  ballY += ballSpeedY;
  
  // Ball collision detection with walls
  if (ballX < ballSize || ballX > canvas.width - ballSize) {
    ballSpeedX = -ballSpeedX;
  }
  if (ballY < ballSize) {
    ballSpeedY = -ballSpeedY;
  }
  
  // Ball collision detection with paddle
  if (
    ballY + ballSize > canvas.height - paddleHeight &&
    ballX > paddleX &&
    ballX < paddleX + paddleWidth
  ) {
    ballSpeedY = -ballSpeedY;
  }
  
  // Ball collision detection with bricks
  detectCollisions();
}

// Game loop
function gameLoop() {
  movePaddle();
  moveBall();
  draw();
  requestAnimationFrame(gameLoop);
}

gameLoop();
```