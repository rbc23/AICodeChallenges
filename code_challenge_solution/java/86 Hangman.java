
import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {"hello", "world", "java", "programming"};
    private static final int MAX_GUESSES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman Game!");
        System.out.println("Let's start!");

        String wordToGuess = getRandomWord();
        char[] guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord[i] = '_';
        }

        int numGuesses = 0;
        while (numGuesses < MAX_GUESSES) {
            System.out.println("Guess the word: " + String.valueOf(guessedWord));
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            if (isLetterGuessed(wordToGuess, guessedWord, guess)) {
                System.out.println("Correct guess!");
            } else {
                System.out.println("Incorrect guess!");
                numGuesses++;
            }

            if (isWordGuessed(guessedWord)) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                break;
            }
        }

        if (numGuesses == MAX_GUESSES) {
            System.out.println("Game over! You ran out of guesses. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    private static String getRandomWord() {
        int randomIndex = (int) (Math.random() * WORDS.length);
        return WORDS[randomIndex];
    }

    private static boolean isLetterGuessed(String wordToGuess, char[] guessedWord, char guess) {
        boolean isGuessed = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                guessedWord[i] = guess;
                isGuessed = true;
            }
        }
        return isGuessed;
    }

    private static boolean isWordGuessed(char[] guessedWord) {
        for (char c : guessedWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}
