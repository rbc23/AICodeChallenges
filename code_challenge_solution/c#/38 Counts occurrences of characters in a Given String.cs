using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        string str = "Hello World";
        
        Dictionary<char, int> charFreq = GetCharacterFrequency(str);

        Console.WriteLine("Character Frequency:");
        foreach (var item in charFreq)
        {
            Console.WriteLine($"{item.Key}: {item.Value}");
        }
    }

    static Dictionary<char, int> GetCharacterFrequency(string str)
    {
        Dictionary<char, int> charFreq = new Dictionary<char, int>();

        foreach (char c in str)
        {
            if (charFreq.ContainsKey(c))
            {
                charFreq[c]++;
            }
            else
            {
                charFreq[c] = 1;
            }
        }

        return charFreq;
    }
}