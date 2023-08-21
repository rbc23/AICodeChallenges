using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace FlappyBirdClone
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WindowHeight = 30;
            Console.WindowWidth = 80;
            int playfieldWidth = 80;
            int livesCount = 5;
            double speed = 100.0;
            double acceleration = 0.5;
            int score = 0;

            Console.BufferHeight = Console.WindowHeight;
            //create bird
            UserPlayer bird = new UserPlayer();
            bird.x = playfieldWidth / 2;
            bird.y = Console.WindowHeight / 2;
            List<int> obstacles = new List<int>();
            Random randomGenerator = new Random();

            while (true)
            {
                bool hitted = false;

                speed += acceleration;
                if (speed > 500)
                {
                    speed = 500;
                }

                if (Console.KeyAvailable)
                {
                    ConsoleKeyInfo userInput = Console.ReadKey();
                    if (userInput.Key == ConsoleKey.Spacebar)
                    {
                        bird.y -= 2;
                    }
                }

                List<int> newList = new List<int>();

                for (int i = 0; i < obstacles.Count; i += 2)
                {
                    int currentObstacle = obstacles[i];
                    int currentWidth = obstacles[i + 1];

                    currentObstacle--;

                    if (currentObstacle > 0)
                    {
                        newList.Add(currentObstacle);
                        newList.Add(currentWidth);
                    }
                    else
                    {
                        score++;
                    }

                    if (bird.y == currentWidth && bird.x == currentObstacle)
                    {
                        hitted = true;
                    }

                    if (bird.y == currentWidth && bird.x == currentObstacle + 1)
                    {
                        hitted = true;
                    }

                    if (bird.y == currentWidth - 1 && bird.x == currentObstacle)
                    {
                        hitted = true;
                    }

                    if (bird.y == currentWidth - 1 && bird.x == currentObstacle + 1)
                    {
                        hitted = true;
                    }
                }

                obstacles = newList;

                if (hitted)
                {
                    livesCount--;
                    speed -= 20;
                    if (speed < 0)
                    {
                        speed = 0;
                    }
                    obstacles.Clear();
                    bird = new UserPlayer();
                    bird.x = playfieldWidth / 2;
                    bird.y = Console.WindowHeight / 2;
                    Console.Clear();
                    if (livesCount <= 0)
                    {
                        Console.WriteLine("Game over!");
                        return;
                    }
                }

                //create obstacles
                if (obstacles.Count == 0)
                {
                    int randomObstacleSize = randomGenerator.Next(0, 5);
                    for (int i = 0; i < randomObstacleSize; i++)
                    {
                        obstacles.Add(Console.WindowHeight - i);
                        obstacles.Add(randomGenerator.Next(0, playfieldWidth));
                    }
                }
                else
                {
                    for (int i = 0; i < obstacles.Count; i++)
                    {
                        if (i % 2 == 0)
                        {
                            obstacles[i]--;
                        }
                    }
                }
                Console.Clear();

                // draw bird
                if (speed < 200)
                {
                    PrintOnPosition(bird.x, bird.y, "(", ConsoleColor.Yellow);
                    PrintOnPosition(bird.x + 1, bird.y, ")", ConsoleColor.Yellow);
                }
                else
                {
                    PrintOnPosition(bird.x, bird.y, "(", ConsoleColor.Red);
                    PrintOnPosition(bird.x + 1, bird.y, ")", ConsoleColor.Red);
                }

                //draw obstacles
                for (int i = 0; i < obstacles.Count; i += 2)
                {
                    int currentObstacle = obstacles[i];
                    int currentWidth = obstacles[i + 1];
                    PrintOnPosition(currentWidth, currentObstacle, "#", ConsoleColor.Cyan);
                    PrintOnPosition(currentWidth + 1, currentObstacle, "#", ConsoleColor.Cyan);
                    PrintOnPosition(currentWidth, currentObstacle - 1, "#", ConsoleColor.Cyan);
                    PrintOnPosition(currentWidth + 1, currentObstacle - 1, "#", ConsoleColor.Cyan);
                }

                //draw score and lives
                PrintStringOnPosition(playfieldWidth + 3, 2, "Lives: " + livesCount, ConsoleColor.White);
                PrintStringOnPosition(playfieldWidth + 3, 4, "Score: " + score, ConsoleColor.White);

                //slow down program
                Thread.Sleep((int)(500 - speed));
            }
        }

        static void PrintOnPosition(int x, int y, string c, ConsoleColor color)
        {
            Console.SetCursorPosition(x, y);
            Console.ForegroundColor = color;
            Console.Write(c);
        }

        static void PrintStringOnPosition(int x, int y, string str, ConsoleColor color)
        {
            Console.SetCursorPosition(x, y);
            Console.ForegroundColor = color;
            Console.Write(str);
        }

        struct UserPlayer
        {
            public int x;
            public int y;
        }
    }
}