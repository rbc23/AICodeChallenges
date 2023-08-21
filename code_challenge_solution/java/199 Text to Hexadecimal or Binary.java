
import java.util.Scanner;

public class TextConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text to convert: ");
        String text = scanner.nextLine();

        System.out.println("Choose conversion type:");
        System.out.println("1. Text to Hexadecimal");
        System.out.println("2. Text to Binary");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.close();

        if (choice == 1) {
            String hexResult = textToHexadecimal(text);
            System.out.println("Hexadecimal: " + hexResult);
        } else if (choice == 2) {
            String binaryResult = textToBinary(text);
            System.out.println("Binary: " + binaryResult);
        } else {
            System.out.println("Invalid choice. Please enter either 1 or 2.");
        }
    }

    public static String textToHexadecimal(String text) {
        StringBuilder hexBuilder = new StringBuilder();
        
        for (char character : text.toCharArray()) {
            String hex = Integer.toHexString(character);
            hexBuilder.append(hex);
        }

        return hexBuilder.toString();
    }

    public static String textToBinary(String text) {
        StringBuilder binaryBuilder = new StringBuilder();

        for (char character : text.toCharArray()) {
            String binary = Integer.toBinaryString(character);
            binaryBuilder.append(binary);
        }

        return binaryBuilder.toString();
    }
}
