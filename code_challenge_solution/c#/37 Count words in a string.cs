using System;

namespace WordCount
{
    class Program
    {
        static void Main(string[] args)
        {
            string str = "Count words in a string";
            int wordCount = CountWords(str);
            Console.WriteLine("The number of words in the string is: " + wordCount);
        }

        static int CountWords(string str)
        {
            int count = 0;
            
            if (!string.IsNullOrWhiteSpace(str))
            {
                count = str.Trim().Split(" ").Length;
            }

            return count;
        }
    }
}