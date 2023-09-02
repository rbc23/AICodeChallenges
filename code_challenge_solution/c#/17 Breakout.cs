using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BreakoutClone
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WindowHeight = 24;
            Console.WindowWidth = 80;
            Console.BufferHeight = 24;
            Console.BufferWidth = 80;

            Paddle paddle = new Paddle(35, 23, 10);
            Ball ball = new Ball(39, 22, 1, 1);
            List<Brick> bricks = new List<Brick>();

            for (int i = 0; i < Console.WindowWidth - 10; i += 10)
            {
                for (int j = 0; j < 5; j++)
                {
                    Brick brick = new Brick(i, j);
                    bricks.Add(brick);
                }
            }

            bool gameOver = false;
            bool gameWon = false;

            while (!gameOver && !gameWon)
            {
                paddle.Draw();
                ball.Draw();

                foreach (Brick brick in bricks)
                {
                    brick.Draw();
                }

                if (Console.KeyAvailable)
                {
                    ConsoleKeyInfo key = Console.ReadKey(true);

                    if (key.Key == ConsoleKey.LeftArrow)
                    {
                        paddle.MoveLeft();
                    }
                    else if (key.Key == ConsoleKey.RightArrow)
                    {
                        paddle.MoveRight();
                    }
                    else if (key.Key == ConsoleKey.Escape)
                    {
                        gameOver = true;
                    }
                }

                ball.Move();

                if (ball.CollisionWithPaddle(paddle))
                {
                    ball.BounceUp();
                }

                foreach (Brick brick in bricks)
                {
                    if (ball.CollisionWithBrick(brick))
                    {
                        bricks.Remove(brick);
                        ball.BounceUp();
                        break;
                    }
                }

                if (ball.HitBottom())
                {
                    gameOver = true;
                }

                if (bricks.Count == 0)
                {
                    gameWon = true;
                }

                System.Threading.Thread.Sleep(10);
                Console.Clear();
            }

            if (gameOver)
            {
                Console.SetCursorPosition(37, 12);
                Console.Write("GAME OVER");
            }
            else if (gameWon)
            {
                Console.SetCursorPosition(38, 12);
                Console.Write("YOU WON!");
            }

            Console.ReadKey();
        }
    }

    class Paddle
    {
        public int X { get; set; }
        public int Y { get; set; }
        public int Width { get; set; }

        public Paddle(int x, int y, int width)
        {
            X = x;
            Y = y;
            Width = width;
        }

        public void MoveLeft()
        {
            if (X > 0)
            {
                X -= 1;
            }
        }

        public void MoveRight()
        {
            if (X < Console.WindowWidth - Width)
            {
                X += 1;
            }
        }

        public void Draw()
        {
            for (int i = X; i < X + Width; i++)
            {
                Console.SetCursorPosition(i, Y);
                Console.Write("#");
            }
        }
    }

    class Ball
    {
        public int X { get; set; }
        public int Y { get; set; }
        public int XSpeed { get; set; }
        public int YSpeed { get; set; }

        public Ball(int x, int y, int xSpeed, int ySpeed)
        {
            X = x;
            Y = y;
            XSpeed = xSpeed;
            YSpeed = ySpeed;
        }

        public void Move()
        {
            if (X == 0 || X == Console.WindowWidth - 1)
            {
                BounceSideways();
            }
            else if (Y == 0)
            {
                BounceUp();
            }

            X += XSpeed;
            Y += YSpeed;
        }

        public void BounceUp()
        {
            YSpeed = -YSpeed;
        }

        public void BounceSideways()
        {
            XSpeed = -XSpeed;
        }

        public bool CollisionWithPaddle(Paddle paddle)
        {
            bool collision = false;

            if (Y == paddle.Y && X >= paddle.X && X <= paddle.X + paddle.Width)
            {
                collision = true;
            }

            return collision;
        }

        public bool CollisionWithBrick(Brick brick)
        {
            bool collision = false;

            if (Y == brick.Y && X >= brick.X && X <= brick.X + brick.Width)
            {
                collision = true;
            }

            return collision;
        }

        public bool HitBottom()
        {
            if (Y == Console.WindowHeight - 1)
            {
                return true;
            }

            return false;
        }

        public void Draw()
        {
            Console.SetCursorPosition(X, Y);
            Console.Write("o");
        }
    }

    class Brick
    {
        public int X { get; set; }
        public int Y { get; set; }
        public int Width { get; set; }

        public Brick(int x, int y)
        {
            X = x;
            Y = y;
            Width = 10;
        }

        public void Draw()
        {
            for (int i = X; i < X + Width; i++)
            {
                Console.SetCursorPosition(i, Y);
                Console.Write("=");
            }
        }
    }
}