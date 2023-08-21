using System;

class Program
{
    static void Main()
    {
        int rows = 10;

        for (int i = 0; i < rows; i++)
        {
            int num = 1;
            for (int j = 0; j <= i; j++)
            {
                Console.Write(num + " ");
                num = num * (i - j) / (j + 1);
            }
            Console.WriteLine();
        }
    }
}