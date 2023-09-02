```java
public class ROT13Cipher {

    public static void main(String[] args) {
        String message = "Hello World";
        String encryptedMessage = encrypt(message);
        System.out.println("Encrypted Message: " + encryptedMessage);
        
        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

    public static String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isUpperCase(c)) {
                encryptedMessage.append((char) ((c - 'A' + 13) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                encryptedMessage.append((char) ((c - 'a' + 13) % 26 + 'a'));
            } else {
                encryptedMessage.append(c);
            }
        }
        return encryptedMessage.toString();
    }

    public static String decrypt(String encryptedMessage) {
        return encrypt(encryptedMessage); // ROT13 is self-inverse, so same function can be used for decryption
    }
}
```