Here is the C# code to calculate age in seconds:

```csharp
using System;

class Program
{
    static void Main()
    {
        Console.WriteLine("Enter your birth year:");
        int birthYear = int.Parse(Console.ReadLine());

        Console.WriteLine("Enter your birth month:");
        int birthMonth = int.Parse(Console.ReadLine());

        Console.WriteLine("Enter your birth day:");
        int birthDay = int.Parse(Console.ReadLine());

        DateTime birthDate = new DateTime(birthYear, birthMonth, birthDay);
        TimeSpan age = DateTime.Now - birthDate;
        double ageInSeconds = age.TotalSeconds;

        Console.WriteLine("Your age in seconds is: " + ageInSeconds);
    }
}
```