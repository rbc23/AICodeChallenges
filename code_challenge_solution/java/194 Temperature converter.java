
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the temperature value: ");
        double temperature = scanner.nextDouble();
        
        System.out.println("Enter the current unit (C, F, K): ");
        String sourceUnit = scanner.next();
        
        System.out.println("Enter the desired unit (C, F, K): ");
        String targetUnit = scanner.next();
        
        double convertedTemperature = convertTemperature(temperature, sourceUnit, targetUnit);
        
        System.out.println("Converted temperature value: " + convertedTemperature);
    }
    
    public static double convertTemperature(double temperature, String sourceUnit, String targetUnit) {
        switch (sourceUnit.toUpperCase()) {
            case "C":
                switch (targetUnit.toUpperCase()) {
                    case "F":
                        return (temperature * 9 / 5) + 32;
                    case "K":
                        return temperature + 273.15;
                    default:
                        return temperature;
                }
            case "F":
                switch (targetUnit.toUpperCase()) {
                    case "C":
                        return (temperature - 32) * 5 / 9;
                    case "K":
                        return (temperature + 459.67) * 5 / 9;
                    default:
                        return temperature;
                }
            case "K":
                switch (targetUnit.toUpperCase()) {
                    case "C":
                        return temperature - 273.15;
                    case "F":
                        return (temperature * 9 / 5) - 459.67;
                    default:
                        return temperature;
                }
            default:
                return temperature;
        }
    }
}
