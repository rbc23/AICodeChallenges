using System;

namespace FactorialCalculate
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Enter a number: ");
            int number = Convert.ToInt32(Console.ReadLine());

            int factorial = 1;

            for(int i = 1; i <= number; i++)
            {
                factorial *= i;
            }

            Console.WriteLine("Factorial of {0} is {1}", number, factorial);
        }
    }
}