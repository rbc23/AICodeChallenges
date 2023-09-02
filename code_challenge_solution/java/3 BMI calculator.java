public class BMICalculator {
    public static void main(String[] args) {
        // Prompt user for weight in kilograms
        double weight;
        System.out.print("Enter your weight in kilograms: ");
        Scanner scanner = new Scanner(System.in);
        weight = scanner.nextDouble();
        
        // Prompt user for height in meters
        double height;
        System.out.print("Enter your height in meters: ");
        height = scanner.nextDouble();
        
        // Calculate BMI
        double bmi = weight / (height * height);
        
        // Print result
        System.out.println("Your BMI is: " + bmi);
        
        // Interpret BMI
        if (bmi < 18.5) {
            System.out.println("You are underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("You have a normal weight");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("You are overweight");
        } else {
            System.out.println("You are obese");
        }
        
        scanner.close();
    }
}