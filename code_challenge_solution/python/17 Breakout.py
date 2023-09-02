import pygame
import random

# Initialize the game
pygame.init()

# Set the screen width and height
screen_width = 800
screen_height = 600

# Create the game window
screen = pygame.display.set_mode((screen_width, screen_height))
pygame.display.set_caption("Breakout Clone")

# Set the colors
bg_color = (0, 0, 0)
block_color = (255, 255, 255)
paddle_color = (255, 255, 255)
ball_color = (255, 255, 255)

# Set the fonts
font = pygame.font.Font(None, 36)

# Set the paddle size
paddle_width = 100
paddle_height = 10

# Set the ball size
ball_radius = 10

# Set the ball initial speed
ball_speed_x = 3
ball_speed_y = -3

# Set the number of blocks
block_rows = 5
block_columns = 10

# Set the block size
block_width = 70
block_height = 20

# Create the paddle
paddle = pygame.Rect(screen_width // 2 - paddle_width // 2, screen_height - paddle_height - 10, paddle_width, paddle_height)

# Create the ball
ball = pygame.Rect(screen_width // 2 - ball_radius, screen_height // 2 - ball_radius, ball_radius * 2, ball_radius * 2)

# Create the blocks
blocks = []
for row in range(block_rows):
    for column in range(block_columns):
        block_x = column * (block_width + 10) + 50
        block_y = row * (block_height + 10) + 50
        block = pygame.Rect(block_x, block_y, block_width, block_height)
        blocks.append(block)

# Start the game loop
running = True
while running:
    # Handle events
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
    
    # Move the paddle
    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT] and paddle.left > 0:
        paddle.x -= 5
    if keys[pygame.K_RIGHT] and paddle.right < screen_width:
        paddle.x += 5
    
    # Move the ball
    ball.x += ball_speed_x
    ball.y += ball_speed_y
    
    # Check for collision with paddle
    if ball.colliderect(paddle):
        ball_speed_y = -ball_speed_y
    
    # Check for collision with walls
    if ball.left < 0 or ball.right > screen_width:
        ball_speed_x = -ball_speed_x
    if ball.top < 0:
        ball_speed_y = -ball_speed_y
    
    # Check for collision with blocks
    for block in blocks:
        if ball.colliderect(block):
            blocks.remove(block)
            ball_speed_y = -ball_speed_y
            break
    
    # Update the screen
    screen.fill(bg_color)
    pygame.draw.rect(screen, paddle_color, paddle)
    pygame.draw.circle(screen, ball_color, ball.center, ball_radius)
    for block in blocks:
        pygame.draw.rect(screen, block_color, block)
    
    # Check for game over
    if ball.bottom > screen_height:
        game_over_text = font.render("Game Over", True, (255, 255, 255))
        screen.blit(game_over_text, (screen_width // 2 - game_over_text.get_width() // 2, screen_height // 2 - game_over_text.get_height() // 2))
        running = False
    
    # Check for victory
    if len(blocks) == 0:
        victory_text = font.render("You Win", True, (255, 255, 255))
        screen.blit(victory_text, (screen_width // 2 - victory_text.get_width() // 2, screen_height // 2 - victory_text.get_height() // 2))
        running = False
    
    pygame.display.flip()

# Quit the game
pygame.quit()