using System;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Enter your age: ");
        int age = Convert.ToInt32(Console.ReadLine());

        long seconds = age * 365 * 24 * 60 * 60;

        Console.WriteLine("Your age in seconds is: " + seconds);
    }
}