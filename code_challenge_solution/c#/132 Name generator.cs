using System;

class Program
{
    static void Main(string[] args)
    {
        string[] firstNames = {"John", "Emily", "Michael", "Sophia", "Jacob", "Emma", "William", "Olivia", "Joshua", "Ava"};
        string[] lastNames = {"Smith", "Johnson", "Brown", "Taylor", "Miller", "Wilson", "Davis", "Clark", "Hall", "Garcia"};

        Random random = new Random();

        string firstName = firstNames[random.Next(firstNames.Length)];
        string lastName = lastNames[random.Next(lastNames.Length)];

        Console.WriteLine("Generated name: " + firstName + " " + lastName);
    }
}