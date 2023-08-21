using System;

class FibonacciGenerator
{
    static void Main()
    {
        int n = 10; // the number of Fibonacci numbers to generate

        int[] fibonacci = new int[n];
        fibonacci[0] = 0; 
        fibonacci[1] = 1;

        for (int i = 2; i < n; i++)
        {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        Console.WriteLine($"The first {n} Fibonacci numbers are:");
        for (int i = 0; i < n; i++)
        {
            Console.Write(fibonacci[i] + " ");
        }
    }
}