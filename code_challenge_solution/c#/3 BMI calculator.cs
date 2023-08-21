using System;

namespace BMICalculator
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to the BMI Calculator!");
            Console.WriteLine("Please enter your weight in kilograms: ");
            double weight = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("Please enter your height in meters: ");
            double height = Convert.ToDouble(Console.ReadLine());

            double bmi = CalculateBMI(weight, height);
            Console.WriteLine("Your BMI is: " + bmi);
            Console.WriteLine(GetBMIStatus(bmi));

            Console.ReadLine();
        }

        static double CalculateBMI(double weight, double height)
        {
            return weight / (height * height);
        }

        static string GetBMIStatus(double bmi)
        {
            if (bmi < 18.5)
            {
                return "Underweight";
            }
            else if (bmi >= 18.5 && bmi <= 24.9)
            {
                return "Normal weight";
            }
            else if (bmi >= 25 && bmi <= 29.9)
            {
                return "Overweight";
            }
            else
            {
                return "Obese";
            }
        }
    }
}