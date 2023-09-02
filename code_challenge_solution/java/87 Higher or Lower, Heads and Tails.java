import java.util.Random;
import java.util.Scanner;

public class HigherLowerHeadsTails {

    public static void main(String[] args) {
        System.out.println("Welcome to Higher or Lower, Heads and Tails!");
        System.out.println("--------------------------------------------");

        int score = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Round 1: Higher or Lower");
        int randomNumber1 = random.nextInt(10) + 1;
        System.out.print("Guess a number between 1 and 10: ");
        int guess1 = scanner.nextInt();
        if (guess1 > randomNumber1) {
            System.out.println("Your guess is higher!");
        } else if (guess1 < randomNumber1) {
            System.out.println("Your guess is lower!");
        } else {
            System.out.println("Correct! Your guess matches the random number.");
        }

        System.out.println("--------------------------------------------");

        System.out.println("Round 2: Heads or Tails");
        System.out.print("Guess 'Heads' or 'Tails': ");
        String guess2 = scanner.next();
        int coinResult = random.nextInt(2);
        String coinFace = (coinResult == 0) ? "Heads" : "Tails";
        if (guess2.equalsIgnoreCase(coinFace)) {
            System.out.println("Correct! The coin landed on " + coinFace + ".");
        } else {
            System.out.println("Incorrect! The coin landed on " + coinFace + ".");
        }

        System.out.println("--------------------------------------------");

        System.out.println("Round 3: Flip a Coin");
        System.out.print("Guess 'Heads' or 'Tails': ");
        String guess3 = scanner.next();
        int coinResult2 = random.nextInt(2);
        String coinFace2 = (coinResult2 == 0) ? "Heads" : "Tails";
        if (guess3.equalsIgnoreCase(coinFace2)) {
            System.out.println("Correct! The coin landed on " + coinFace2 + ".");
        } else {
            System.out.println("Incorrect! The coin landed on " + coinFace2 + ".");
        }

        System.out.println("--------------------------------------------");

        score = (guess1 == randomNumber1 ? 1 : 0) + (guess2.equalsIgnoreCase(coinFace) ? 1 : 0)
                + (guess3.equalsIgnoreCase(coinFace2) ? 1 : 0);
        System.out.println("Your final score is: " + score + "/3");

        System.out.println("--------------------------------------------");
        System.out.println("Thank you for playing Higher or Lower, Heads and Tails!");
    }
}