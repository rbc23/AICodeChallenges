using System;

namespace HigherLowerHeadsTails
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to Higher or Lower, Heads and Tails!");

            // Game loop
            while (true)
            {
                Console.WriteLine("\nPlease choose:\n1. Higher or Lower\n2. Heads or Tails\n3. Quit");
                int choice = int.Parse(Console.ReadLine());

                // Higher or Lower game
                if (choice == 1)
                {
                    Console.WriteLine("\n--- Higher or Lower ---");

                    Random random = new Random();
                    int numberToGuess = random.Next(100);
                    int attempts = 0;
                    bool guessed = false;

                    while (!guessed)
                    {
                        Console.Write("\nEnter your guess (between 0 and 100): ");
                        int guess = int.Parse(Console.ReadLine());

                        attempts++;

                        if (guess < numberToGuess)
                        {
                            Console.WriteLine("Higher!");
                        }
                        else if (guess > numberToGuess)
                        {
                            Console.WriteLine("Lower!");
                        }
                        else
                        {
                            guessed = true;
                            Console.WriteLine($"\nCongratulations! You guessed the number in {attempts} attempts.");
                        }
                    }
                }

                // Heads or Tails game
                else if (choice == 2)
                {
                    Console.WriteLine("\n--- Heads or Tails ---");

                    Random random = new Random();
                    int coinSide = random.Next(2); // 0 for heads, 1 for tails

                    Console.WriteLine("\nGuess: (0 for heads, 1 for tails)");
                    int guess = int.Parse(Console.ReadLine());

                    if (coinSide == guess)
                    {
                        Console.WriteLine("\nCongratulations! You guessed correctly.");
                    }
                    else
                    {
                        Console.WriteLine("\nOops! You guessed incorrectly.");
                    }
                }

                // Quit the game
                else if (choice == 3)
                {
                    Console.WriteLine("\nThank you for playing! Goodbye!");
                    break;
                }
            }
        }
    }
}