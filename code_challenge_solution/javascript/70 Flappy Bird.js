Here is a JavaScript code for a Flappy Bird clone game:

```javascript
// Flappy Bird Clone

// Canvas setup
var canvas = document.getElementById("gameCanvas");
var context = canvas.getContext("2d");
const CANVAS_WIDTH = 480;
const CANVAS_HEIGHT = 640;
canvas.width = CANVAS_WIDTH;
canvas.height = CANVAS_HEIGHT;

// Game variables
var bird = new Image();
bird.src = "bird.png";
var birdX = 50;
var birdY = 150;
const GRAVITY = 0.7;
var jumpForce = 12;
var score = 0;
const PIPE_WIDTH = 60;
const PIPE_HEIGHT = 400;
var pipeGap = 200;
var pipeX = CANVAS_WIDTH;
var pipeY = 0;
var pipeSpeed = 2;
var gameOver = false;

// Event listeners
document.addEventListener("keydown", jump);

// Game loop
function gameLoop() {
    update();
    draw();
    
    if (!gameOver) {
        requestAnimationFrame(gameLoop);
    }
}

// Update game objects
function update() {
    birdY += GRAVITY;
    
    if (birdY > CANVAS_HEIGHT - 10) {
        gameOver = true;
    }
    
    pipeX -= pipeSpeed;
    
    if (pipeX < -PIPE_WIDTH) {
        pipeX = CANVAS_WIDTH;
        pipeY = Math.floor(Math.random() * (CANVAS_HEIGHT - pipeGap));
        score++;
    }
    
    if (birdY > pipeY && birdY < pipeY + PIPE_HEIGHT && birdX + bird.width > pipeX && birdX < pipeX + PIPE_WIDTH) {
        gameOver = true;
    }
}

// Draw game objects
function draw() {
    context.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
    
    context.drawImage(bird, birdX, birdY);
    
    context.fillStyle = "#000000";
    context.font = "20px Verdana";
    context.fillText("Score: " + score, 10, 30);
    
    context.fillStyle = "#00FF00";
    context.fillRect(pipeX, 0, PIPE_WIDTH, pipeY);
    context.fillRect(pipeX, pipeY + PIPE_HEIGHT, PIPE_WIDTH, CANVAS_HEIGHT - pipeY - PIPE_HEIGHT);
}

// Jump event
function jump(e) {
    if (e.keyCode === 32 && !gameOver) {
        birdY -= jumpForce;
    }
}

// Start the game
gameLoop();
```
Note: Make sure to replace "bird.png" with the correct path to your bird image file.