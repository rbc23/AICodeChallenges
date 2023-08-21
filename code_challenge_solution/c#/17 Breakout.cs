using System;
using System.Collections.Generic;

namespace BreakoutClone
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.CursorVisible = false;
            Console.SetWindowSize(80, 30);

            Game game = new Game();
            game.Run();
        }
    }

    class Game
    {
        private const int screenWidth = 80;
        private const int screenHeight = 30;
        private const char paddleSymbol = '-';
        private const char ballSymbol = 'O';
        private const char brickSymbol = '#';

        private int paddleWidth = 10;
        private int paddlePositionX;
        private int paddlePositionY;
        private int ballPositionX;
        private int ballPositionY;
        private int ballDirectionX;
        private int ballDirectionY;
        private bool[,] bricks;
        private bool isGameRunning;

        public Game()
        {
            paddlePositionX = (screenWidth - paddleWidth) / 2;
            paddlePositionY = screenHeight - 1;
            ballPositionX = screenWidth / 2;
            ballPositionY = screenHeight - 2;
            ballDirectionX = 1;
            ballDirectionY = -1;
            bricks = new bool[screenWidth, screenHeight / 2];
            isGameRunning = true;
        }

        public void Run()
        {
            InitializeBricks();

            while (isGameRunning)
            {
                HandleInput();
                Update();
                Render();

                System.Threading.Thread.Sleep(10);
            }
        }

        private void InitializeBricks()
        {
            for (int y = 0; y < screenHeight / 2; y++)
            {
                for (int x = 0; x < screenWidth; x++)
                {
                    bricks[x, y] = true;
                }
            }
        }

        private void HandleInput()
        {
            if (Console.KeyAvailable)
            {
                ConsoleKeyInfo keyInfo = Console.ReadKey(true);

                if (keyInfo.Key == ConsoleKey.LeftArrow)
                {
                    MovePaddle(-1);
                }
                else if (keyInfo.Key == ConsoleKey.RightArrow)
                {
                    MovePaddle(1);
                }
                else if (keyInfo.Key == ConsoleKey.Escape)
                {
                    isGameRunning = false;
                }
            }
        }

        private void MovePaddle(int direction)
        {
            if (paddlePositionX + direction >= 0 && paddlePositionX + paddleWidth - 1 + direction < screenWidth)
            {
                paddlePositionX += direction;
            }
        }

        private void Update()
        {
            MoveBall();
            CheckCollision();
            CheckBrickCollision();
            CheckGameOver();
        }

        private void MoveBall()
        {
            if (ballPositionX + ballDirectionX >= screenWidth || ballPositionX + ballDirectionX < 0)
            {
                ballDirectionX *= -1;
            }

            if (ballPositionY + ballDirectionY < 0)
            {
                ballDirectionY *= -1;
            }

            if (ballPositionY + ballDirectionY >= screenHeight)
            {
                isGameRunning = false;
            }

            ballPositionX += ballDirectionX;
            ballPositionY += ballDirectionY;
        }

        private void CheckCollision()
        {
            if (ballPositionY == paddlePositionY - 1 && ballPositionX >= paddlePositionX && ballPositionX <= paddlePositionX + paddleWidth - 1)
            {
                ballDirectionY *= -1;
            }
        }

        private void CheckBrickCollision()
        {
            int brickX = ballPositionX;
            int brickY = ballPositionY;

            if (brickY < screenHeight / 2 && bricks[brickX, brickY])
            {
                bricks[brickX, brickY] = false;
                ballDirectionY *= -1;
            }
        }

        private void CheckGameOver()
        {
            for (int y = 0; y < screenHeight / 2; y++)
            {
                for (int x = 0; x < screenWidth; x++)
                {
                    if (bricks[x, y])
                    {
                        return;
                    }
                }
            }

            isGameRunning = false;
        }

        private void Render()
        {
            Console.Clear();

            DrawPaddle();
            DrawBall();
            DrawBricks();

            Console.SetCursorPosition(0, 0);
        }

        private void DrawPaddle()
        {
            Console.SetCursorPosition(paddlePositionX, paddlePositionY);
            Console.Write(new string(paddleSymbol, paddleWidth));
        }

        private void DrawBall()
        {
            Console.SetCursorPosition(ballPositionX, ballPositionY);
            Console.Write(ballSymbol);
        }

        private void DrawBricks()
        {
            for (int y = 0; y < screenHeight / 2; y++)
            {
                for (int x = 0; x < screenWidth; x++)
                {
                    if (bricks[x, y])
                    {
                        Console.SetCursorPosition(x, y);
                        Console.Write(brickSymbol);
                    }
                }
            }
        }
    }
}