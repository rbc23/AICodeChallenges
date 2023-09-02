```java
import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String SPECIAL_CHAR = "!@#$%^&*()_+-=[]{}|;':,.<>?";

    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER + SPECIAL_CHAR;
    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        int passwordLength = 10;

        for (int i = 0; i < 5; i++) {
            String password = generateRandomPassword(passwordLength);
            System.out.println("Random Password " + (i + 1) + ": " + password);
        }
    }

    public static String generateRandomPassword(int length) {
        StringBuilder generatedPassword = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            generatedPassword.append(DATA_FOR_RANDOM_STRING.charAt(randomIndex));
        }

        return generatedPassword.toString();
    }
}
```