
import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(LOWERCASE_CHARS.length());
            password.append(LOWERCASE_CHARS.charAt(randomIndex));
        }

        return password.toString();
    }

    public static String generatePassphrase(int length) {
        StringBuilder passphrase = new StringBuilder(length);
        SecureRandom random = new SecureRandom();

        int charsetSize = LOWERCASE_CHARS.length() + UPPERCASE_CHARS.length() + NUMERIC_CHARS.length() + SPECIAL_CHARS.length();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charsetSize);

            if (randomIndex < LOWERCASE_CHARS.length()) {
                passphrase.append(LOWERCASE_CHARS.charAt(randomIndex));
            } else if (randomIndex < LOWERCASE_CHARS.length() + UPPERCASE_CHARS.length()) {
                passphrase.append(UPPERCASE_CHARS.charAt(randomIndex - LOWERCASE_CHARS.length()));
            } else if (randomIndex < LOWERCASE_CHARS.length() + UPPERCASE_CHARS.length() + NUMERIC_CHARS.length()) {
                passphrase.append(NUMERIC_CHARS.charAt(randomIndex - LOWERCASE_CHARS.length() - UPPERCASE_CHARS.length()));
            } else {
                passphrase.append(SPECIAL_CHARS.charAt(randomIndex - LOWERCASE_CHARS.length() - UPPERCASE_CHARS.length() - NUMERIC_CHARS.length()));
            }
        }

        return passphrase.toString();
    }

    public static void main(String[] args) {
        int passwordLength = 8;
        int passphraseLength = 12;

        String password = generatePassword(passwordLength);
        String passphrase = generatePassphrase(passphraseLength);

        System.out.println("Generated Password: " + password);
        System.out.println("Generated Passphrase: " + passphrase);
    }
}

