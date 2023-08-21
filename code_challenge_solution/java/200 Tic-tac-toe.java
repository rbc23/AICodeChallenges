import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }
    
    public void playGame() {
        boolean gameFinished = false;
        int row, col;
        
        while (!gameFinished) {
            System.out.println("Player " + currentPlayer + ", enter your move (row [0-2] and column [0-2]): ");
            Scanner scanner = new Scanner(System.in);
            row = scanner.nextInt();
            col = scanner.nextInt();
            
            while (!isValidMove(row, col)) {
                System.out.println("Invalid move! Try again.");
                row = scanner.nextInt();
                col = scanner.nextInt();
            }

            makeMove(row, col);
            printBoard();
            
            if (hasWon()) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameFinished = true;
            } else if (isBoardFull()) {
                System.out.println("It's a tie!");
                gameFinished = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }
    
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    private boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }
    
    private void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }
    
    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private boolean hasWon() {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
            
            // Check columns
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }
        
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;
        
        return false;
    }
    
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-')
                    return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}

