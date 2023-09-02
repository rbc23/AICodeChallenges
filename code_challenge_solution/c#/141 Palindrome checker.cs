```csharp
using System;

class Program
{
    static bool IsPalindrome(string word)
    {
        int left = 0;
        int right = word.Length - 1;

        while (left < right)
        {
            if (word[left] != word[right])
            {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    static void Main()
    {
        Console.WriteLine("Enter a word:");
        string word = Console.ReadLine();

        if (IsPalindrome(word))
        {
            Console.WriteLine("The word is a palindrome.");
        }
        else
        {
            Console.WriteLine("The word is not a palindrome.");
        }
    }
}
```