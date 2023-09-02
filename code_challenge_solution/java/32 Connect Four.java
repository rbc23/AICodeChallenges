```java
import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY = '-';
    private static final char PLAYER1 = 'X';
    private static final char PLAYER2 = 'O';

    private char[][] board;
    private char currentPlayer;

    public ConnectFour() {
        board = new char[ROWS][COLUMNS];
        currentPlayer = PLAYER1;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        
        while (!gameOver) {
            System.out.println("Current board:");
            printBoard();
            
            System.out.print("Player " + currentPlayer + ", choose a column (1-" + COLUMNS + "): ");
            int col = scanner.nextInt() - 1;
            
            if (col < 0 || col >= COLUMNS) {
                System.out.println("Invalid column! Please choose a column between 1 and " + COLUMNS + ".");
                continue;
            }
            
            if (!isColumnFull(col)) {
                int row = dropPiece(col);
                if (checkWin(row, col)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;
                }
            } else {
                System.out.println("Column is full! Please choose another column.");
            }
        }
        
        scanner.close();
    }

    private void printBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    private boolean isColumnFull(int col) {
        return board[0][col] != EMPTY;
    }

    private int dropPiece(int col) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == EMPTY) {
                board[row][col] = currentPlayer;
                return row;
            }
        }
        return -1; // Should never happen if isColumnFull() is called first
    }

    private boolean checkWin(int row, int col) {
        return checkVerticalWin(row, col) || checkHorizontalWin(row, col) || checkDiagonalWin(row, col);
    }

    private boolean checkVerticalWin(int row, int col) {
        int count = 0;
        for (int i = row; i < ROWS && board[i][col] == currentPlayer; i++) {
            count++;
        }
        return count >= 4;
    }

    private boolean checkHorizontalWin(int row, int col) {
        int count = 0;
        for (int i = col - 3; i <= col + 3; i++) {
            if (i >= 0 && i + 3 < COLUMNS &&
                    board[row][i] == currentPlayer &&
                    board[row][i + 1] == currentPlayer &&
                    board[row][i + 2] == currentPlayer &&
                    board[row][i + 3] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalWin(int row, int col) {
        int count = 0;
        for (int i = -3; i <= 3; i++) {
            if (row + i >= 0 && row + i + 3 < ROWS && col + i >= 0 && col + i + 3 < COLUMNS &&
                    board[row + i][col + i] == currentPlayer &&
                    board[row + i + 1][col + i + 1] == currentPlayer &&
                    board[row + i + 2][col + i + 2] == currentPlayer &&
                    board[row + i + 3][col + i + 3] == currentPlayer) {
                return true;
            }
            if (row - i >= 0 && row - i - 3 < ROWS && col + i >= 0 && col + i + 3 < COLUMNS &&
                    board[row - i][col + i] == currentPlayer &&
                    board[row - i - 1][col + i + 1] == currentPlayer &&
                    board[row - i - 2][col + i + 2] == currentPlayer &&
                    board[row - i - 3][col + i + 3] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int col = 0; col < COLUMNS; col++) {
            if (!isColumnFull(col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        game.playGame();
    }
}
```