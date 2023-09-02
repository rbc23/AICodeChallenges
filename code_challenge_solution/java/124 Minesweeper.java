import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    private int row;
    private int col;
    private int numOfMines;
    private char[][] board;
    private boolean[][] revealed;

    public Minesweeper(int row, int col, int numOfMines) {
        this.row = row;
        this.col = col;
        this.numOfMines = numOfMines;
        this.board = new char[row][col];
        this.revealed = new boolean[row][col];
        initializeBoard();
        placeMines();
    }

    private void initializeBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        int count = 0;
        while (count < numOfMines) {
            int x = random.nextInt(row);
            int y = random.nextInt(col);
            if (board[x][y] != '*') {
                board[x][y] = '*';
                count++;
            }
        }
    }

    private void revealCell(int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col || revealed[x][y]) {
            return;
        }

        revealed[x][y] = true;

        if (board[x][y] != '-') {
            return;
        }

        int count = countAdjacentMines(x, y);
        if (count > 0) {
            board[x][y] = (char) (count + '0');
        } else {
            board[x][y] = ' ';
            revealCell(x - 1, y - 1);
            revealCell(x - 1, y);
            revealCell(x - 1, y + 1);
            revealCell(x, y - 1);
            revealCell(x, y + 1);
            revealCell(x + 1, y - 1);
            revealCell(x + 1, y);
            revealCell(x + 1, y + 1);
        }
    }

    private int countAdjacentMines(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && board[newX][newY] == '*') {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean hasWon() {
        int revealedCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (revealed[i][j]) {
                    revealedCount++;
                }
            }
        }
        return revealedCount == (row * col) - numOfMines;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printBoard();

            System.out.print("Enter row (0-" + (row - 1) + "): ");
            int x = scanner.nextInt();

            System.out.print("Enter column (0-" + (col - 1) + "): ");
            int y = scanner.nextInt();

            if (board[x][y] == '*') {
                System.out.println("Game Over!");
                break;
            }

            revealCell(x, y);

            if (hasWon()) {
                System.out.println("Congratulations! You have won the game!");
                break;
            }
        }
    }

    private void printBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (revealed[i][j]) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Minesweeper game = new Minesweeper(10, 10, 10);
        game.play();
    }
}