import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String UPPER_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+{}[]|:;<>,.?";

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int type = random.nextInt(4);
            switch (type) {
                case 0:
                    password.append(UPPER_CHARS.charAt(random.nextInt(UPPER_CHARS.length())));
                    break;
                case 1:
                    password.append(LOWER_CHARS.charAt(random.nextInt(LOWER_CHARS.length())));
                    break;
                case 2:
                    password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
                    break;
                case 3:
                    password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
                    break;
            }
        }

        return password.toString();
    }

    public static void main(String[] args) {
        int length = 10;
        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }
}