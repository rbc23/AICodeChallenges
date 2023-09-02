```java
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] choices = {"Rock", "Paper", "Scissors"};
        
        System.out.println("Welcome to Rock Paper Scissors game!");
        System.out.println("Enter your choice (Rock, Paper, or Scissors): ");
        String playerChoice = scanner.nextLine();
        
        Random random = new Random();
        int computerChoiceIndex = random.nextInt(choices.length);
        String computerChoice = choices[computerChoiceIndex];
        
        System.out.println("Player chose: " + playerChoice);
        System.out.println("Computer chose: " + computerChoice);
        
        if (playerChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
        
        scanner.close();
    }
}
```