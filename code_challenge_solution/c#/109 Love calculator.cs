
using System;

class LoveCalculator
{
    static void Main()
    {
        Console.WriteLine("Love Calculator");
        Console.WriteLine("----------------");

        Console.Write("Enter first name: ");
        string firstName = Console.ReadLine().ToLower();

        Console.Write("Enter second name: ");
        string secondName = Console.ReadLine().ToLower();

        int lovePercentage = CalculateLovePercentage(firstName, secondName);

        Console.WriteLine($"Love Percentage between {firstName} and {secondName}: {lovePercentage}%");
    }

    static int CalculateLovePercentage(string firstName, string secondName)
    {
        string combinedName = firstName + secondName;

        int count = 0;
        foreach (char c in combinedName)
        {
            if (c >= 'a' && c <= 'z')
                count += (int)c;
        }

        return count % 101;
    }
}