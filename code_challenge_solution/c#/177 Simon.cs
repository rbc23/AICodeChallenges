using System;
using System.Collections.Generic;

namespace SimonMemoryGame
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to Simon Memory Game!");

            string[] colors = { "Red", "Blue", "Green", "Yellow" };
            List<string> computerSequence = new List<string>();
            List<string> playerSequence = new List<string>();

            bool gameOver = false;
            bool playerCorrect = true;

            Random random = new Random();

            while (!gameOver)
            {
                int nextColorIndex = random.Next(0, colors.Length);
                string nextColor = colors[nextColorIndex];
                computerSequence.Add(nextColor);

                foreach (string color in computerSequence)
                {
                    Console.WriteLine(color);
                    System.Threading.Thread.Sleep(1000);
                    Console.Clear();
                    System.Threading.Thread.Sleep(500);
                }

                Console.WriteLine("Your turn! Repeat the sequence:");

                for (int i = 0; i < computerSequence.Count; i++)
                {
                    string input = Console.ReadLine();
                    playerSequence.Add(input);

                    if (playerSequence[i] != computerSequence[i])
                    {
                        playerCorrect = false;
                        gameOver = true;
                        break;
                    }
                }

                if (playerCorrect)
                {
                    Console.WriteLine("Correct! Next round...");
                    playerSequence.Clear();
                    System.Threading.Thread.Sleep(1500);
                }
                else
                {
                    Console.WriteLine("Wrong sequence! Game over.");
                    Console.WriteLine("Final score: " + (computerSequence.Count - 1));
                }
            }
        }
    }
}