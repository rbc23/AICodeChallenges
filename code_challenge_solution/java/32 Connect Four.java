
import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        char[][] board = createBoard();
        boolean gameOver = false;
        char currentPlayer = 'R';

        while (!gameOver) {
            printBoard(board);
            int column = getColumn(board, currentPlayer);
            dropPiece(board, column, currentPlayer);
            if (checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (checkDraw(board)) {
                printBoard(board);
                System.out.println("It's a draw!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R';
            }
        }
    }

    public static char[][] createBoard() {
        char[][] board = new char[6][7];
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                board[row][col] = ' ';
            }
        }
        return board;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print("|" + board[row][col]);
            }
            System.out.println("|");
        }
        System.out.println("---------------");
        System.out.println(" 1 2 3 4 5 6 7 ");
    }

    public static int getColumn(char[][] board, char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        int column;
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter column number (1-7): ");
            column = scanner.nextInt();
            if (column >= 1 && column <= 7 && board[0][column - 1] == ' ') {
                break;
            }
            System.out.println("Invalid column number. Please try again.");
        }
        return column - 1;
    }

    public static void dropPiece(char[][] board, int column, char currentPlayer) {
        for (int row = 5; row >= 0; row--) {
            if (board[row][column] == ' ') {
                board[row][column] = currentPlayer;
                break;
            }
        }
    }

    public static boolean checkWin(char[][] board, char currentPlayer) {
        // Check horizontal
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] == currentPlayer && board[row][col + 1] == currentPlayer
                        && board[row][col + 2] == currentPlayer && board[row][col + 3] == currentPlayer) {
                    return true;
                }
            }
        }

        // Check vertical
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col] == currentPlayer && board[row + 1][col] == currentPlayer
                        && board[row + 2][col] == currentPlayer && board[row + 3][col] == currentPlayer) {
                    return true;
                }
            }
        }

        // Check diagonal (top-left to bottom-right)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] == currentPlayer && board[row + 1][col + 1] == currentPlayer
                        && board[row + 2][col + 2] == currentPlayer && board[row + 3][col + 3] == currentPlayer) {
                    return true;
                }
            }
        }

        // Check diagonal (top-right to bottom-left)
        for (int row = 0; row < 3; row++) {
            for (int col = 3; col < 7; col++) {
                if (board[row][col] == currentPlayer && board[row + 1][col - 1] == currentPlayer
                        && board[row + 2][col - 2] == currentPlayer && board[row + 3][col - 3] == currentPlayer) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkDraw(char[][] board) {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
