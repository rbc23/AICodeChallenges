import java.util.Random;
import java.util.Scanner;

public class HigherOrLowerHeadsAndTails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Guess higher or lower
        System.out.print("Guess higher or lower? (h/l): ");
        String guess = scanner.nextLine();

        // Generate a random number between 1 and 10
        int randomNumber = random.nextInt(10) + 1;

        // Flip a coin
        int coinSide = random.nextInt(2); // 0 for heads, 1 for tails

        // Check if the guess is correct or not
        if ((guess.equals("h") && coinSide == 0) || (guess.equals("l") && coinSide == 1)) {
            System.out.println("Your guess was correct!");
        } else {
            System.out.println("Your guess was incorrect!");
        }

        // Print the randomly generated number
        System.out.println("Random Number: " + randomNumber);

        // Print the result of the coin flip
        System.out.println("Coin Flip: " + (coinSide == 0 ? "Heads" : "Tails"));
    }
}
