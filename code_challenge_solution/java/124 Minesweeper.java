import java.util.Random;
import java.util.Scanner;

public class MinesweeperClone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the board: ");
        int size = scanner.nextInt();
        
        System.out.print("Enter the number of mines: ");
        int numMines = scanner.nextInt();
        
        char[][] board = new char[size][size];
        boolean[][] revealed = new boolean[size][size];
        boolean[][] flagged = new boolean[size][size];
        
        initializeBoard(board);
        placeMines(board, numMines);
        
        boolean gameWon = false;
        boolean gameLost = false;
        
        while (!gameWon && !gameLost) {
            printBoard(board, revealed, flagged);
            
            System.out.print("Enter row number: ");
            int row = scanner.nextInt();
            
            System.out.print("Enter column number: ");
            int col = scanner.nextInt();
            
            if (board[row][col] == 'M') {
                gameLost = true;
            } else {
                revealCell(board, revealed, row, col);
                
                if (checkWin(board, revealed, numMines)) {
                    gameWon = true;
                }
            }
        }
        
        System.out.println();
        printBoard(board, revealed, flagged);
        
        if (gameWon) {
            System.out.println("Congratulations! You won the game!");
        } else {
            System.out.println("Game over! You hit a mine!");
        }
    }
    
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }
    
    public static void placeMines(char[][] board, int numMines) {
        Random random = new Random();
        int count = 0;
        
        while (count < numMines) {
            int row = random.nextInt(board.length);
            int col = random.nextInt(board[row].length);
            
            if (board[row][col] != 'M') {
                board[row][col] = 'M';
                count++;
            }
        }
    }
    
    public static void printBoard(char[][] board, boolean[][] revealed, boolean[][] flagged) {
        System.out.print("   ");
        
        for (int i = 0; i < board[0].length; i++) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            
            for (int j = 0; j < board[i].length; j++) {
                if (flagged[i][j]) {
                    System.out.print("F ");
                } else if (revealed[i][j]) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            
            System.out.println();
        }
    }
    
    public static void revealCell(char[][] board, boolean[][] revealed, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return;
        }
        
        if (revealed[row][col]) {
            return;
        }
        
        revealed[row][col] = true;
        
        if (board[row][col] == ' ') {
            revealAdjacentCells(board, revealed, row, col);
        }
    }
    
    public static void revealAdjacentCells(char[][] board, boolean[][] revealed, int row, int col) {
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < dr.length; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            
            revealCell(board, revealed, newRow, newCol);
        }
    }
    
    public static boolean checkWin(char[][] board, boolean[][] revealed, int numMines) {
        int count = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (revealed[i][j] && board[i][j] != 'M') {
                    count++;
                }
            }
        }
        
        return count == board.length * board[0].length - numMines;
    }
}

