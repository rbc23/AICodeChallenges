import pygame, random

# Initialize pygame
pygame.init()

# Set up the game window
window_width = 800
window_height = 600
window = pygame.display.set_mode((window_width, window_height))
pygame.display.set_caption("Snake Clone")

# Set up the game clock
clock = pygame.time.Clock()

# Set up colors
black = (0, 0, 0)
white = (255, 255, 255)
green = (0, 255, 0)

# Set up the snake and food sizes
snake_size = 20
food_size = 20

# Set up the snake's initial position and movement
snake_x = window_width / 2
snake_y = window_height / 2
snake_x_change = 0
snake_y_change = 0
snake = [(snake_x, snake_y)]

# Set up the food's initial position
food_x = random.randint(0, (window_width - food_size) // food_size) * food_size
food_y = random.randint(0, (window_height - food_size) // food_size) * food_size
food = (food_x, food_y)

# Set up the game over flag
game_over = False

# Main game loop
while not game_over:
    # Handle events
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            game_over = True
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                snake_x_change = -snake_size
                snake_y_change = 0
            elif event.key == pygame.K_RIGHT:
                snake_x_change = snake_size
                snake_y_change = 0
            elif event.key == pygame.K_UP:
                snake_y_change = -snake_size
                snake_x_change = 0
            elif event.key == pygame.K_DOWN:
                snake_y_change = snake_size
                snake_x_change = 0

    # Move the snake
    snake_x += snake_x_change
    snake_y += snake_y_change
    snake_head = (snake_x, snake_y)
    snake.append(snake_head)

    # Check if the snake has collided with the food
    if snake_head == food:
        food_x = random.randint(0, (window_width - food_size) // food_size) * food_size
        food_y = random.randint(0, (window_height - food_size) // food_size) * food_size
        food = (food_x, food_y)
    else:
        snake.pop(0)

    # Check if the snake has collided with the walls or itself
    if snake_x < 0 or snake_x >= window_width or snake_y < 0 or snake_y >= window_height:
        game_over = True
    if snake_head in snake[:-1]:
        game_over = True

    # Update the game window
    window.fill(black)
    pygame.draw.rect(window, green, (food_x, food_y, food_size, food_size))
    for segment in snake:
        pygame.draw.rect(window, white, (segment[0], segment[1], snake_size, snake_size))
    pygame.display.update()

    # Set the game clock speed
    clock.tick(10)

# Clean up pygame
pygame.quit()
