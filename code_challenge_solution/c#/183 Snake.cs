using System;
using System.Collections.Generic;

namespace SnakeGame
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WindowHeight = 16;
            Console.WindowWidth = 32;
            int speed = 100;
            int score = 0;
            int gameover = 0;

            Console.BufferHeight = Console.WindowHeight;
            Console.BufferWidth = Console.WindowWidth;

            Random randomnummer = new Random();
            int foodDingPosX = randomnummer.Next(0, Console.WindowWidth);
            int foodDingPosY = randomnummer.Next(0, Console.WindowHeight);

            int[] posX = new int[50];
            posX[0] = 10;
            int[] posY = new int[50];
            posY[0] = 10;
            int snakeLength = 3;
            int direction = 0;
            ConsoleKeyInfo knop;
            do
            {
                Console.Clear();
                for (int i = snakeLength; i >= 0; i--)
                {
                    Console.SetCursorPosition(posX[i], posY[i]);
                    if (i == 0)
                        Console.ForegroundColor = ConsoleColor.Green;
                    else
                        Console.ForegroundColor = ConsoleColor.DarkGreen;
                    Console.Write("■");
                }

                if (Console.KeyAvailable)
                {
                    knop = Console.ReadKey(true);
                    //Console.WriteLine(knop.Key.ToString());
                    switch (knop.Key)
                    {
                        case ConsoleKey.UpArrow:
                            direction = 0;
                            break;
                        case ConsoleKey.RightArrow:
                            direction = 1;
                            break;
                        case ConsoleKey.DownArrow:
                            direction = 2;
                            break;
                        case ConsoleKey.LeftArrow:
                            direction = 3;
                            break;
                    }
                }

                switch (direction)
                {
                    case 0:
                        posY[0]--;
                        break;
                    case 1:
                        posX[0]++;
                        break;
                    case 2:
                        posY[0]++;
                        break;
                    case 3:
                        posX[0]--;
                        break;
                }

                if (posX[0] == foodDingPosX && posY[0] == foodDingPosY)
                {
                    snakeLength++;
                    score++;
                    speed--;
                    foodDingPosX = randomnummer.Next(0, Console.WindowWidth);
                    foodDingPosY = randomnummer.Next(0, Console.WindowHeight);
                }

                if (posX[0] < 0 || posX[0] >= Console.WindowWidth || posY[0] < 0 || posY[0] >= Console.WindowHeight)
                {
                    gameover = 1;
                }

                for (int i = 2; i < snakeLength; i++)
                {
                    if (posX[i] == posX[0] && posY[i] == posY[0])
                    {
                        gameover = 1;
                    }
                }

                System.Threading.Thread.Sleep(speed);
            } while (gameover == 0);
            Console.SetCursorPosition(10, 10);
            Console.WriteLine("Game over, Score: " + score);
            Console.ReadLine();
        }
    }
}