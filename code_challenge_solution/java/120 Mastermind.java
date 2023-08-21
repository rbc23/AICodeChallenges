
import java.util.*;

public class MastermindGame {
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 10;
    private static final char[] COLORS = {'R', 'G', 'B', 'Y', 'O', 'P'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretCode = generate SecretCode();
        int attempts = 0;

        System.out.println("Welcome to Mastermind!");
        System.out.println("Guess the secret code consisting of 4 colors (R, G, B, Y, O, P).");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts.");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            String guess = scanner.next();

            if (guess.length() != CODE_LENGTH) {
                System.out.println("Invalid guess length! Guess should be of length " + CODE_LENGTH);
                continue;
            }

            if (!isValidCode(guess)) {
                System.out.println("Invalid colors used! Colors should be one of (R, G, B, Y, O, P)");
                continue;
            }

            int[] result = checkGuess(secretCode, guess);
            printResult(result);

            if (result[0] == CODE_LENGTH) {
                System.out.println("Congratulations! You guessed the secret code correctly!");
                break;
            }

            attempts++;
            System.out.println("Attempts remaining: " + (MAX_ATTEMPTS - attempts));
        }

        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Game over! You did not guess the secret code!");
            System.out.println("The secret code was: " + secretCode);
        }
    }

    private static String generateSecretCode() {
        StringBuilder secretCode = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < CODE_LENGTH; i++) {
            secretCode.append(COLORS[random.nextInt(COLORS.length)]);
        }

        return secretCode.toString();
    }

    private static boolean isValidCode(String code) {
        for (char color : code.toCharArray()) {
            if (!Arrays.asList(COLORS).contains(Character.toUpperCase(color))) {
                return false;
            }
        }
        return true;
    }

    private static int[] checkGuess(String secretCode, String guess) {
        int[] result = new int[2];
        boolean[] visited = new boolean[CODE_LENGTH];

        // Check for exact matches
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (secretCode.charAt(i) == guess.charAt(i)) {
                result[0]++;
                visited[i] = true;
            }
        }

        // Check for color matches
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (!visited[i]) {
                for (int j = 0; j < CODE_LENGTH; j++) {
                    if (i != j && secretCode.charAt(i) == guess.charAt(j)) {
                        result[1]++;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }

        return result;
    }

    private static void printResult(int[] result) {
        System.out.println("Exact matches: " + result[0]);
        System.out.println("Color matches: " + result[1]);
    }
}
