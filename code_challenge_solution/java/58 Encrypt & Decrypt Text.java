import java.util.Scanner;

public class TextEncryptionDecryption {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the text to encrypt:");
        String plainText = scanner.nextLine();
        
        String encryptedText = encryptText(plainText);
        System.out.println("Encrypted Text: " + encryptedText);
        
        String decryptedText = decryptText(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
        
        scanner.close();
    }
    
    public static String encryptText(String text) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encryptedText.append((char) (c + 1));
        }
        return encryptedText.toString();
    }
    
    public static String decryptText(String text) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            decryptedText.append((char) (c - 1));
        }
        return decryptedText.toString();
    }
}
