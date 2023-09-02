import java.util.*;

public class TicTacToe {
    private static final int SIZE = 3;
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    
    private char[][] board;
    private char currentPlayer;
    
    public TicTacToe() {
        board = new char[SIZE][SIZE];
        currentPlayer = PLAYER_X;
        initializeBoard();
    }
    
    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }
    
    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean hasWinner = false;
        
        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();
        
        while (!hasWinner && !isBoardFull()) {
            System.out.println("Player " + currentPlayer + ", choose a row (0-2):");
            int row = scanner.nextInt();
            System.out.println("Player " + currentPlayer + ", choose a column (0-2):");
            int col = scanner.nextInt();
            
            if (isValidMove(row, col)) {
                makeMove(row, col);
                printBoard();
                
                if (hasPlayerWon()) {
                    hasWinner = true;
                    System.out.println("Player " + currentPlayer + " wins!");
                } else {
                    switchPlayers();
                }
            } else {
                System.out.println("Invalid move. Try again!");
            }
        }
        
        if (!hasWinner) {
            System.out.println("It's a draw.");
        }
        
        scanner.close();
    }
    
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY;
    }
    
    private void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }
    
    private boolean hasPlayerWon() {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        
        return false;
    }
    
    private boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private void switchPlayers() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }
    
    private void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < SIZE - 1) {
                System.out.println("---------");
            }
        }
    }
    
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}