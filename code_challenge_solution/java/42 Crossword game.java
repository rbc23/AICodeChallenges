
import java.util.Arrays;
import java.util.Scanner;

public class CrosswordGame {
    public static void main(String[] args) {
        char[][] crossword = {
                {'h', 'e', 'l', 'l', 'o'},
                {'w', 'o', 'r', 'l', 'd'},
                {'j', 'a', 'v', 'a', 'x'},
                {'p', 'r', 'o', 'g', 'r'},
                {'a', 'm', 'm', 'e', 'r'}
        };

        System.out.println("Welcome to Crossword Game!");
        System.out.println("Try to guess the hidden word.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter row number (1-5):");
            int row = scanner.nextInt();

            System.out.println("Enter column number (1-5):");
            int col = scanner.nextInt();

            if (row < 1 || row > 5 || col < 1 || col > 5) {
                System.out.println("Invalid input! Row and column numbers should be between 1 and 5.");
                continue;
            }

            System.out.println("Enter your guess:");
            char guess = scanner.next().charAt(0);

            if (crossword[row - 1][col - 1] == guess) {
                System.out.println("Congratulations! Your guess is correct.");
            } else {
                System.out.println("Sorry, your guess is incorrect.");
            }

            System.out.println("Do you want to play again? (Y/N)");
            String playAgain = scanner.next();

            if (playAgain.equalsIgnoreCase("N")) {
                break;
            }
        }

        System.out.println("Thank you for playing Crossword Game!");
    }
}
