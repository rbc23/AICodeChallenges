```
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose the conversion type:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. Fahrenheit to Kelvin");
        System.out.println("6. Kelvin to Fahrenheit");
        System.out.print("Enter your choice (1-6): ");
        
        int choice = scanner.nextInt();
        
        double temperature;
        
        switch (choice) {
            case 1:
                System.out.print("Enter temperature in Celsius: ");
                temperature = scanner.nextDouble();
                double celsiusToFahrenheit = (temperature * 9/5) + 32;
                System.out.println("Temperature in Fahrenheit: " + celsiusToFahrenheit);
                break;
            case 2:
                System.out.print("Enter temperature in Fahrenheit: ");
                temperature = scanner.nextDouble();
                double fahrenheitToCelsius = (temperature - 32) * 5/9;
                System.out.println("Temperature in Celsius: " + fahrenheitToCelsius);
                break;
            case 3:
                System.out.print("Enter temperature in Celsius: ");
                temperature = scanner.nextDouble();
                double celsiusToKelvin = temperature + 273.15;
                System.out.println("Temperature in Kelvin: " + celsiusToKelvin);
                break;
            case 4:
                System.out.print("Enter temperature in Kelvin: ");
                temperature = scanner.nextDouble();
                double kelvinToCelsius = temperature - 273.15;
                System.out.println("Temperature in Celsius: " + kelvinToCelsius);
                break;
            case 5:
                System.out.print("Enter temperature in Fahrenheit: ");
                temperature = scanner.nextDouble();
                double fahrenheitToKelvin = (temperature + 459.67) * 5/9;
                System.out.println("Temperature in Kelvin: " + fahrenheitToKelvin);
                break;
            case 6:
                System.out.print("Enter temperature in Kelvin: ");
                temperature = scanner.nextDouble();
                double kelvinToFahrenheit = (temperature * 9/5) - 459.67;
                System.out.println("Temperature in Fahrenheit: " + kelvinToFahrenheit);
                break;
            default:
                System.out.println("Invalid choice!");
        }
        
        scanner.close();
    }
}
```