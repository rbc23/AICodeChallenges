Here is the C# code to create a Crossword puzzle game:

```csharp
using System;

namespace CrosswordGame
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] crosswordBoard = new string[10] 
            {
                "X X X X X X X X X X",
                "X     X       X     X",
                "X     X       X     X",
                "X X X X X X X X X X",
                "X     X       X     X",
                "X     X       X     X",
                "X X X X X X X X X X",
                "X     X       X     X",
                "X     X       X     X",
                "X X X X X X X X X X"
            };

            Console.WriteLine("Welcome to Crossword Puzzle Game!");
            Console.WriteLine("Find the hidden words in the crossword below:");
            Console.WriteLine();

            for (int i = 0; i < crosswordBoard.Length; i++)
            {
                Console.WriteLine(crosswordBoard[i]);
            }

            Console.WriteLine();
            Console.WriteLine("List of hidden words:");
            Console.WriteLine("- Word 1");
            Console.WriteLine("- Word 2");
            Console.WriteLine("- Word 3");

            Console.WriteLine();
            Console.WriteLine("Enter your guess:");

            string guess = Console.ReadLine();

            // Check if the guess matches any of the hidden words
            if (guess == "Word 1")
            {
                Console.WriteLine("Congrats! You found Word 1.");
            }
            else if (guess == "Word 2")
            {
                Console.WriteLine("Congrats! You found Word 2.");
            }
            else if (guess == "Word 3")
            {
                Console.WriteLine("Congrats! You found Word 3.");
            }
            else
            {
                Console.WriteLine("Sorry, your guess is incorrect.");
            }
        }
    }
}
```