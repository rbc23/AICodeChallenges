```python
# Creating the Tic-tac-toe game

# Create a 3x3 board
board = [[' ' for _ in range(3)] for _ in range(3)]

# Function to print the board
def print_board():
    for row in board:
        print(' | '.join(row))
        print('---------')

# Function to check if there is a winning combination
def check_winner(symbol):
    # Check rows
    for row in board:
        if all(cell == symbol for cell in row):
            return True
    
    # Check columns
    for col in range(3):
        if all(board[i][col] == symbol for i in range(3)):
            return True
    
    # Check diagonals
    if board[0][0] == symbol and board[1][1] == symbol and board[2][2] == symbol:
        return True
    if board[0][2] == symbol and board[1][1] == symbol and board[2][0] == symbol:
        return True
    
    return False

# Function to check if the board is full
def is_board_full():
    for row in board:
        if ' ' in row:
            return False
    return True

# Function to play the game
def play_game():
    # Variable to keep track of the current turn
    turn = 'X'
    
    # Variable to keep count of the number of turns played
    num_turns = 0
    
    while True:
        # Print the board
        print_board()
        
        # Get the row and column from the user
        row = int(input('Enter the row (0-2): '))
        col = int(input('Enter the column (0-2): '))
        
        # Check if the selected position is empty
        if board[row][col] == ' ':
            # Update the board with the current symbol
            board[row][col] = turn
            
            # Increment the number of turns played
            num_turns += 1
            
            # Check if the current player has won
            if check_winner(turn):
                print_board()
                print(f'Player {turn} wins!')
                break
            
            # Check if the board is full and there is no winner
            if num_turns == 9:
                print_board()
                print('It\'s a tie!')
                break
            
            # Switch the turn to the other player
            turn = 'O' if turn == 'X' else 'X'
        else:
            print('Invalid move! Try again.')


# Start the game
play_game()
```
