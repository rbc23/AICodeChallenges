```java
import java.util.Scanner;

public class TextConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text to convert: ");
        String text = scanner.nextLine();
        
        System.out.println("Text to Hexadecimal: ");
        String hex = convertToHexadecimal(text);
        System.out.println(hex);
        
        System.out.println("Text to Binary: ");
        String binary = convertToBinary(text);
        System.out.println(binary);
    }
    
    public static String convertToHexadecimal(String text) {
        StringBuilder hexBuilder = new StringBuilder();
        
        for (char character : text.toCharArray()) {
            hexBuilder.append(Integer.toHexString((int) character));
            hexBuilder.append(" ");
        }
        
        return hexBuilder.toString();
    }
    
    public static String convertToBinary(String text) {
        StringBuilder binaryBuilder = new StringBuilder();
        
        for (char character : text.toCharArray()) {
            binaryBuilder.append(String.format("%8s", Integer.toBinaryString((int) character)).replace(' ', '0'));
            binaryBuilder.append(" ");
        }
        
        return binaryBuilder.toString();
    }
}
```