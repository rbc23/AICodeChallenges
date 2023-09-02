import random

# List of words for the crossword puzzle
words = ['python', 'code', 'programming', 'algorithm', 'variable', 'function', 'loop', 'string']

# Function to create the crossword puzzle grid
def create_grid(words):
    
    # Find the length of the longest word
    max_length = max(len(word) for word in words)
    
    # Initialize the grid with empty spaces
    grid = [[' ' for _ in range(max_length)] for _ in range(max_length)]
    
    # Place the words on the grid
    for word in words:
        # Choose a random starting position and direction for the word
        row, col, direction = random.randint(0, max_length-1), random.randint(0, max_length-1), random.choice(['horizontal', 'vertical'])
        
        # Check if the word fits in the chosen direction
        if direction == 'horizontal' and col + len(word) > max_length:
            continue
        elif direction == 'vertical' and row + len(word) > max_length:
            continue

        # Place the word on the grid
        for i in range(len(word)):
            if direction == 'horizontal':
                grid[row][col+i] = word[i]
            else:
                grid[row+i][col] = word[i]
    
    return grid

# Function to display the crossword puzzle grid
def display_grid(grid):
    for row in grid:
        print(' '.join(row))

# Function to play the crossword puzzle game
def play_game():
    print('Welcome to Crossword Puzzle Game!')
    print('Try to guess the words hidden in the puzzle grid.')
    
    # Create the crossword puzzle grid
    grid = create_grid(words)
    
    # Display the crossword puzzle grid
    display_grid(grid)
    
    # Start the game loop
    while True:
        guess = input('Enter your guess (or q to quit): ')
        
        if guess == 'q':
            break
        
        # Check if the guess is correct
        found = False
        for word in words:
            if guess.lower() == word:
                print('Congratulations! You found the word', word)
                found = True
                break
        
        if not found:
            print('Sorry, that word is not in the puzzle.')
    
    print('Thanks for playing!')
    

# Start the game
play_game()