using System;

namespace Minesweeper
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to Minesweeper!");

            Console.Write("Enter the number of rows: ");
            int rows = Convert.ToInt32(Console.ReadLine());

            Console.Write("Enter the number of columns: ");
            int columns = Convert.ToInt32(Console.ReadLine());

            Console.Write("Enter the number of mines: ");
            int mines = Convert.ToInt32(Console.ReadLine());

            char[,] minefield = GenerateMinefield(rows, columns, mines);
            char[,] displayBoard = GenerateDisplayBoard(rows, columns);

            bool gameOver = false;
            bool win = false;

            while (!gameOver && !win)
            {
                Console.Clear();
                DisplayBoard(displayBoard);

                Console.WriteLine("Choose a cell to reveal (row column): ");
                string[] userInput = Console.ReadLine().Split(' ');

                int row = Convert.ToInt32(userInput[0]);
                int column = Convert.ToInt32(userInput[1]);

                if (minefield[row, column] == '*')
                {
                    gameOver = true;
                }
                else
                {
                    int adjacentMines = CountAdjacentMines(minefield, row, column);
                    displayBoard[row, column] = adjacentMines.ToString()[0];

                    if (adjacentMines == 0)
                    {
                        RevealEmptyCells(minefield, displayBoard, row, column);
                    }

                    if (CheckForWin(displayBoard, mines))
                    {
                        win = true;
                    }
                }
            }

            Console.Clear();
            DisplayBoard(displayBoard);

            if (win)
            {
                Console.WriteLine("Congratulations! You win!");
            }
            else
            {
                Console.WriteLine("Game over. You hit a mine!");
            }

            Console.ReadLine();
        }

        static char[,] GenerateMinefield(int rows, int columns, int mines)
        {
            char[,] minefield = new char[rows, columns];

            Random random = new Random();

            for (int i = 0; i < mines; i++)
            {
                int row = random.Next(rows);
                int column = random.Next(columns);

                if (minefield[row, column] == '*')
                {
                    i--;
                }
                else
                {
                    minefield[row, column] = '*';
                }
            }

            return minefield;
        }

        static char[,] GenerateDisplayBoard(int rows, int columns)
        {
            char[,] displayBoard = new char[rows, columns];

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    displayBoard[i, j] = '-';
                }
            }

            return displayBoard;
        }

        static void DisplayBoard(char[,] board)
        {
            int rows = board.GetLength(0);
            int columns = board.GetLength(1);

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    Console.Write(board[i, j] + " ");
                }
                Console.WriteLine();
            }
        }

        static int CountAdjacentMines(char[,] minefield, int row, int column)
        {
            int count = 0;
            int rows = minefield.GetLength(0);
            int columns = minefield.GetLength(1);

            for (int i = row - 1; i <= row + 1; i++)
            {
                for (int j = column - 1; j <= column + 1; j++)
                {
                    if (i >= 0 && i < rows && j >= 0 && j < columns && minefield[i, j] == '*')
                    {
                        count++;
                    }
                }
            }

            return count;
        }

        static void RevealEmptyCells(char[,] minefield, char[,] displayBoard, int row, int column)
        {
            int rows = minefield.GetLength(0);
            int columns = minefield.GetLength(1);

            for (int i = row - 1; i <= row + 1; i++)
            {
                for (int j = column - 1; j <= column + 1; j++)
                {
                    if (i >= 0 && i < rows && j >= 0 && j < columns && displayBoard[i, j] == '-')
                    {
                        int adjacentMines = CountAdjacentMines(minefield, i, j);
                        displayBoard[i, j] = adjacentMines.ToString()[0];

                        if (adjacentMines == 0)
                        {
                            RevealEmptyCells(minefield, displayBoard, i, j);
                        }
                    }
                }
            }
        }

        static bool CheckForWin(char[,] displayBoard, int mines)
        {
            int cellsRevealed = 0;
            int rows = displayBoard.GetLength(0);
            int columns = displayBoard.GetLength(1);

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    if (displayBoard[i, j] != '-')
                    {
                        cellsRevealed++;
                    }
                }
            }

            return cellsRevealed == (rows * columns - mines);
        }
    }
}