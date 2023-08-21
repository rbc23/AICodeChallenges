using System;
using System.Diagnostics;

namespace TypingSpeedCalculator
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to the Typing Speed Calculator!");

            Console.Write("Enter the text to type: ");
            string textToType = Console.ReadLine();

            Console.WriteLine("\nType the following text:\n" + textToType);

            Console.WriteLine("\nPress any key to start typing...");
            Console.ReadKey();

            Console.WriteLine("\nStart typing now:");

            Stopwatch stopwatch = Stopwatch.StartNew();
            string typedText = Console.ReadLine();
            stopwatch.Stop();

            int typedCharacters = typedText.Length;
            int elapsedTime = (int)stopwatch.ElapsedMilliseconds / 1000;

            double typingSpeed = (double)typedCharacters / elapsedTime;

            Console.WriteLine("\nYou typed " + typedCharacters + " characters in " + elapsedTime + " seconds.");
            Console.WriteLine("Your typing speed is approximately " + typingSpeed.ToString("F2") + " characters per second.");
        }
    }
}