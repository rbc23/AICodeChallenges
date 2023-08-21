using System;

namespace CrosswordGame
{
    class Program
    {
        static void Main(string[] args)
        {
            string[,] crossword = new string[,]
            {
                { "T", "H", "I", "S" },
                { "W", "", "", "" },
                { "I", "", "", "" },
                { "S", "", "", "" }
            };

            Console.WriteLine("Welcome to Crossword Puzzle Game!");
            Console.WriteLine("There is a word hidden in the crossword. Try to guess it!");

            Console.WriteLine("Here is your crossword:");
            PrintCrossword(crossword);

            Console.WriteLine("Enter your guess:");

            string guess = Console.ReadLine().ToUpper();

            if (guess == "THIS")
            {
                Console.WriteLine("Congratulations! You guessed the right word!");
            }
            else
            {
                Console.WriteLine("Sorry, your guess is incorrect.");
            }

            Console.WriteLine("Thank you for playing!");

            Console.ReadLine();
        }

        static void PrintCrossword(string[,] crossword)
        {
            int rows = crossword.GetLength(0);
            int cols = crossword.GetLength(1);

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    if (crossword[i, j] == "")
                    {
                        Console.Write(" ");
                    }
                    else
                    {
                        Console.Write(crossword[i, j]);
                    }
                }

                Console.WriteLine();
            }
        }
    }
}