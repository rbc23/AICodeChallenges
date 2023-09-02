#include <iostream>
#include <vector>

// Function to print the game board
void printBoard(const std::vector<std::vector<char>>& board) {
    for (int row = 0; row < 6; row++) {
        for (int col = 0; col < 7; col++) {
            std::cout << board[row][col] << " ";
        }
        std::cout << std::endl;
    }
}

// Function to check if there is a winning move
bool checkWin(const std::vector<std::vector<char>>& board, char player) {
    // Check rows
    for (int row = 0; row < 6; row++) {
        for (int col = 0; col < 4; col++) {
            if (board[row][col] == player && board[row][col+1] == player &&
                board[row][col+2] == player && board[row][col+3] == player) {
                return true;
            }
        }
    }
    
    // Check columns
    for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 7; col++) {
            if (board[row][col] == player && board[row+1][col] == player &&
                board[row+2][col] == player && board[row+3][col] == player) {
                return true;
            }
        }
    }
    
    // Check diagonals (top-left to bottom-right)
    for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 4; col++) {
            if (board[row][col] == player && board[row+1][col+1] == player &&
                board[row+2][col+2] == player && board[row+3][col+3] == player) {
                return true;
            }
        }
    }
    
    // Check diagonals (top-right to bottom-left)
    for (int row = 0; row < 3; row++) {
        for (int col = 3; col < 7; col++) {
            if (board[row][col] == player && board[row+1][col-1] == player &&
                board[row+2][col-2] == player && board[row+3][col-3] == player) {
                return true;
            }
        }
    }
    
    return false;
}

int main() {
    std::vector<std::vector<char>> board(6, std::vector<char>(7, ' '));
    int currentPlayer = 1;
    int moves = 0;
    
    while (true) {
        // Print the board
        printBoard(board);
        
        if (currentPlayer == 1) {
            std::cout << "Player 1's turn (X): ";
        } else {
            std::cout << "Player 2's turn (O): ";
        }
        
        int col;
        std::cin >> col;
        
        // Check if the column is valid and make the move
        if (col >= 0 && col < 7 && board[0][col] == ' ') {
            for (int row = 5; row >= 0; row--) {
                if (board[row][col] == ' ') {
                    board[row][col] = (currentPlayer == 1) ? 'X' : 'O';
                    moves++;
                    break;
                }
            }
            
            // Check if there is a winning move
            if (checkWin(board, (currentPlayer == 1) ? 'X' : 'O')) {
                printBoard(board);
                if (currentPlayer == 1) {
                    std::cout << "Player 1 (X) wins!" << std::endl;
                } else {
                    std::cout << "Player 2 (O) wins!" << std::endl;
                }
                break;
            }
            
            // Check if the game is a draw
            if (moves == 42) {
                printBoard(board);
                std::cout << "It's a draw!" << std::endl;
                break;
            }
            
            // Switch players
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        } else {
            std::cout << "Invalid move. Please try again." << std::endl;
        }
    }
    
    return 0;
}