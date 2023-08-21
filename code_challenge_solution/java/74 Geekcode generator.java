
import java.util.Scanner;

public class GeekcodeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your favorite programming language: ");
        String language = scanner.nextLine();
        
        System.out.print("Enter your favorite operating system: ");
        String os = scanner.nextLine();
        
        System.out.print("Enter your level of geekiness (1-10): ");
        int geekiness = scanner.nextInt();
        
        String geekcode = generateGeekcode(name, language, os, geekiness);
        System.out.println("Your Geekcode signature: " + geekcode);
    }
    
    public static String generateGeekcode(String name, String language, String os, int geekiness) {
        StringBuilder codeBuilder = new StringBuilder();
        
        // Name
        codeBuilder.append("Name: ").append(name).append("\n");
        
        // Favorite programming language
        codeBuilder.append("Favorite programming language: ").append(language).append("\n");
        
        // Favorite operating system
        codeBuilder.append("Favorite operating system: ").append(os).append("\n");
        
        // Geekiness level
        codeBuilder.append("Geekiness level: ").append(geekiness).append("\n");
        
        return codeBuilder.toString();
    }
}
