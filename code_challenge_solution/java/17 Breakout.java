Sure! Here is the JavaScript code for a Breakout Clone game:

```javascript
// Create canvas element
const canvas = document.createElement('canvas');
const ctx = canvas.getContext('2d');
canvas.width = 800;
canvas.height = 600;
document.body.appendChild(canvas);

// Define paddle properties
const paddle = {
  x: canvas.width / 2 - 75,
  y: canvas.height - 30,
  width: 150,
  height: 15,
  dx: 5
};

// Define ball properties
const ball = {
  x: canvas.width / 2,
  y: canvas.height - 45,
  radius: 10,
  speed: 4,
  dx: 4,
  dy: -4
};

// Create bricks
const brickRowCount = 5;
const brickColumnCount = 10;
const brickWidth = 75;
const brickHeight = 20;
const brickPadding = 10;
const brickOffsetTop = 30;
const brickOffsetLeft = 30;
const bricks = [];
for (let c = 0; c < brickColumnCount; c++) {
  bricks[c] = [];
  for (let r = 0; r < brickRowCount; r++) {
    bricks[c][r] = { x: 0, y: 0, status: 1 };
  }
}

// Define variables for game status and score
let score = 0;
let lives = 3;
let gameover = false;

// Add keyboard event listeners for paddle movement
document.addEventListener('keydown', movePaddle);
document.addEventListener('keyup', stopPaddle);

// Paddle movement functions
function movePaddle(e) {
  if (e.keyCode === 37) {
    paddle.dx = -5;
  } else if (e.keyCode === 39) {
    paddle.dx = 5;
  }
}

function stopPaddle(e) {
  if (e.keyCode === 37 || e.keyCode === 39) {
    paddle.dx = 0;
  }
}

// Function to draw paddle on canvas
function drawPaddle() {
  ctx.beginPath();
  ctx.rect(paddle.x, paddle.y, paddle.width, paddle.height);
  ctx.fillStyle = '#0095DD';
  ctx.fill();
  ctx.closePath();
}

// Function to draw ball on canvas
function drawBall() {
  ctx.beginPath();
  ctx.arc(ball.x, ball.y, ball.radius, 0, Math.PI * 2);
  ctx.fillStyle = '#0095DD';
  ctx.fill();
  ctx.closePath();
}

// Function to draw bricks on canvas
function drawBricks() {
  for (let c = 0; c < brickColumnCount; c++) {
    for (let r = 0; r < brickRowCount; r++) {
      if (bricks[c][r].status === 1) {
        const brickX = c * (brickWidth + brickPadding) + brickOffsetLeft;
        const brickY = r * (brickHeight + brickPadding) + brickOffsetTop;
        bricks[c][r].x = brickX;
        bricks[c][r].y = brickY;
        ctx.beginPath();
        ctx.rect(brickX, brickY, brickWidth, brickHeight);
        ctx.fillStyle = '#0095DD';
        ctx.fill();
        ctx.closePath();
      }
    }
  }
}

// Function to detect collision with bricks
function detectCollision() {
  for (let c = 0; c < brickColumnCount; c++) {
    for (let r = 0; r < brickRowCount; r++) {
      const brick = bricks[c][r];
      if (brick.status === 1) {
        if (
          ball.x > brick.x &&
          ball.x < brick.x + brickWidth &&
          ball.y > brick.y &&
          ball.y < brick.y + brickHeight
        ) {
          ball.dy = -ball.dy;
          brick.status = 0;
          score++;
          if (score === brickRowCount * brickColumnCount) {
            gameover = true;
          }
        }
      }
    }
  }
}

// Function to update game state
function update() {
  if (!gameover) {
    // Clear canvas
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // Draw paddle, ball, and bricks
    drawPaddle();
    drawBall();
    drawBricks();

    // Move paddle
    paddle.x += paddle.dx;
    if (paddle.x < 0) {
      paddle.x = 0;
    } else if (paddle.x + paddle.width > canvas.width) {
      paddle.x = canvas.width - paddle.width;
    }

    // Move ball
    ball.x += ball.dx;
    ball.y += ball.dy;

    // Detect collision with walls
    if (ball.x + ball.radius > canvas.width || ball.x - ball.radius < 0) {
      ball.dx = -ball.dx;
    }
    if (ball.y - ball.radius < 0) {
      ball.dy = -ball.dy;
    }

    // Detect collision with paddle
    if (
      ball.y + ball.radius > paddle.y &&
      ball.x > paddle.x &&
      ball.x < paddle.x + paddle.width
    ) {
      ball.dy = -ball.dy;
    }

    // Detect collision with bricks
    detectCollision();

    // Show score and lives
    ctx.font = '16px Arial';
    ctx.fillStyle = '#0095DD';
    ctx.fillText('Score: ' + score, 8, 20);
    ctx.fillText('Lives: ' + lives, canvas.width - 65, 20);

    // Game over condition
    if (ball.y + ball.radius > canvas.height) {
      lives--;
      if (lives === 0) {
        gameover = true;
      } else {
        ball.x = canvas.width / 2;
        ball.y = canvas.height - 45;
        ball.speed = 4;
        ball.dx = 4;
        ball.dy = -4;
        paddle.x = canvas.width / 2 - 75;
      }
    }

    // Request animation frame
    requestAnimationFrame(update);
  } else {
    // Game over message
    ctx.font = '36px Arial';
    ctx.fillStyle = '#0095DD';
    ctx.fillText('Game Over', canvas.width / 2 - 100, canvas.height / 2);
  }
}

// Start the game
update();
```

This code sets up a Breakout Clone game by creating canvas element, defining properties for paddle and ball, creating bricks, adding event listeners for paddle movement, drawing paddle, ball and bricks, detecting collision with bricks, updating game state, and handling game over condition.

To run the game, simply copy and paste the code into an HTML file and open it in a web browser.