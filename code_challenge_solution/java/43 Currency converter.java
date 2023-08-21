
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Define exchange rates
        double usdToEur = 0.88;
        double usdToGbp = 0.77;
        double eurToUsd = 1.14;
        double eurToGbp = 0.89;
        double gbpToUsd = 1.30;
        double gbpToEur = 1.12;
        
        // Get input from user
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        
        System.out.println("1. USD to EUR");
        System.out.println("2. USD to GBP");
        System.out.println("3. EUR to USD");
        System.out.println("4. EUR to GBP");
        System.out.println("5. GBP to USD");
        System.out.println("6. GBP to EUR");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        
        // Convert currency based on user choice
        switch (choice) {
            case 1:
                double usdToEurAmount = amount * usdToEur;
                System.out.println(amount + " USD = " + usdToEurAmount + " EUR");
                break;
            case 2:
                double usdToGbpAmount = amount * usdToGbp;
                System.out.println(amount + " USD = " + usdToGbpAmount + " GBP");
                break;
            case 3:
                double eurToUsdAmount = amount * eurToUsd;
                System.out.println(amount + " EUR = " + eurToUsdAmount + " USD");
                break;
            case 4:
                double eurToGbpAmount = amount * eurToGbp;
                System.out.println(amount + " EUR = " + eurToGbpAmount + " GBP");
                break;
            case 5:
                double gbpToUsdAmount = amount * gbpToUsd;
                System.out.println(amount + " GBP = " + gbpToUsdAmount + " USD");
                break;
            case 6:
                double gbpToEurAmount = amount * gbpToEur;
                System.out.println(amount + " GBP = " + gbpToEurAmount + " EUR");
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        
        scanner.close();
    }
}
