```csharp
using System;
using System.Collections.Generic;

namespace SimonClone
{
    class Program
    {
        static List<int> sequence = new List<int>();
        static Random random = new Random();
        static int score = 0;
        static bool gameOver = false;

        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to Simon Clone!");
            Console.WriteLine("Repeat the sequence by pressing the corresponding keys.");
            Console.WriteLine("Press any key to start...");
            Console.ReadKey();
            Console.Clear();

            while (!gameOver)
            {
                sequence.Add(random.Next(0, 4));
                PlaySequence();
                GetUserInput();
                score++;
            }

            Console.WriteLine($"Game Over! Your score is: {score}");
            Console.WriteLine("Press any key to exit...");
            Console.ReadKey();
        }

        static void PlaySequence()
        {
            foreach (int color in sequence)
            {
                Console.Clear();
                Console.WriteLine("Simon Clone");
                Console.WriteLine("--------------");

                if (color == 0)
                {
                    Console.WriteLine("Red");
                    Console.Beep(200, 500);
                }
                else if (color == 1)
                {
                    Console.WriteLine("Green");
                    Console.Beep(300, 500);
                }
                else if (color == 2)
                {
                    Console.WriteLine("Blue");
                    Console.Beep(400, 500);
                }
                else if (color == 3)
                {
                    Console.WriteLine("Yellow");
                    Console.Beep(500, 500);
                }

                System.Threading.Thread.Sleep(800);
                Console.Clear();
                System.Threading.Thread.Sleep(200);
            }
        }

        static void GetUserInput()
        {
            for (int i = 0; i < sequence.Count; i++)
            {
                Console.WriteLine("Your turn:");
                Console.WriteLine("--------------");
                Console.WriteLine("Red: R");
                Console.WriteLine("Green: G");
                Console.WriteLine("Blue: B");
                Console.WriteLine("Yellow: Y");

                ConsoleKeyInfo keyInfo = Console.ReadKey();
                Console.WriteLine();

                if (keyInfo.Key == ConsoleKey.R && sequence[i] == 0)
                {
                    Console.WriteLine("Correct!");
                    Console.Beep(200, 500);
                }
                else if (keyInfo.Key == ConsoleKey.G && sequence[i] == 1)
                {
                    Console.WriteLine("Correct!");
                    Console.Beep(300, 500);
                }
                else if (keyInfo.Key == ConsoleKey.B && sequence[i] == 2)
                {
                    Console.WriteLine("Correct!");
                    Console.Beep(400, 500);
                }
                else if (keyInfo.Key == ConsoleKey.Y && sequence[i] == 3)
                {
                    Console.WriteLine("Correct!");
                    Console.Beep(500, 500);
                }
                else
                {
                    Console.WriteLine("Wrong sequence! Game over.");
                    gameOver = true;
                    break;
                }

                System.Threading.Thread.Sleep(800);
                Console.Clear();
                System.Threading.Thread.Sleep(200);
            }
        }
    }
}
```