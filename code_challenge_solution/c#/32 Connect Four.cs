using System;

namespace ConnectFour
{
    class Program
    {
        static char[,] board = new char[6, 7];
        static char currentPlayer = 'X';

        static void Main(string[] args)
        {
            InitializeBoard();

            bool gameIsOver = false;
            while (!gameIsOver)
            {
                DisplayBoard();
                Console.WriteLine("Player " + currentPlayer + ", enter your column number (1-7): ");
                int column = Convert.ToInt32(Console.ReadLine());

                if (IsValidMove(column))
                {
                    MakeMove(column);
                    if (IsWinningMove())
                    {
                        gameIsOver = true;
                        Console.WriteLine("Player " + currentPlayer + " wins!");
                    }
                    else if (IsBoardFull())
                    {
                        gameIsOver = true;
                        Console.WriteLine("The game is a draw.");
                    }
                    else
                    {
                        SwitchPlayer();
                    }
                }
                else
                {
                    Console.WriteLine("Invalid move. Please try again.");
                }
            }

            Console.WriteLine("Game Over.");
            Console.ReadLine();
        }

        static void InitializeBoard()
        {
            for (int row = 0; row < 6; row++)
            {
                for (int col = 0; col < 7; col++)
                {
                    board[row, col] = '-';
                }
            }
        }

        static void DisplayBoard()
        {
            Console.Clear();
            Console.WriteLine("-----------------------------");
            for (int row = 0; row < 6; row++)
            {
                for (int col = 0; col < 7; col++)
                {
                    Console.Write(board[row, col] + " ");
                }
                Console.WriteLine();
            }
            Console.WriteLine("-----------------------------");
        }

        static bool IsValidMove(int column)
        {
            return board[0, column - 1] == '-';
        }

        static void MakeMove(int column)
        {
            for (int row = 5; row >= 0; row--)
            {
                if (board[row, column - 1] == '-')
                {
                    board[row, column - 1] = currentPlayer;
                    break;
                }
            }
        }

        static bool IsWinningMove()
        {
            return CheckRows() || CheckColumns() || CheckDiagonals();
        }

        static bool CheckRows()
        {
            for (int row = 0; row < 6; row++)
            {
                for (int col = 0; col < 4; col++)
                {
                    if (board[row, col] != '-' && board[row, col] == board[row, col + 1] && 
                        board[row, col] == board[row, col + 2] && board[row, col] == board[row, col + 3])
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        static bool CheckColumns()
        {
            for (int row = 0; row < 3; row++)
            {
                for (int col = 0; col < 7; col++)
                {
                    if (board[row, col] != '-' && board[row, col] == board[row + 1, col] && 
                        board[row, col] == board[row + 2, col] && board[row, col] == board[row + 3, col])
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        static bool CheckDiagonals()
        {
            for (int row = 0; row < 3; row++)
            {
                for (int col = 0; col < 4; col++)
                {
                    if (board[row, col] != '-' && board[row, col] == board[row + 1, col + 1] && 
                        board[row, col] == board[row + 2, col + 2] && board[row, col] == board[row + 3, col + 3])
                    {
                        return true;
                    }
                }
            }

            for (int row = 0; row < 3; row++)
            {
                for (int col = 3; col < 7; col++)
                {
                    if (board[row, col] != '-' && board[row, col] == board[row + 1, col - 1] && 
                        board[row, col] == board[row + 2, col - 2] && board[row, col] == board[row + 3, col - 3])
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        static bool IsBoardFull()
        {
            for (int row = 0; row < 6; row++)
            {
                for (int col = 0; col < 7; col++)
                {
                    if (board[row, col] == '-')
                    {
                        return false;
                    }
                }
            }
            return true;
        }

        static void SwitchPlayer()
        {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }
}