Sure! Here's the Java code to create a crossword puzzle game:

```java
import java.util.Scanner;

public class CrosswordGame {
    private static final int BOARD_SIZE = 5;

    // The crossword puzzle board
    private char[][] board;
  
    // The crossword puzzle solution
    private String[][] solution;

    public void startGame() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        solution = new String[BOARD_SIZE][BOARD_SIZE];
        
        initializeBoard();
        initializeSolution();
        
        boolean gameWon = false;
        
        while (!gameWon) {
            displayBoard();
            
            String word = getPlayerInput();
            int[] coordinates = findWordCoordinates(word);
            
            if (coordinates != null) {
                int row = coordinates[0];
                int col = coordinates[1];
                
                placeWordOnBoard(word, row, col);
                updateSolution(word, row, col);
                
                if (checkGameWon()) {
                    gameWon = true;
                    System.out.println("Congratulations! You've won the game!");
                }
            } else {
                System.out.println("Invalid word. Please try again.");
            }
        }
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void initializeSolution() {
        solution[0][0] = "CROSS";
        solution[0][1] = "WORLD";
        solution[0][2] = "JAVA";
        solution[0][3] = "CODE";
        solution[0][4] = "GAME";

        solution[1][0] = "-";
        solution[1][1] = "-";
        solution[1][2] = "O";
        solution[1][3] = "-";
        solution[1][4] = "A";

        solution[2][0] = "-";
        solution[2][1] = "-";
        solution[2][2] = "D";
        solution[2][3] = "-";
        solution[2][4] = "M";

        solution[3][0] = "-";
        solution[3][1] = "-";
        solution[3][2] = "E";
        solution[3][3] = "-";
        solution[3][4] = "E";

        solution[4][0] = "-";
        solution[4][1] = "-";
        solution[4][2] = "S";
        solution[4][3] = "-";
        solution[4][4] = "S";
    }

    private void displayBoard() {
        System.out.println("\nCurrent Board:");

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private String getPlayerInput() {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("\nEnter a word to place on the board: ");
        String word = inputScanner.nextLine();
        
        return word.toUpperCase();
    }

    private int[] findWordCoordinates(String word) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (solution[i][j].charAt(0) == word.charAt(0)) {
                    if (checkWordFits(word, i, j)) {
                        int[] coordinates = {i, j};
                        return coordinates;
                    }
                }
            }
        }
        return null;
    }

    private boolean checkWordFits(String word, int row, int col) {
        // Check if word fits horizontally
        if (col + word.length() <= BOARD_SIZE) {
            for (int i = 0; i < word.length(); i++) {
                if (solution[row][col + i].equals("-") || solution[row][col + i].equals(word.charAt(i) + "")) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }

        // Check if word fits vertically
        if (row + word.length() <= BOARD_SIZE) {
            for (int i = 0; i < word.length(); i++) {
                if (solution[row + i][col].equals("-") || solution[row + i][col].equals(word.charAt(i) + "")) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
        
        return false;
    }

    private void placeWordOnBoard(String word, int row, int col) {
        // Place word horizontally
        if (col + word.length() <= BOARD_SIZE) {
            for (int i = 0; i < word.length(); i++) {
                board[row][col + i] = word.charAt(i);
            }
        }

        // Place word vertically
        if (row + word.length() <= BOARD_SIZE) {
            for (int i = 0; i < word.length(); i++) {
                board[row + i][col] = word.charAt(i);
            }
        }
    }
    
    private void updateSolution(String word, int row, int col) {
        // Update solution horizontally
        if (col + word.length() <= BOARD_SIZE) {
            for (int i = 0; i < word.length(); i++) {
                if (solution[row][col + i].equals("-")) {
                    solution[row][col + i] = word.charAt(i) + "";
                }
            }
        }

        // Update solution vertically
        if (row + word.length() <= BOARD_SIZE) {
            for (int i = 0; i < word.length(); i++) {
                if (solution[row + i][col].equals("-")) {
                    solution[row + i][col] = word.charAt(i) + "";
                }
            }
        }
    }
    
    private boolean checkGameWon() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (solution[i][j].equals("-")) {
                    if (board[i][j] == '-') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CrosswordGame game = new CrosswordGame();
        game.startGame();
    }
}
```

This program allows a player to play a crossword puzzle game. The player is prompted to enter a word, and the program checks if the word fits horizontally or vertically on the crossword puzzle board. If the word fits, it is placed on the board and the solution is updated accordingly. The game continues until the player successfully fills all the positions on the board, and a congratulatory message is displayed.