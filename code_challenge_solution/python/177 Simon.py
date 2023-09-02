import random
import time

# Set up the colors and sounds for the game
COLORS = ['R', 'G', 'B', 'Y']
SOUNDS = {
    'R': '\a',
    'G': '\b',
    'B': '\c',
    'Y': '\d'
}

# Function to play a sound for a given color
def play_sound(color):
    print(SOUNDS[color])

# Function to display the sequence of colors
def display_sequence(sequence):
    for color in sequence:
        play_sound(color)
        time.sleep(1)

# Function to get the player's input and check if it matches the sequence
def get_input(sequence):
    player_sequence = []
    for _ in range(len(sequence)):
        color = input("Enter the next color (R, G, B, Y): ")
        while color not in COLORS:
            color = input("Invalid color, enter again (R, G, B, Y): ")
        player_sequence.append(color.upper())
    return player_sequence

# Function to check if the player's sequence matches the generated sequence
def check_match(sequence, player_sequence):
    return sequence == player_sequence

# Function to play the game
def play_game():
    sequence = []
    while True:
        sequence.append(random.choice(COLORS))
        display_sequence(sequence)
        player_sequence = get_input(sequence)
        if not check_match(sequence, player_sequence):
            print("Game over!")
            break
        print("Correct! Next round.")

# Start the game
play_game()
