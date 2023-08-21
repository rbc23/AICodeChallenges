using System;

namespace Mastermind
{
    class Program
    {
        static void Main(string[] args)
        {
            // Generate random secret code
            Random random = new Random();
            int[] secretCode = new int[4];
            for (int i = 0; i < 4; i++)
            {
                secretCode[i] = random.Next(1, 7);
            }

            bool gameOver = false;
            int attempts = 0;

            Console.WriteLine("Welcome to Mastermind!");
            Console.WriteLine("Guess the 4-digit secret code.");

            while (!gameOver)
            {
                Console.WriteLine();
                Console.WriteLine("Attempt #" + (attempts + 1));

                int[] guess = new int[4];
                for (int i = 0; i < 4; i++)
                {
                    Console.Write("Enter digit #" + (i + 1) + ": ");
                    guess[i] = int.Parse(Console.ReadLine());
                }

                int[] result = new int[2]; // Store the count of exact matches and partial matches

                // Check for exact matches
                for (int i = 0; i < 4; i++)
                {
                    if (guess[i] == secretCode[i])
                    {
                        result[0]++;
                    }
                }

                // Check for partial matches
                for (int i = 0; i < 4; i++)
                {
                    for (int j = 0; j < 4; j++)
                    {
                        if (guess[i] == secretCode[j] && guess[i] != secretCode[i])
                        {
                            result[1]++;
                            break;
                        }
                    }
                }

                Console.WriteLine("Exact Matches: " + result[0]);
                Console.WriteLine("Partial Matches: " + result[1]);

                if (result[0] == 4)
                {
                    gameOver = true;
                }

                attempts++;
            }

            Console.WriteLine();
            Console.WriteLine("Congratulations! You guessed the secret code in " + attempts + " attempts.");
        }
    }
}