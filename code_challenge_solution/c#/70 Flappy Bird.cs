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
        static int consoleWidth;
        static int consoleHeight;
        static int birdPositionX;
        static int birdPositionY;
        static int score;
        static bool gameOver;

        static void Main(string[] args)
        {
            InitializeGame();

            while (!gameOver)
            {
                DrawBird();
                DrawPipes();
                UpdateScore();
                if (Console.KeyAvailable)
                {
                    HandleKeyPress();
                }

                MoveBird();
                MovePipes();
                CheckCollision();

                if (birdPositionY >= consoleHeight || birdPositionY < 0)
                {
                    GameOver();
                }

                Thread.Sleep(20);
                Console.Clear();
            }
        }

        static void InitializeGame()
        {
            consoleWidth = Console.WindowWidth;
            consoleHeight = Console.WindowHeight;
            birdPositionX = consoleWidth / 3;
            birdPositionY = consoleHeight / 2;
            score = 0;
            gameOver = false;

            Console.CursorVisible = false;
        }

        static void DrawBird()
        {
            Console.SetCursorPosition(birdPositionX, birdPositionY);
            Console.Write(">");
        }

        static void MoveBird()
        {
            if (birdPositionY + 1 < consoleHeight && !gameOver)
            {
                birdPositionY++;
            }
        }

        static void DrawPipes()
        {
            int gapSize = 10;

            for (int i = 1; i < consoleHeight - gapSize - 1; i++)
            {
                Console.SetCursorPosition(consoleWidth / 2 - 1, i);
                Console.Write("|");
            }

            for (int i = consoleHeight - gapSize; i < consoleHeight - 1; i++)
            {
                Console.SetCursorPosition(consoleWidth / 2 - 1, i);
                Console.Write("|");
            }
        }

        static void MovePipes()
        {
            for (int i = 1; i < consoleHeight - 1; i++)
            {
                for (int j = consoleWidth / 2 - 1; j < consoleWidth / 2 + 1; j++)
                {
                    Console.SetCursorPosition(j, i);
                    Console.Write(" ");
                }
            }
        }

        static void UpdateScore()
        {
            score++;
            Console.SetCursorPosition(consoleWidth - 10, 0);
            Console.Write("Score: " + score);
        }

        static void HandleKeyPress()
        {
            ConsoleKey key = Console.ReadKey(true).Key;

            if (key == ConsoleKey.Spacebar && birdPositionY > 0)
            {
                birdPositionY -= 2;
            }
            else if (key == ConsoleKey.Escape)
            {
                GameOver();
            }
        }

        static void CheckCollision()
        {
            bool collision = false;

            for (int i = 1; i < consoleHeight - 1; i++)
            {
                if ((birdPositionY <= i || birdPositionY + 1 >= i + 10) && birdPositionX >= consoleWidth / 2 - 1 && birdPositionX <= consoleWidth / 2)
                {
                    collision = true;
                    break;
                }
            }

            if (collision)
            {
                GameOver();
            }
        }

        static void GameOver()
        {
            gameOver = true;
            Console.Clear();
            Console.SetCursorPosition(consoleWidth / 2 - 5, consoleHeight / 2);
            Console.Write("Game Over!");
            Console.SetCursorPosition(consoleWidth / 2 - 7, consoleHeight / 2 + 1);
            Console.Write("Final Score: " + score);
            Console.SetCursorPosition(consoleWidth / 2 - 11, consoleHeight / 2 + 2);
            Console.Write("Press any key to exit...");
            Console.ReadKey();
            Environment.Exit(0);
        }
    }
}