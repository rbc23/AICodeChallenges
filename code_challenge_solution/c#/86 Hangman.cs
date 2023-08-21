using System;

namespace HangmanGame
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] words = { "hangman", "computer", "programming", "player", "secret" };

            Random random = new Random();
            string selectedWord = words[random.Next(0, words.Length)];

            char[] guessedLetters = new char[selectedWord.Length];
            for (int i = 0; i < guessedLetters.Length; i++)
            {
                guessedLetters[i] = '_';
            }

            int attempts = 6;
            bool gameOver = false;

            while (!gameOver)
            {
                Console.Clear();
                Console.WriteLine("Hangman");
                Console.WriteLine("Attempts remaining: " + attempts);
                Console.WriteLine();

                for (int i = 0; i < guessedLetters.Length; i++)
                {
                    Console.Write(guessedLetters[i] + " ");
                }

                Console.WriteLine();
                Console.WriteLine();

                Console.Write("Enter a letter: ");
                char input = Console.ReadKey().KeyChar;
                Console.WriteLine();

                bool correctGuess = false;

                for (int i = 0; i < selectedWord.Length; i++)
                {
                    if (selectedWord[i] == input)
                    {
                        guessedLetters[i] = input;
                        correctGuess = true;
                    }
                }

                if (!correctGuess)
                {
                    attempts--;
                }

                if (attempts == 0)
                {
                    gameOver = true;
                }
                else if (String.Join("", guessedLetters) == selectedWord)
                {
                    gameOver = true;
                    Console.WriteLine("Congratulations! You guessed the word.");
                }
            }

            Console.WriteLine();
            Console.WriteLine("Game Over.");
            Console.WriteLine("The word was: " + selectedWord);
            Console.ReadKey();
        }
    }
}