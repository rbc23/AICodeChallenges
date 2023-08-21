import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
        String userChoice, computerChoice;
        int computerValue;
        boolean playAgain = true;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (playAgain) {
            System.out.println("\nLet's play Rock-Paper-Scissors!");
            System.out.print("Choose either Rock, Paper, or Scissors: ");
            userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("rock") || userChoice.equals("paper") || userChoice.equals("scissors")) {
                computerValue = random.nextInt(3);
                if (computerValue == 0)
                    computerChoice = "rock";
                else if (computerValue == 1)
                    computerChoice = "paper";
                else
                    computerChoice = "scissors";

                System.out.println("Your choice: " + userChoice);
                System.out.println("Computer choice: " + computerChoice);

                if (userChoice.equals(computerChoice))
                    System.out.println("It's a tie!");
                else if (userChoice.equals("rock")) {
                    if (computerChoice.equals("paper"))
                        System.out.println("You lose!");
                    else
                        System.out.println("You win!");
                } else if (userChoice.equals("paper")) {
                    if (computerChoice.equals("scissors"))
                        System.out.println("You lose!");
                    else
                        System.out.println("You win!");
                } else {
                    if (computerChoice.equals("rock"))
                        System.out.println("You lose!");
                    else
                        System.out.println("You win!");
                }

                System.out.print("\nDo you want to play again? (yes/no): ");
                String playAgainChoice = scanner.nextLine().toLowerCase();
                if (playAgainChoice.equals("yes"))
                    playAgain = true;
                else
                    playAgain = false;
            } else {
                System.out.println("Invalid input! Please choose either Rock, Paper, or Scissors.");
            }
        }

        scanner.close();
    }
}