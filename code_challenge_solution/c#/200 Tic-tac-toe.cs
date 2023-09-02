```csharp
using System;

namespace TicTacToe
{
    class Program
    {
        static char[] board = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        static int player = 1; // By default Player 1 starts
        static int choice; // User choice for position

        static int flag = 0; // Flag for invalid input check

        // Check if the position entered by user is already filled or not
        // using the ASCII value of characters
        static void CheckPosition(char charToCheck, int position)
        {
            if (board[position] != 'X' && board[position] != 'O')
            {
                board[position] = charToCheck;
                player++;
                flag = 0;
            }
            else
            {
                Console.WriteLine("Sorry the row {0} is already marked with an {1}. Please choose another position!", position, board[position]);
                Console.WriteLine("\n");
                flag = 1;
            }
        }

        // Chech if any player has won the match or not
        static int CheckWin()
        {
            #region Horzontal Winning Condtion
            // Winning Condition For First Row
            if (board[0] == board[1] && board[1] == board[2])
            {
                return 1;
            }
            // Winning Condition For Second Row
            else if (board[3] == board[4] && board[4] == board[5])
            {
                return 1;
            }
            // Winning Condition For Third Row
            else if (board[6] == board[7] && board[7] == board[8])
            {
                return 1;
            }
            #endregion

            #region Vertical Winning Condtion
            // Winning Condition For First Column
            else if (board[0] == board[3] && board[3] == board[6])
            {
                return 1;
            }
            // Winning Condition For Second Column
            else if (board[1] == board[4] && board[4] == board[7])
            {
                return 1;
            }
            // Winning Condition For Third Column
            else if (board[2] == board[5] && board[5] == board[8])
            {
                return 1;
            }
            #endregion

            #region Diagonal Winning Condition
            else if (board[0] == board[4] && board[4] == board[8])
            {
                return 1;
            }
            else if (board[2] == board[4] && board[4] == board[6])
            {
                return 1;
            }
            #endregion

            #region Checking For Draw
            // Check if all field values have been set
            else if (board[0] != '1' && board[1] != '2' && board[2] != '3' &&
                     board[3] != '4' && board[4] != '5' && board[5] != '6' &&
                     board[6] != '7' && board[7] != '8' && board[8] != '9')
            {
                return -1;
            }
            #endregion

            else
            {
                return 0;
            }
        }

        // Print the current board status
        static void PrintBoard()
        {
            Console.WriteLine("|{0}|{1}|{2}|", board[0], board[1], board[2]);
            Console.WriteLine("|{0}|{1}|{2}|", board[3], board[4], board[5]);
            Console.WriteLine("|{0}|{1}|{2}|", board[6], board[7], board[8]);
        }

        static void Main(string[] args)
        {
            Console.WriteLine("Tic-Tac-Toe Game");
            do
            {
                Console.Clear(); // Whenever loop will be again start then screen will be clear
                Console.WriteLine("Player 1: X and Player 2: O");
                Console.WriteLine("\n");
                if (player % 2 == 0)
                {
                    Console.WriteLine("Turn Player 2");
                }
                else
                {
                    Console.WriteLine("Turn Player 1");
                }
                Console.WriteLine("\n");
                PrintBoard(); // calling the board Function
                Console.WriteLine("\n");
                // Check if any player has won the match or not
                int condition = CheckWin();

                if (condition == 1)
                {
                    Console.WriteLine("\n");
                    Console.WriteLine("Player {0} has won the game!", (player % 2) + 1);
                    break;
                }
                else if (condition == -1)
                {
                    Console.WriteLine("\n");
                    Console.WriteLine("The game is a draw!");
                    break;
                }

                // Checking valid position entered or not
                do
                {
                    flag = 0;
                    // Read the position and check if it is valid or not
                    if (player % 2 == 0)
                    {
                        Console.Write("Player 2, enter your position (1-9): ");
                    }
                    else
                    {
                        Console.Write("Player 1, enter your position (1-9): ");
                    }
                    choice = Convert.ToInt32(Console.ReadLine()) - 1;

                    if (choice >= 0 && choice < 9)
                    {
                        // Checking availability of the slot
                        CheckPosition((player % 2 == 0) ? 'O' : 'X', choice);
                    }
                    else
                    {
                        Console.WriteLine("Please enter a valid position (1-9)!");
                        Console.WriteLine("\n");
                        flag = 1;
                    }
                } while (flag != 0); // flag value will be changed if the position value entered is valid
            } while (flag != 1); // Loop will run until all possible positions are marked

            Console.WriteLine("\n");
            Console.WriteLine("Press any key to exit.");
            Console.ReadKey();
        }
    }
}
```