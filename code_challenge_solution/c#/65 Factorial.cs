using System;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Enter a number: ");
        int num = Convert.ToInt32(Console.ReadLine());

        long factorial = CalculateFactorial(num);

        Console.WriteLine($"Factorial of {num} is: {factorial}");
    }

    static long CalculateFactorial(int num)
    {
        if (num == 0)
            return 1;

        long factorial = 1;

        for (int i = 1; i <= num; i++)
        {
            factorial *= i;
        }

        return factorial;
    }
}