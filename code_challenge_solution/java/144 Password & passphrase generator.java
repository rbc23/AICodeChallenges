import java.util.Random;

public class PasswordGenerator {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%&*";

    private static final int PASSWORD_LENGTH = 10;

    private static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("Secure Password Generator");
        System.out.println("-------------------------");
        System.out.println();

        System.out.println("Generated Password: " + generatePassword());
        System.out.println("Generated Passphrase: " + generatePassphrase());
    }

    private static String generatePassword() {
        String characters = CHAR_LOWER + CHAR_UPPER + NUMBER + SPECIAL_CHARS;
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }
        return password.toString();
    }

    private static String generatePassphrase() {
        String[] words = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon"};
        StringBuilder passphrase = new StringBuilder(PASSWORD_LENGTH);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int randomIndex = random.nextInt(words.length);
            passphrase.append(words[randomIndex]).append(" ");
        }
        return passphrase.toString().trim();
    }
}