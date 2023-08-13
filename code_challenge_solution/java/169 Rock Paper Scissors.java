```
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] choices = {"rock", "paper", "scissors"};
        
        String userChoice;
        String computerChoice;
        
        System.out.println("Welcome to Rock Paper Scissors game!");
        System.out.println("Enter your choice (rock, paper, or scissors):");
        userChoice = scanner.nextLine().toLowerCase();
        
        int randomIndex = (int) (Math.random() * 3);
        computerChoice = choices[randomIndex];
        
        System.out.println("Your choice: " + userChoice);
        System.out.println("Computer's choice: " + computerChoice);
        
        if (userChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            System.out.println("Congratulations! You win!");
        } else {
            System.out.println("Sorry, you lose!");
        }
    }
}
```