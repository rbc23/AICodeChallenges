using System;

class HaikuGenerator
{
    private static Random _random;

    static void Main()
    {
        _random = new Random();

        Console.WriteLine("Welcome to Haiku Generator!\n");

        while (true)
        {
            Console.WriteLine("Press enter to generate a haiku or type 'exit' to quit.");

            string input = Console.ReadLine();

            if (input.ToLower() == "exit")
                break;

            if (string.IsNullOrEmpty(input))
            {
                Console.WriteLine(GenerateHaiku());
                Console.WriteLine();
            }
            else
            {
                Console.WriteLine("Invalid input. Please try again.\n");
            }
        }

        Console.WriteLine("Thank you for using Haiku Generator. Goodbye!");
    }

    static string GenerateHaiku()
    {
        string[] haiku = new string[3];

        haiku[0] = GenerateLine(5);
        haiku[1] = GenerateLine(7);
        haiku[2] = GenerateLine(5);

        return string.Join("\n", haiku);
    }

    static string GenerateLine(int syllables)
    {
        string[] words = { "sun", "moon", "cloud", "rain", "wind", "tree", "bird", "flower", "mountain" };
        string line = "";

        int remainingSyllables = syllables;

        for (int i = 0; i < words.Length; i++)
        {
            if (CountSyllables(words[i]) <= remainingSyllables)
            {
                line += words[i] + " ";
                remainingSyllables -= CountSyllables(words[i]);
            }

            if (remainingSyllables == 0)
                break;
        }

        return line.Trim();
    }

    static int CountSyllables(string word)
    {
        int syllables = 0;
        bool isVowel = false;

        word = word.ToLower().Trim();

        foreach (char c in word)
        {
            if ("aeiou".Contains(c))
            {
                if (!isVowel)
                {
                    isVowel = true;
                    syllables++;
                }
            }
            else
            {
                isVowel = false;
            }
        }

        return syllables;
    }
}