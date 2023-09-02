Here is the C# code for creating a Hangman word guessing game:

```csharp
using System;

namespace HangmanGame
{
    class Program
    {
        static void Main(string[] args)
        {
            string secretWord = "hangman"; // The secret word to be guessed
            string guessedWord = ""; // The word that the user is trying to guess
            int attempts = 7; // Number of attempts remaining

            Console.WriteLine("Welcome to Hangman!");

            // Populate the guessedWord with underscores
            for (int i = 0; i < secretWord.Length; i++)
            {
                guessedWord += "_";
            }

            while (attempts > 0)
            {
                Console.WriteLine("\n" + guessedWord);
                Console.WriteLine("Attempts remaining: " + attempts);
                Console.Write("Enter a letter: ");
                char guess = Console.ReadLine()[0];

                bool found = false;

                // Check if the guessed letter is present in the secret word
                for (int i = 0; i < secretWord.Length; i++)
                {
                    if (secretWord[i] == guess)
                    {
                        // Replace the corresponding underscore in guessedWord with the guessed letter
                        guessedWord = guessedWord.Substring(0, i) + guess + guessedWord.Substring(i + 1);
                        found = true;
                    }
                }

                if (found)
                {
                    Console.WriteLine("Correct!");
                }
                else
                {
                    Console.WriteLine("Wrong!");
                    attempts--;
                }

                // Check if the word has been fully guessed
                if (guessedWord == secretWord)
                {
                    Console.WriteLine("\nCongratulations! You guessed the word: " + secretWord);
                    break;
                }
            }

            if (attempts <= 0)
            {
                Console.WriteLine("\nGame Over! The word was: " + secretWord);
            }

            Console.WriteLine("\nPress any key to exit.");
            Console.ReadKey();
        }
    }
}
```