using System;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Temperature Converter");
        Console.WriteLine("----------------------");

        Console.WriteLine("1. Celsius to Fahrenheit");
        Console.WriteLine("2. Fahrenheit to Celsius");
        Console.WriteLine("3. Celsius to Kelvin");
        Console.WriteLine("4. Kelvin to Celsius");
        Console.WriteLine("5. Fahrenheit to Kelvin");
        Console.WriteLine("6. Kelvin to Fahrenheit");

        Console.Write("Enter your choice: ");
        int choice = Convert.ToInt32(Console.ReadLine());

        double temperature, convertedTemperature;

        switch (choice)
        {
            case 1:
                Console.Write("Enter temperature in Celsius: ");
                temperature = Convert.ToDouble(Console.ReadLine());
                convertedTemperature = CelsiusToFahrenheit(temperature);
                Console.WriteLine("Temperature in Fahrenheit: " + convertedTemperature);
                break;
            case 2:
                Console.Write("Enter temperature in Fahrenheit: ");
                temperature = Convert.ToDouble(Console.ReadLine());
                convertedTemperature = FahrenheitToCelsius(temperature);
                Console.WriteLine("Temperature in Celsius: " + convertedTemperature);
                break;
            case 3:
                Console.Write("Enter temperature in Celsius: ");
                temperature = Convert.ToDouble(Console.ReadLine());
                convertedTemperature = CelsiusToKelvin(temperature);
                Console.WriteLine("Temperature in Kelvin: " + convertedTemperature);
                break;
            case 4:
                Console.Write("Enter temperature in Kelvin: ");
                temperature = Convert.ToDouble(Console.ReadLine());
                convertedTemperature = KelvinToCelsius(temperature);
                Console.WriteLine("Temperature in Celsius: " + convertedTemperature);
                break;
            case 5:
                Console.Write("Enter temperature in Fahrenheit: ");
                temperature = Convert.ToDouble(Console.ReadLine());
                convertedTemperature = FahrenheitToKelvin(temperature);
                Console.WriteLine("Temperature in Kelvin: " + convertedTemperature);
                break;
            case 6:
                Console.Write("Enter temperature in Kelvin: ");
                temperature = Convert.ToDouble(Console.ReadLine());
                convertedTemperature = KelvinToFahrenheit(temperature);
                Console.WriteLine("Temperature in Fahrenheit: " + convertedTemperature);
                break;
            default:
                Console.WriteLine("Invalid choice");
                break;
        }
    }

    static double CelsiusToFahrenheit(double celsius)
    {
        return (celsius * 9 / 5) + 32;
    }

    static double FahrenheitToCelsius(double fahrenheit)
    {
        return (fahrenheit - 32) * 5 / 9;
    }

    static double CelsiusToKelvin(double celsius)
    {
        return celsius + 273.15;
    }

    static double KelvinToCelsius(double kelvin)
    {
        return kelvin - 273.15;
    }

    static double FahrenheitToKelvin(double fahrenheit)
    {
        double celsius = FahrenheitToCelsius(fahrenheit);
        return CelsiusToKelvin(celsius);
    }

    static double KelvinToFahrenheit(double kelvin)
    {
        double celsius = KelvinToCelsius(kelvin);
        return CelsiusToFahrenheit(celsius);
    }
}