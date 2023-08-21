
import java.util.Scanner;

public class LoveCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first name: ");
        String firstName = scanner.nextLine().toLowerCase();
        
        System.out.print("Enter the second name: ");
        String secondName = scanner.nextLine().toLowerCase();
        
        int totalChars = firstName.length() + secondName.length();
        int commonChars = 0;
        
        for (int i = 0; i < firstName.length(); i++) {
            for (int j = 0; j < secondName.length(); j++) {
                if (firstName.charAt(i) == secondName.charAt(j)) {
                    commonChars++;
                    break;
                }
            }
        }
        
        int lovePercentage = (commonChars * 100) / totalChars;
        
        System.out.println("Love Percentage: " + lovePercentage + "%");
        
        scanner.close();
    }
}
