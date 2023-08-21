using System;

class Program
{
    static bool IsPalindrome(string input)
    {
        char[] charArray = input.ToCharArray();
        Array.Reverse(charArray);
        string reversedInput = new string(charArray);

        return input.Equals(reversedInput, StringComparison.OrdinalIgnoreCase);
    }

    static void Main(string[] args)
    {
        Console.Write("Enter a string: ");
        string inputString = Console.ReadLine();

        if (IsPalindrome(inputString))
        {
            Console.WriteLine("The input string is a palindrome.");
        }
        else
        {
            Console.WriteLine("The input string is not a palindrome.");
        }
    }
}