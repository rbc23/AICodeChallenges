import java.util.Scanner;

public class CredentialValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        if (isValidCredentials(username, password)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
    
    public static boolean isValidCredentials(String username, String password) {
        // Validate username and password based on your requirements
        // For example, you can use regular expressions or conditions
        
        // Here is a simple example to check if username and password must be at least 4 characters long
        if (username.length() >= 4 && password.length() >= 4) {
            return true;
        } else {
            return false;
        }
    }
}