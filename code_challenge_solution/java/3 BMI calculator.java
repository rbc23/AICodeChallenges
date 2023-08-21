import java.util.Scanner;

public class BMICalculator {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("BMI Calculator");
        System.out.println("---------------");
        
        System.out.print("Enter your weight in kilograms: ");
        double weight = scanner.nextDouble();
        
        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();
        
        double bmi = calculateBMI(weight, height);
        
        System.out.println("\nYour BMI is: " + bmi);
        
        System.out.println("\nBMI Categories:");
        System.out.println("Underweight: less than 18.5");
        System.out.println("Normal weight: 18.5 - 24.9");
        System.out.println("Overweight: 25 - 29.9");
        System.out.println("Obesity: 30 or greater");
        
        scanner.close();
    }
    
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
}

