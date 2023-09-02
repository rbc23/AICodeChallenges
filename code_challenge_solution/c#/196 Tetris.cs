using System;

namespace TetrisClone
{
    class Program
    {
        static int FieldWidth = 10;
        static int FieldHeight = 20;
        static char[,] Field = new char[FieldHeight, FieldWidth];

        static void Main(string[] args)
        {
            InitializeField();
            
            while (true)
            {
                PrintField();
                ConsoleKeyInfo keyInfo = Console.ReadKey();
                HandleInput(keyInfo.Key);
                UpdateField();
            }
        }

        static void InitializeField()
        {
            for (int i = 0; i < FieldHeight; i++)
            {
                for (int j = 0; j < FieldWidth; j++)
                {
                    Field[i, j] = ' ';
                }
            }
        }

        static void PrintField()
        {
            for (int i = 0; i < FieldHeight; i++)
            {
                for (int j = 0; j < FieldWidth; j++)
                {
                    Console.Write(Field[i, j]);
                }
                Console.WriteLine();
            }
        }

        static void HandleInput(ConsoleKey key)
        {
            // Handle movement and rotation of the Tetris piece based on key input
        }

        static void UpdateField()
        {
            // Update the field by moving the Tetris piece down and checking for completed rows
        }
    }
}