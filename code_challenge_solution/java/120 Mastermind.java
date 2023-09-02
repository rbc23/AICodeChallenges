```java
import java.util.*;

public class Mastermind {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int[] secretCode = generateSecretCode(random);
        int[] guess = new int[4];
        
        boolean gameOver = false;
        int attempts = 0;
        
        System.out.println("Welcome to Mastermind!");
        System.out.println("Guess the 4-digit secret code.");
        System.out.println("Each digit must be between 1 and 6.");
        
        while (!gameOver) {
            System.out.print("Enter your guess: ");
            String guessStr = scanner.nextLine();
            
            if (guessStr.length() != 4) {
                System.out.println("Invalid guess. Please enter 4 digits.");
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                try {
                    guess[i] = Integer.parseInt(guessStr.charAt(i) + "");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid guess. Please enter digits only.");
                    continue;
                }
                
                if (guess[i] < 1 || guess[i] > 6) {
                    System.out.println("Invalid guess. Each digit must be between 1 and 6.");
                    continue;
                }
            }
            
            int[] feedback = getFeedback(secretCode, guess);
            attempts++;
            
            System.out.println("Attempts: " + attempts);
            System.out.println("Feedback: " + Arrays.toString(feedback));
            
            if (Arrays.equals(feedback, new int[] {4, 0})) {
                gameOver = true;
                System.out.println("Congratulations! You have guessed the secret code.");
            }
        }
        
        System.out.println("Game over.");
    }
    
    public static int[] generateSecretCode(Random random) {
        int[] secretCode = new int[4];
        for (int i = 0; i < 4; i++) {
            secretCode[i] = random.nextInt(6) + 1;
        }
        return secretCode;
    }
    
    public static int[] getFeedback(int[] secretCode, int[] guess) {
        int[] feedback = new int[2];
        int[] secretCodeCount = new int[6];
        int[] guessCount = new int[6];
        
        for (int i = 0; i < 4; i++) {
            if (secretCode[i] == guess[i]) {
                feedback[0]++;
            } else {
                secretCodeCount[secretCode[i] - 1]++;
                guessCount[guess[i] - 1]++;
            }
        }
        
        for (int i = 0; i < 6; i++) {
            feedback[1] += Math.min(secretCodeCount[i], guessCount[i]);
        }
        
        return feedback;
    }
}
```