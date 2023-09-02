Here is the C# code for a Love Calculator that calculates the love percentage between two names:

```csharp
using System;

class LoveCalculator
{
    static void Main()
    {
        Console.WriteLine("Love Calculator");
        Console.WriteLine("----------------");

        // Input names
        Console.Write("Enter the first name: ");
        string firstName = Console.ReadLine();

        Console.Write("Enter the second name: ");
        string secondName = Console.ReadLine();

        // Calculate love percentage
        int lovePercentage = CalculateLovePercentage(firstName, secondName);

        // Display result
        Console.WriteLine($"The love percentage between {firstName} and {secondName} is {lovePercentage}%");
    }

    static int CalculateLovePercentage(string firstName, string secondName)
    {
        // Combine names
        string combinedNames = (firstName + secondName).ToLower();

        // Count the number of "l", "o", "v", "e" letters
        int countL = CountLetter(combinedNames, 'l');
        int countO = CountLetter(combinedNames, 'o');
        int countV = CountLetter(combinedNames, 'v');
        int countE = CountLetter(combinedNames, 'e');

        // Calculate love percentage
        int lovePercentage = ((countL + countO + countV + countE) * 100) / combinedNames.Length;

        return lovePercentage;
    }

    static int CountLetter(string text, char letter)
    {
        int count = 0;
        foreach (char c in text)
        {
            if (c == letter)
                count++;
        }
        return count;
    }
}
```

This program takes two names as input, combines them, and then calculates the love percentage based on the number of occurrences of the letters 'l', 'o', 'v', and 'e' in the combined names. The result is displayed as the love percentage between the two names.