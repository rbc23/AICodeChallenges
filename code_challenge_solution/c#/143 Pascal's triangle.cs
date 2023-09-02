Sure! Here's the C# code to generate Pascal's triangle:

```csharp
using System;

class Program
{
    static void Main()
    {
        int rows;

        Console.Write("Enter the number of rows for Pascal's triangle: ");
        rows = Convert.ToInt32(Console.ReadLine());

        PrintPascalTriangle(rows);
    }

    static void PrintPascalTriangle(int rows)
    {
        for (int i = 0; i < rows; i++)
        {
            int number = 1;
            Console.Write(new string(' ', rows - i));

            for (int j = 0; j <= i; j++)
            {
                Console.Write(number);
                Console.Write(' ');
                number = number * (i - j) / (j + 1);
            }

            Console.WriteLine();
        }
    }
}
```

Hope this helps!