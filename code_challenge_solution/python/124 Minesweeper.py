import random

def create_board(rows, cols):
    board = []
    for _ in range(rows):
        row = [' ']*cols
        board.append(row)
    return board

def place_mines(board, num_mines):
    rows = len(board)
    cols = len(board[0])
    mines_placed = 0
    while mines_placed < num_mines:
        row = random.randint(0, rows-1)
        col = random.randint(0, cols-1)
        if board[row][col] != '*':
            board[row][col] = '*'
            mines_placed += 1

def count_adjacent_mines(board, row, col):
    count = 0
    rows = len(board)
    cols = len(board[0])
    for i in range(max(0, row-1), min(rows, row+2)):
        for j in range(max(0, col-1), min(cols, col+2)):
            if board[i][j] == '*':
                count += 1
    return count

def reveal_cell(board, revealed, row, col):
    if revealed[row][col]:
        return
    revealed[row][col] = True
    if board[row][col] != ' ':
        return
    rows = len(board)
    cols = len(board[0])
    for i in range(max(0, row-1), min(rows, row+2)):
        for j in range(max(0, col-1), min(cols, col+2)):
            reveal_cell(board, revealed, i, j)

def print_board(board, revealed):
    rows = len(board)
    cols = len(board[0])
    print('    ' + '  '.join([str(i) for i in range(cols)]))
    print('  ' + '-' * (4*cols-1))
    for i in range(rows):
        print('{} | '.format(i), end='')
        for j in range(cols):
            if revealed[i][j]:
                print('{} | '.format(board[i][j]), end='')
            else:
                print('  | ', end='')
        print()
        print('  ' + '-' * (4*cols-1))

def play_game(rows, cols, num_mines):
    board = create_board(rows, cols)
    revealed = [[False]*cols for _ in range(rows)]
    place_mines(board, num_mines)

    game_over = False
    while not game_over:
        print_board(board, revealed)

        row = int(input("Enter row: "))
        col = int(input("Enter col: "))

        if board[row][col] == '*':
            revealed[row][col] = True
            print('Game Over! You hit a mine.')
            game_over = True
        else:
            reveal_cell(board, revealed, row, col)
            if all(board[i][j] != ' ' or revealed[i][j] for i in range(rows) for j in range(cols)):
                print_board(board, revealed)
                print('Congratulations! You won.')
                game_over = True

play_game(8, 8, 10)