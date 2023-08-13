```javascript
// Snake Class
class Snake {
  constructor() {
    this.body = [
      { x: 9, y: 9 }
    ];
    this.direction = { x: 0, y: 0 };
    this.food = { x: 3, y: 3 };
    this.score = 0;
    this.isGameover = false;
  }

  // Move the snake
  move() {
    if (this.isGameover) return;

    const head = { x: this.body[0].x + this.direction.x, y: this.body[0].y + this.direction.y };
    this.body.unshift(head);

    if (head.x === this.food.x && head.y === this.food.y) {
      this.score++;
      this.generateFood();
    } else {
      this.body.pop();
    }

    this.checkCollision();
  }

  // Change the direction of the snake
  changeDirection(direction) {
    if (direction === "up" && this.direction.y !== 1) {
      this.direction = { x: 0, y: -1 };
    }
    if (direction === "down" && this.direction.y !== -1) {
      this.direction = { x: 0, y: 1 };
    }
    if (direction === "left" && this.direction.x !== 1) {
      this.direction = { x: -1, y: 0 };
    }
    if (direction === "right" && this.direction.x !== -1) {
      this.direction = { x: 1, y: 0 };
    }
  }

  // Generate food for the snake
  generateFood() {
    const maxX = 19;
    const maxY = 19;
    this.food = {
      x: Math.floor(Math.random() * maxX) + 1,
      y: Math.floor(Math.random() * maxY) + 1
    };

    // If the food is generated on the snake's body, regenerate it
    for (const part of this.body) {
      if (part.x === this.food.x && part.y === this.food.y) {
        this.generateFood();
        break;
      }
    }
  }

  // Check if snake hits the wall or itself
  checkCollision() {
    const head = this.body[0];

    if (head.x < 0 || head.x >= 20 || head.y < 0 || head.y >= 20) {
      this.isGameover = true;
    }

    for (let i = 1; i < this.body.length; i++) {
      if (head.x === this.body[i].x && head.y === this.body[i].y) {
        this.isGameover = true;
        break;
      }
    }
  }
}

// Game Class
class Game {
  constructor() {
    this.snake = new Snake();
    this.interval = null;
    this.direction = "";
  }

  // Initialize the game
  init() {
    document.addEventListener("keydown", this.handleKeyPress.bind(this));
    this.interval = setInterval(this.update.bind(this), 200);
  }

  // Handle key press events
  handleKeyPress(event) {
    if (event.key === "ArrowUp" && this.direction !== "down") {
      this.direction = "up";
    }
    if (event.key === "ArrowDown" && this.direction !== "up") {
      this.direction = "down";
    }
    if (event.key === "ArrowLeft" && this.direction !== "right") {
      this.direction = "left";
    }
    if (event.key === "ArrowRight" && this.direction !== "left") {
      this.direction = "right";
    }
  }

  // Update the game state
  update() {
    this.snake.changeDirection(this.direction);
    this.snake.move();

    if (this.snake.isGameover) {
      this.gameOver();
    } else {
      this.draw();
    }
  }

  // Draw the game board
  draw() {
    const board = document.getElementById("board");
    board.innerHTML = "";

    const food = document.createElement("div");
    food.className = "food";
    food.style.gridColumnStart = this.snake.food.x;
    food.style.gridRowStart = this.snake.food.y;
    board.appendChild(food);

    for (const part of this.snake.body) {
      const segment = document.createElement("div");
      segment.className = "segment";
      segment.style.gridColumnStart = part.x;
      segment.style.gridRowStart = part.y;
      board.appendChild(segment);
    }
  }

  // Game over. Stop the game and display final score
  gameOver() {
    clearInterval(this.interval);
    const score = document.getElementById("score");
    score.textContent = `Game Over! Score: ${this.snake.score}`;
  }
}

// Start the game
const game = new Game();
game.init();
```