
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input string from user
        System.out.println("Enter a string: ");
        String original = sc.nextLine();
        
        // Reverse the string
        String reversed = reverseString(original);
        
        // Print the reversed string
        System.out.println("Reversed string: " + reversed);
        
        sc.close();
    }
    
    public static String reverseString(String original) {
        StringBuilder sb = new StringBuilder(original);
        sb.reverse();
        return sb.toString();
    }
}
