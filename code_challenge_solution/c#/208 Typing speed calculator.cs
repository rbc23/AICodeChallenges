using System;
using System.Diagnostics;

namespace TypingSpeedCalculator
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to Typing Speed Calculator!");

            Console.WriteLine("Enter the sentence to calculate typing speed: ");
            string sentence = Console.ReadLine();

            Console.WriteLine("Type the sentence: ");
            string typedSentence = Console.ReadLine();

            Stopwatch stopwatch = new Stopwatch();
            stopwatch.Start();

            while (typedSentence != sentence)
            {
                Console.WriteLine("Incorrect! Try again: ");
                typedSentence = Console.ReadLine();
            }

            stopwatch.Stop();
            TimeSpan elapsedTime = stopwatch.Elapsed;

            Console.WriteLine($"Congratulations! You typed the sentence correctly.");
            Console.WriteLine($"Elapsed time: {elapsedTime.TotalSeconds} seconds");
            Console.WriteLine($"Typing speed: {CalculateTypingSpeed(typedSentence.Length, elapsedTime.TotalSeconds)} characters per minute");
        }

        static double CalculateTypingSpeed(int charactersTyped, double elapsedTime)
        {
            double minutes = elapsedTime / 60;
            double typingSpeed = charactersTyped / minutes;

            return typingSpeed;
        }
    }
}