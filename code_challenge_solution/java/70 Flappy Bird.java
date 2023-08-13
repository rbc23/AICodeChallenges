Sure, here is the JavaScript code for a basic Flappy Bird clone:

```javascript
// Constants
const GRAVITY = 0.6;
const JUMP_FORCE = 9;
const PIPE_GAP = 200;
const PIPE_VELOCITY = 2;

// Variables
let canvas, context;
let bird, pipes;
let score;

// Initialize the game
function init() {
  canvas = document.getElementById("canvas");
  context = canvas.getContext("2d");
  
  bird = {
    x: 50,
    y: canvas.height / 2,
    velocity: 0
  };
  
  pipes = [
    { x: canvas.width, y: 0 }
  ];
  
  score = 0;
  
  document.addEventListener("keydown", jump);
  
  setInterval(update, 1000 / 60);
}

// Update the game state
function update() {
  // Clear the canvas
  context.clearRect(0, 0, canvas.width, canvas.height);
  
  bird.velocity += GRAVITY;
  bird.y += bird.velocity;
  
  // Draw bird
  context.fillStyle = "yellow";
  context.fillRect(bird.x, bird.y, 50, 50);
  
  // Draw pipes
  context.fillStyle = "green";
  for (let i = 0; i < pipes.length; i++) {
    let pipe = pipes[i];
    pipe.x -= PIPE_VELOCITY;
    
    // Check collision with bird
    if (bird.x + 50 > pipe.x && bird.x < pipe.x + 100 &&
        (bird.y < pipe.y || bird.y + 50 > pipe.y + PIPE_GAP)) {
      gameOver();
    }
    
    // Check if bird passed the pipe
    if (bird.x > pipe.x + 100 && !pipe.passed) {
      score++;
      pipe.passed = true;
    }
    
    // Draw top pipe
    context.fillRect(pipe.x, pipe.y, 100, canvas.height);
    
    // Draw bottom pipe
    context.fillRect(pipe.x, pipe.y + PIPE_GAP, 100, canvas.height);
  }
  
  // Remove pipes that are outside of the canvas
  if (pipes[0].x < -100) {
    pipes.shift();
  }
  
  // Add new pipe
  if (pipes[pipes.length - 1].x < canvas.width - 300) {
    let pipe = {
      x: canvas.width,
      y: Math.random() * (canvas.height - PIPE_GAP)
    };
    
    pipes.push(pipe);
  }
  
  // Draw score
  context.fillStyle = "white";
  context.font = "24px Arial";
  context.fillText("Score: " + score, 10, 30);
}

// Make the bird jump
function jump(event) {
  if (event.keyCode === 32 || event.keyCode === 38) {
    bird.velocity = -JUMP_FORCE;
  }
}

// Game over
function gameOver() {
  // Stop the game
  clearInterval(update);
  
  // Display game over message
  context.fillStyle = "red";
  context.font = "48px Arial";
  context.fillText("Game Over", canvas.width / 2 - 120, canvas.height / 2);
  
  // Restart the game
  setTimeout(init, 2000);
}

// Start the game
init();
```

Make sure to include an HTML file with a canvas element with id "canvas" to run this example.