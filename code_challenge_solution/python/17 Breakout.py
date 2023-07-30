import pygame
import random

# Initialize pygame
pygame.init()

# Set the dimensions of the game window
WIDTH = 800
HEIGHT = 600

# Set the colors
BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
BLUE = (0, 0, 255)
RED = (255, 0, 0)

# Set the paddle properties
PADDLE_WIDTH = 100
PADDLE_HEIGHT = 20
PADDLE_SPEED = 5

# Set the ball properties
BALL_RADIUS = 10
BALL_SPEED_X = 3
BALL_SPEED_Y = -3

# Create the game window
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Breakout Clone")

clock = pygame.time.Clock()

# Function to draw the paddle
def draw_paddle(paddle_x, paddle_y):
    pygame.draw.rect(screen, BLUE, (paddle_x, paddle_y, PADDLE_WIDTH, PADDLE_HEIGHT))

# Function to draw the ball
def draw_ball(ball_x, ball_y):
    pygame.draw.circle(screen, RED, (ball_x, ball_y), BALL_RADIUS)

# Function to update the ball's position
def update_ball_position(ball_x, ball_y, ball_speed_x, ball_speed_y):
    ball_x += ball_speed_x
    ball_y += ball_speed_y
    return ball_x, ball_y

# Function to check collision with the walls
def check_wall_collision(ball_x, ball_y, ball_speed_x, ball_speed_y):
    if ball_x - BALL_RADIUS <= 0 or ball_x + BALL_RADIUS >= WIDTH:
        ball_speed_x *= -1
    if ball_y - BALL_RADIUS <= 0:
        ball_speed_y *= -1
    return ball_speed_x, ball_speed_y

# Function to check collision with the paddle
def check_paddle_collision(ball_x, ball_y, ball_speed_x, ball_speed_y, paddle_x, paddle_y):
    if ball_y + BALL_RADIUS >= HEIGHT - PADDLE_HEIGHT and ball_x >= paddle_x and ball_x <= paddle_x + PADDLE_WIDTH:
        ball_speed_y *= -1
    return ball_speed_x, ball_speed_y

# Function to check collision with the bricks
def check_brick_collision(ball_x, ball_y, ball_speed_x, ball_speed_y, bricks):
    for row in range(len(bricks)):
        for col in range(len(bricks[row])):
            brick_x = col * (WIDTH // len(bricks[0])) + 50
            brick_y = row * 20 + 50
            brick_width = WIDTH // len(bricks[0]) - 10
            brick_height = 20
            if ball_x >= brick_x and ball_x <= brick_x + brick_width and ball_y - BALL_RADIUS <= brick_y + brick_height:
                ball_speed_y *= -1
                bricks[row][col] = 0
    return ball_speed_x, ball_speed_y, bricks

# Function to draw the bricks
def draw_bricks(bricks):
    for row in range(len(bricks)):
        for col in range(len(bricks[row])):
            brick_x = col * (WIDTH // len(bricks[0])) + 50
            brick_y = row * 20 + 50
            brick_width = WIDTH // len(bricks[0]) - 10
            brick_height = 20
            if bricks[row][col] == 1:
                pygame.draw.rect(screen, WHITE, (brick_x, brick_y, brick_width, brick_height))

# Initialize the paddle position and velocity
paddle_x = (WIDTH - PADDLE_WIDTH) // 2
paddle_y = HEIGHT - PADDLE_HEIGHT - 10
paddle_vel = 0

# Initialize the ball position and velocity
ball_x = WIDTH // 2
ball_y = HEIGHT // 2
ball_speed_x = BALL_SPEED_X
ball_speed_y = BALL_SPEED_Y

# Initialize the bricks
bricks = []
for row in range(5):
    bricks.append([1] * 10)

# Game loop
running = True
while running:
    # Fill the screen with black color
    screen.fill(BLACK)

    # Handle events
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                paddle_vel = -PADDLE_SPEED
            elif event.key == pygame.K_RIGHT:
                paddle_vel = PADDLE_SPEED
        elif event.type == pygame.KEYUP:
            if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
                paddle_vel = 0

    # Update the paddle position
    paddle_x += paddle_vel
    if paddle_x < 0:
        paddle_x = 0
    elif paddle_x + PADDLE_WIDTH > WIDTH:
        paddle_x = WIDTH - PADDLE_WIDTH

    # Draw the paddle
    draw_paddle(paddle_x, paddle_y)

    # Update the ball position
    ball_x, ball_y = update_ball_position(ball_x, ball_y, ball_speed_x, ball_speed_y)

    # Check for collision with walls
    ball_speed_x, ball_speed_y = check_wall_collision(ball_x, ball_y, ball_speed_x, ball_speed_y)

    # Check for collision with the paddle
    ball_speed_x, ball_speed_y = check_paddle_collision(ball_x, ball_y, ball_speed_x, ball_speed_y, paddle_x, paddle_y)

    # Check for collision with the bricks
    ball_speed_x, ball_speed_y, bricks = check_brick_collision(ball_x, ball_y, ball_speed_x, ball_speed_y, bricks)

    # Draw the ball
    draw_ball(ball_x, ball_y)

    # Draw the bricks
    draw_bricks(bricks)

    # Check if all bricks are destroyed
    if sum(sum(row) for row in bricks) == 0:
        running = False

    # Update the screen
    pygame.display.update()

    # Limit the frame rate
    clock.tick(60)

# Quit the game
pygame.quit()
