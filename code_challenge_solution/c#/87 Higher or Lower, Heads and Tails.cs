```csharp
using System;

namespace HigherOrLowerHeadsOrTails
{
    class Program
    {
        static void Main(string[] args)
        {
            // Guess higher or lower
            Console.WriteLine("Guess if the next number will be higher or lower than the previous one");

            Random random = new Random();
            int previousNumber = random.Next(1, 101);
            Console.WriteLine("First number: " + previousNumber);

            bool guessedCorrectly = true;

            while (guessedCorrectly)
            {
                Console.Write("Will the next number be higher (H) or lower (L)? ");
                string userInput = Console.ReadLine();

                int nextNumber = random.Next(1, 101);
                Console.WriteLine("Next number: " + nextNumber);

                if ((userInput.ToUpper() == "H" && nextNumber > previousNumber) ||
                        (userInput.ToUpper() == "L" && nextNumber < previousNumber))
                {
                    Console.WriteLine("Correct guess! Keep going...\n");
                    previousNumber = nextNumber;
                }
                else
                {
                    Console.WriteLine("Wrong guess! Game over.");
                    guessedCorrectly = false;
                }
            }

            Console.WriteLine("\n\n");

            // Flip coins
            Console.WriteLine("Guess the outcome of coin flips (Heads or Tails)");

            int numberOfFlips = 3;
            int correctGuesses = 0;

            for (int i = 0; i < numberOfFlips; i++)
            {
                Console.Write($"Flip #{i+1}: ");

                int flip = random.Next(2);
                string flipResult = flip == 0 ? "Heads" : "Tails";

                string userInput = Console.ReadLine();

                if (userInput.Equals(flipResult, StringComparison.OrdinalIgnoreCase))
                {
                    Console.WriteLine("Correct guess!");
                    correctGuesses++;
                }
                else
                {
                    Console.WriteLine("Wrong guess!");
                }
            }

            Console.WriteLine($"You guessed {correctGuesses} out of {numberOfFlips} correctly.");
        }
    }
}
```