import random

# Define the crossword puzzle
crossword_puzzle = [
    ['C', 'R', 'O', 'S', 'S', 'W', 'O', 'R', 'D'],
    ['P', 'Y', 'T', 'H', 'O', 'N', 'I', 'S', 'T'],
    ['L', 'I', 'S', 'T', 'D', 'I', 'C', 'T', 'S'],
    ['F', 'U', 'N', 'C', 'T', 'I', 'O', 'N', 'S'],
    ['V', 'A', 'R', 'I', 'A', 'B', 'L', 'E', 'S'],
]

# Define the clues
clues = {
    'CROSSWORD': 'A word puzzle',
    'PYTHON': 'A programming language',
    'LIST': 'A sequence of elements',
    'FUNCTIONS': 'Reusable blocks of code',
    'VARIABLES': 'Containers for storing data',
}

# Print the crossword puzzle
print('Crossword Puzzle:')
for row in crossword_puzzle:
    print(' '.join(row))

# Get the user's guess
guess = input('Enter your guess: ')

# Check if the user's guess is correct
if guess.upper() in clues:
    print('Correct guess!')
    print('Clue:', clues[guess.upper()])
else:
    print('Wrong guess. Try again!')