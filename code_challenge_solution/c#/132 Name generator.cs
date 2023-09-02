using System;

class NameGenerator
{
    static Random random = new Random();

    static string[] firstNames = { "John", "Mary", "Robert", "Jennifer", "Michael", "Linda", "William", "Patricia", "David", "Susan" };
    static string[] lastNames = { "Smith", "Johnson", "Brown", "Taylor", "Miller", "Davis", "Wilson", "Moore", "Anderson", "Thomas" };

    static void Main()
    {
        for (int i = 0; i < 10; i++)
        {
            string firstName = GetRandomFirstName();
            string lastName = GetRandomLastName();

            Console.WriteLine($"{firstName} {lastName}");
        }
    }

    static string GetRandomFirstName()
    {
        int index = random.Next(firstNames.Length);
        return firstNames[index];
    }

    static string GetRandomLastName()
    {
        int index = random.Next(lastNames.Length);
        return lastNames[index];
    }
}