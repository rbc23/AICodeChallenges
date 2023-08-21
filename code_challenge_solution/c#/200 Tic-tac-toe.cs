using System;

namespace TicTacToe
{
    class Program
    {
        static char[] board = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
        static int player = 1; // Player 1 will start the game
        static int choice; // Position chosen by the current player

        // Check if the current player has won the game
        static int CheckWin()
        {
            #region Horzontal Winning Condtion

            // Winning Condition For First Row
            if (board[0] == board[1] && board[1] == board[2] && board[0] != ' ')
                return 1;
            // Winning Condition For Second Row
            else if (board[3] == board[4] && board[4] == board[5] && board[3] != ' ')
                return 1;
            // Winning Condition For Third Row
            else if (board[6] == board[7] && board[7] == board[8] && board[6] != ' ')
                return 1;

            #endregion

            #region Vertical Winning Condtion

            // Winning Condition For First Column
            else if (board[0] == board[3] && board[3] == board[6] && board[0] != ' ')
                return 1;
            // Winning Condition For Second Column
            else if (board[1] == board[4] && board[4] == board[7] && board[1] != ' ')
                return 1;
            // Winning Condition For Third Column
            else if (board[2] == board[5] && board[5] == board[8] && board[2] != ' ')
                return 1;

            #endregion

            #region Diagonal Winning Condition

            // Winning Condition For First Diagonal
            else if (board[0] == board[4] && board[4] == board[8] && board[0] != ' ')
                return 1;
            // Winning Condition For Second Diagonal
            else if (board[2] == board[4] && board[4] == board[6] && board[2] != ' ')
                return 1;

            #endregion

            #region Checking For Draw

            // If all the positions on the board are filled
            else if (board[0] != ' ' && board[1] != ' ' && board[2] != ' ' &&
                     board[3] != ' ' && board[4] != ' ' && board[5] != ' ' &&
                     board[6] != ' ' && board[7] != ' ' && board[8] != ' ')
                return -1;

            #endregion

            else
                return 0;
        }

        // Print the current state of the board
        static void PrintBoard()
        {
            Console.WriteLine("     |     |      ");
            Console.WriteLine("  {0}  |  {1}  |  {2}", board[0], board[1], board[2]);
            Console.WriteLine("_____|_____|_____ ");
            Console.WriteLine("     |     |      ");
            Console.WriteLine("  {0}  |  {1}  |  {2}", board[3], board[4], board[5]);
            Console.WriteLine("_____|_____|_____ ");
            Console.WriteLine("     |     |      ");
            Console.WriteLine("  {0}  |  {1}  |  {2}", board[6], board[7], board[8]);
            Console.WriteLine("     |     |      ");
        }

        // Main method
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to Tic Tac Toe!");

            do
            {
                // Clear the console
                Console.Clear();

                Console.WriteLine("Player 1: X and Player 2: O");
                Console.WriteLine("\n");

                if (player % 2 == 0)
                {
                    Console.WriteLine("Player 2's turn");
                }
                else
                {
                    Console.WriteLine("Player 1's turn");
                }

                Console.WriteLine("\n");

                PrintBoard();

                // Check if the chosen position is already marked or not
                bool validInput = false;
                while (!validInput)
                {
                    validInput = true;
                    Console.WriteLine("Choose your position (1-9): ");
                    choice = Convert.ToInt32(Console.ReadLine());

                    if (board[choice - 1] != ' ')
                    {
                        Console.WriteLine("Sorry, the row {0} is already marked with {1}.", choice, board[choice - 1]);
                        validInput = false;
                    }
                }

                // Set the chosen position with 'X' or 'O' based on the current player
                if (player % 2 == 0)
                {
                    board[choice - 1] = 'O';
                    player++;
                }
                else
                {
                    board[choice - 1] = 'X';
                    player++;
                }

                // Check if the current player has won the game
                int winner = CheckWin();

                Console.Clear();

            } while (CheckWin() != 1 && CheckWin() != -1);

            PrintBoard();

            // Print the result of the game
            if (CheckWin() == 1)
            {
                Console.WriteLine("Player {0} has won!", (player % 2) + 1);
            }
            else
            {
                Console.WriteLine("It's a draw!");
            }

            Console.ReadLine();
        }
    }
}