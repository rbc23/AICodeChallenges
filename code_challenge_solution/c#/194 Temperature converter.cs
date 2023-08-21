using System;

namespace TemperatureConverter
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Temperature Converter");
            Console.WriteLine("---------------------");
            Console.WriteLine("1. Celsius to Fahrenheit");
            Console.WriteLine("2. Fahrenheit to Celsius");
            Console.WriteLine("3. Celsius to Kelvin");
            Console.WriteLine("4. Kelvin to Celsius");
            Console.WriteLine("5. Fahrenheit to Kelvin");
            Console.WriteLine("6. Kelvin to Fahrenheit");
            Console.WriteLine("---------------------");
            Console.Write("Enter your choice (1-6): ");
            int choice = Convert.ToInt32(Console.ReadLine());
            
            double temperature, convertedTemperature;
            
            switch (choice)
            {
                case 1:
                    Console.Write("Enter the temperature in Celsius: ");
                    temperature = Convert.ToDouble(Console.ReadLine());
                    convertedTemperature = temperature * 9 / 5 + 32;
                    Console.WriteLine("Temperature in Fahrenheit: " + convertedTemperature);
                    break;
                
                case 2:
                    Console.Write("Enter the temperature in Fahrenheit: ");
                    temperature = Convert.ToDouble(Console.ReadLine());
                    convertedTemperature = (temperature - 32) * 5 / 9;
                    Console.WriteLine("Temperature in Celsius: " + convertedTemperature);
                    break;
                
                case 3:
                    Console.Write("Enter the temperature in Celsius: ");
                    temperature = Convert.ToDouble(Console.ReadLine());
                    convertedTemperature = temperature + 273.15;
                    Console.WriteLine("Temperature in Kelvin: " + convertedTemperature);
                    break;
                
                case 4:
                    Console.Write("Enter the temperature in Kelvin: ");
                    temperature = Convert.ToDouble(Console.ReadLine());
                    convertedTemperature = temperature - 273.15;
                    Console.WriteLine("Temperature in Celsius: " + convertedTemperature);
                    break;
                
                case 5:
                    Console.Write("Enter the temperature in Fahrenheit: ");
                    temperature = Convert.ToDouble(Console.ReadLine());
                    convertedTemperature = (temperature - 32) * 5 / 9 + 273.15;
                    Console.WriteLine("Temperature in Kelvin: " + convertedTemperature);
                    break;
                
                case 6:
                    Console.Write("Enter the temperature in Kelvin: ");
                    temperature = Convert.ToDouble(Console.ReadLine());
                    convertedTemperature = (temperature - 273.15) * 9 / 5 + 32;
                    Console.WriteLine("Temperature in Fahrenheit: " + convertedTemperature);
                    break;
                
                default:
                    Console.WriteLine("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }
}
