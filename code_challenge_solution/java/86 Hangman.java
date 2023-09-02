```java
import java.util.*;

public class HangmanGame {
    private static final String[] WORDS = {"programming", "computer", "java", "hangman", "coding"};
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            String secretWord = selectRandomWord();
            char[] guessedLetters = new char[secretWord.length()];
            boolean[] guessed = new boolean[secretWord.length()];
            int incorrectGuesses = 0;

            while (incorrectGuesses < MAX_TRIES) {
                displayHangman(incorrectGuesses);
                displayWord(guessedLetters);

                System.out.print("Enter a letter: ");
                char letter = input.nextLine().toLowerCase().charAt(0);

                if (!isAlpha(letter)) {
                    System.out.println("Invalid input. Please enter a letter.");
                    continue;
                }

                if (alreadyGuessed(letter, guessedLetters)) {
                    System.out.println("You have already guessed this letter.");
                    continue;
                }

                boolean letterFound = false;

                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == letter) {
                        guessedLetters[i] = letter;
                        guessed[i] = true;
                        letterFound = true;
                    }
                }

                if (!letterFound) {
                    incorrectGuesses++;
                    System.out.println("Incorrect guess! You have " + (MAX_TRIES - incorrectGuesses) + " tries left.");
                }

                if (Arrays.equals(guessed, new boolean[guessed.length])) {
                    displayWord(guessedLetters);
                    System.out.println("Congratulations! You have guessed the word correctly.");
                    break;
                }
            }

            if (incorrectGuesses == MAX_TRIES) {
                System.out.println("You have run out of tries! The word was: " + secretWord);
            }

            System.out.print("Would you like to play again? (y/n): ");
            String playAgainInput = input.nextLine().toLowerCase();

            if (!playAgainInput.equals("y")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing Hangman. Goodbye!");
    }

    private static String selectRandomWord() {
        int randomIndex = (int) (Math.random() * WORDS.length);
        return WORDS[randomIndex];
    }

    private static void displayHangman(int incorrectGuesses) {
        String[] hangman = {
                "______",
                "|    |",
                "|    " + (incorrectGuesses > 0 ? "O" : ""),
                "|   " + (incorrectGuesses > 2 ? "/" : " ") + (incorrectGuesses > 1 ? "|" : "") + (incorrectGuesses > 3 ? "\\" : ""),
                "|   " + (incorrectGuesses > 4 ? "/" : "") + " " + (incorrectGuesses > 5 ? "\\" : ""),
                "|",
                "|______"
        };

        for (String line : hangman) {
            System.out.println(line);
        }
    }

    private static void displayWord(char[] guessedLetters) {
        System.out.print("Word: ");

        for (char letter : guessedLetters) {
            if (letter != '\u0000') {
                System.out.print(letter + " ");
            } else {
                System.out.print("_ ");
            }
        }

        System.out.println();
    }

    private static boolean isAlpha(char ch) {
        return Character.isLetter(ch);
    }

    private static boolean alreadyGuessed(char letter, char[] guessedLetters) {
        for (char guessedLetter : guessedLetters) {
            if (guessedLetter == letter) {
                return true;
            }
        }

        return false;
    }
}
```