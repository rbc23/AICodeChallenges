using System;
using System.Collections.Generic;

namespace CharacterFrequency
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter a string:");
            string input = Console.ReadLine();

            Dictionary<char, int> charFrequency = CountCharacterFrequency(input);

            foreach (var item in charFrequency)
            {
                Console.WriteLine($"Character '{item.Key}' occurs {item.Value} time(s).");
            }
        }

        static Dictionary<char, int> CountCharacterFrequency(string input)
        {
            Dictionary<char, int> charFrequency = new Dictionary<char, int>();

            foreach (char c in input)
            {
                if (charFrequency.ContainsKey(c))
                {
                    charFrequency[c]++;
                }
                else
                {
                    charFrequency[c] = 1;
                }
            }

            return charFrequency;
        }
    }
}