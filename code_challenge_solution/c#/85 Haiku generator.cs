Sure! Here is a C# program to generate Haiku poems:

```csharp
using System;

class HaikuGenerator
{
    static Random random = new Random();

    static void Main(string[] args)
    {
        Console.WriteLine("Welcome to Haiku Generator!");

        Console.WriteLine("Enter the number of Haikus to generate:");
        int numberOfHaikus = Convert.ToInt32(Console.ReadLine());

        Console.WriteLine("\nGenerating Haikus...\n");

        for (int i = 0; i < numberOfHaikus; i++)
        {
            Console.WriteLine(GenerateHaiku());
            Console.WriteLine();
        }
    }

    static string GenerateHaiku()
    {
        string[] firstLine = { "Autumn leaves falling", "Cherry blossoms bloom", "A silent moonrise" };
        string[] secondLine = { "Whispering wind so soft", "Ancient temple bells", "Rushing river flows" };
        string[] thirdLine = { "Peaceful nature's embrace", "Harmony in life", "Stillness of the night" };

        return $"{GetRandomLine(firstLine)}\n{GetRandomLine(secondLine)}\n{GetRandomLine(thirdLine)}";
    }

    static string GetRandomLine(string[] lines)
    {
        int index = random.Next(lines.Length);
        return lines[index];
    }
}
```

This program will prompt the user to enter the number of Haikus to generate and then generate the specified number of Haikus using random lines from predefined arrays. The Haikus will be displayed on the console.