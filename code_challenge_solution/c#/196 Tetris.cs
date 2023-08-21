using System;

namespace TetrisClone
{
    class Program
    {
        static int width = 10;
        static int height = 20;
        static int[,] grid = new int[height, width];
        static int[,] currentPiece = new int[4, 4];
        static int currentX = width / 2 - 2;
        static int currentY = 0;
        static Random random = new Random();
        static bool gameOver = false;

        static void Main(string[] args)
        {
            InitializeGrid();

            while (!gameOver)
            {
                Console.Clear();
                DrawGrid();
                ProcessInput();
                MovePiece();
                CheckLines();
                CheckGameOver();
                System.Threading.Thread.Sleep(100);
            }

            Console.WriteLine("Game Over!");
            Console.ReadLine();
        }

        static void InitializeGrid()
        {
            for (int i = 0; i < height; i++)
            {
                for (int j = 0; j < width; j++)
                {
                    grid[i, j] = 0;
                }
            }
        }

        static void DrawGrid()
        {
            for (int i = 0; i < height; i++)
            {
                for (int j = 0; j < width; j++)
                {
                    if (grid[i, j] == 0)
                    {
                        Console.Write(".");
                    }
                    else
                    {
                        Console.Write("#");
                    }
                }
                Console.WriteLine();
            }
        }

        static void ProcessInput()
        {
            if (Console.KeyAvailable)
            {
                ConsoleKeyInfo keyInfo = Console.ReadKey(true);
                if (keyInfo.Key == ConsoleKey.LeftArrow)
                {
                    currentX--;
                }
                else if (keyInfo.Key == ConsoleKey.RightArrow)
                {
                    currentX++;
                }
                else if (keyInfo.Key == ConsoleKey.Spacebar)
                {
                    RotatePiece();
                }
            }
        }

        static void MovePiece()
        {
            if (IsValidMove(currentX, currentY + 1, currentPiece))
            {
                currentY++;
            }
            else
            {
                AddPieceToGrid(currentPiece);
                ClearLines();
                GeneratePiece();
            }
        }

        static void RotatePiece()
        {
            int[,] rotatedPiece = new int[4, 4];
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    rotatedPiece[i, j] = currentPiece[j, 3 - i];
                }
            }

            if (IsValidMove(currentX, currentY, rotatedPiece))
            {
                currentPiece = rotatedPiece;
            }
        }

        static bool IsValidMove(int x, int y, int[,] piece)
        {
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    if (piece[i, j] != 0 && (x + j < 0 || x + j >= width || y + i >= height || grid[y + i, x + j] != 0))
                    {
                        return false;
                    }
                }
            }
            return true;
        }

        static void AddPieceToGrid(int[,] piece)
        {
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    if (piece[i, j] != 0)
                    {
                        grid[currentY + i, currentX + j] = 1;
                    }
                }
            }
        }

        static void ClearLines()
        {
            for (int i = height - 1; i >= 0; i--)
            {
                bool lineIsFull = true;
                for (int j = 0; j < width; j++)
                {
                    if (grid[i, j] == 0)
                    {
                        lineIsFull = false;
                        break;
                    }
                }

                if (lineIsFull)
                {
                    for (int k = i; k > 0; k--)
                    {
                        for (int j = 0; j < width; j++)
                        {
                            grid[k, j] = grid[k - 1, j];
                        }
                    }
                }
            }
        }

        static void GeneratePiece()
        {
            currentPiece = new int[4, 4];
            int pieceType = random.Next(7);

            if (pieceType == 0)
            {
                currentPiece = new int[2, 2] { { 1, 1 }, { 1, 1 } };
            }
            else if (pieceType == 1)
            {
                currentPiece = new int[2, 3] { { 1, 1, 1 }, { 0, 0, 0 } };
            }
            else if (pieceType == 2)
            {
                currentPiece = new int[2, 3] { { 1, 1, 1 }, { 1, 0, 0 } };
            }
            else if (pieceType == 3)
            {
                currentPiece = new int[2, 3] { { 1, 1, 1 }, { 0, 0, 1 } };
            }
            else if (pieceType == 4)
            {
                currentPiece = new int[3, 2] { { 1, 1 }, { 1, 0 }, { 1, 0 } };
            }
            else if (pieceType == 5)
            {
                currentPiece = new int[3, 2] { { 1, 1 }, { 0, 1 }, { 0, 1 } };
            }
            else if (pieceType == 6)
            {
                currentPiece = new int[3, 2] { { 0, 1 }, { 0, 1 }, { 1, 1 } };
            }

            currentX = width / 2 - 2;
            currentY = 0;
        }

        static void CheckGameOver()
        {
            for (int j = 0; j < width; j++)
            {
                if (grid[0, j] != 0)
                {
                    gameOver = true;
                    break;
                }
            }
        }

        static void CheckLines()
        {
            int linesCleared = 0;
            for (int i = height - 1; i >= 0; i--)
            {
                bool lineIsFull = true;
                for (int j = 0; j < width; j++)
                {
                    if (grid[i, j] == 0)
                    {
                        lineIsFull = false;
                        break;
                    }
                }

                if (lineIsFull)
                {
                    linesCleared++;
                }
            }

            if (linesCleared > 0)
            {
                Console.WriteLine($"Lines cleared: {linesCleared}");
            }
        }
    }
}
