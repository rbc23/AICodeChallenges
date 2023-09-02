```csharp
using System;

class BMICalculator
{
    static void Main(string[] args)
    {
        Console.WriteLine("BMI Calculator");
        Console.WriteLine();

        // Get input from user
        Console.Write("Enter your weight in kg: ");
        double weight = Convert.ToDouble(Console.ReadLine());

        Console.Write("Enter your height in meters: ");
        double height = Convert.ToDouble(Console.ReadLine());

        // Calculate BMI
        double bmi = weight / (height * height);

        // Display the result
        Console.WriteLine();
        Console.WriteLine("Your BMI is: " + bmi.ToString("0.00"));

        // Interpret BMI category
        string category = "";
        if (bmi < 18.5)
            category = "Underweight";
        else if (bmi >= 18.5 && bmi < 25)
            category = "Normal weight";
        else if (bmi >= 25 && bmi < 30)
            category = "Overweight";
        else
            category = "Obese";

        Console.WriteLine("BMI Category: " + category);
    }
}
```