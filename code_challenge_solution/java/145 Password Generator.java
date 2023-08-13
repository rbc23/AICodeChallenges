Sure, here is a Java program to generate a secure random password:

```java
import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();

        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            char randomCharacter = ALLOWED_CHARACTERS.charAt(randomIndex);
            password.append(randomCharacter);
        }

        return password.toString();
    }
}
```

This program prompts the user to enter the length of the password they want to generate. It then uses a secure random number generator to generate a random index within the range of the allowed characters. The corresponding character from the allowed characters string is appended to the password. This process is repeated for the specified length to generate a secure random password.