```java
import java.util.Scanner;

public class LoveCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first name: ");
        String firstName = scanner.nextLine().toLowerCase();
        
        System.out.print("Enter the second name: ");
        String secondName = scanner.nextLine().toLowerCase();
        
        int lovePercentage = calculateLovePercentage(firstName, secondName);
        
        System.out.println("Love Percentage: " + lovePercentage + "%");
    }
    
    private static int calculateLovePercentage(String firstName, String secondName) {
        String combinedName = firstName + secondName;
        int count = 0;
        
        for (char c : combinedName.toCharArray()) {
            if (c == 'l' || c == 'o' || c == 'v' || c == 'e') {
                count++;
            }
        }
        
        int lovePercentage = count * 10;
        
        if (lovePercentage > 100) {
            lovePercentage = 100;
        }
        
        return lovePercentage;
    }
}
```