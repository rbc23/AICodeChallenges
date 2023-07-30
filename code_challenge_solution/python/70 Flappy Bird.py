import pygame
import random

# Initialize pygame
pygame.init()

# Set up display
WIDTH, HEIGHT = 800, 600
WIN = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Flappy Bird")

# Load images
BG_IMAGE = pygame.image.load('background.png')
BIRD_IMAGE = pygame.image.load('bird.png')
PIPE_IMAGE = pygame.image.load('pipe.png')

# Set up the game clock
clock = pygame.time.Clock()

# Game variables
gravity = 0.25
bird_movement = 0
score = 0
high_score = 0

# Function to reset the game
def reset_game():
    bird_rect.center = (100, int(HEIGHT / 2))
    bird_movement = 0
    pipe_list.clear()
    score = 0

# Function to draw background
def draw_background():
    WIN.blit(BG_IMAGE, (0, 0))

# Function to draw bird
def draw_bird():
    WIN.blit(BIRD_IMAGE, bird_rect)

# Function to draw pipes
def draw_pipes():
    for pipe in pipe_list:
        if pipe.bottom >= HEIGHT:
            WIN.blit(PIPE_IMAGE, pipe)
        else:
            flip_pipe = pygame.transform.flip(PIPE_IMAGE, False, True)
            WIN.blit(flip_pipe, pipe)

# Function to move pipes
def move_pipes():
    for pipe in pipe_list:
        pipe.centerx -= 3

# Function to create new pipe
def create_pipe():
    random_height = random.choice(pipe_heights)
    bottom_pipe = PIPE_IMAGE.get_rect(midtop = (WIDTH + 200, random_height))
    top_pipe = PIPE_IMAGE.get_rect(midbottom = (WIDTH + 200, random_height - 150))
    return bottom_pipe, top_pipe

# Function to check collision
def check_collision():
    for pipe in pipe_list:
        if bird_rect.colliderect(pipe):
            return False

    if bird_rect.top <= -100 or bird_rect.bottom >= HEIGHT:
        return False

    return True

# Create bird rectangle
bird_rect = BIRD_IMAGE.get_rect(center = (100, int(HEIGHT / 2)))

# Create list of pipes
pipe_list = []

# Create event for adding new pipe
ADD_PIPE = pygame.USEREVENT
pygame.time.set_timer(ADD_PIPE, 1200)

# Create list of pipe heights
pipe_heights = [200, 300, 400]

# Game loop
running = True
game_active = True

while running:
    # Check for events
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_SPACE and game_active:
                bird_movement = 0
                bird_movement -= 6
            if event.key == pygame.K_SPACE and not game_active:
                reset_game()
                game_active = True
        if event.type == ADD_PIPE:
            pipe_list.extend(create_pipe())

    # Draw background
    draw_background()

    if game_active:
        # Bird movement
        bird_movement += gravity
        bird_rect.centery += bird_movement
        WIN.blit(pygame.transform.rotate(BIRD_IMAGE, -bird_movement * 3), bird_rect)
        game_active = check_collision()

        # Pipes movement
        move_pipes()
        draw_pipes()

        # Score update
        for pipe in pipe_list:
            if pipe.centerx == 100:
                score += 1

        # Draw score
        score_text = pygame.font.Font('freesansbold.ttf', 32).render(f'Score: {score}', True, (255, 255, 255))
        score_rect = score_text.get_rect(center = (WIDTH/2, 50))
        WIN.blit(score_text, score_rect)

    # Update the display
    pygame.display.update()

    # FPS control
    clock.tick(60)

# Quit the game
pygame.quit()
