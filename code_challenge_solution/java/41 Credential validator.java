```java
import java.util.regex.Pattern;

public class CredentialValidator {
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]{3,16}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    public static boolean validateUsername(String username) {
        return Pattern.matches(USERNAME_PATTERN, username);
    }

    public static boolean validatePassword(String password) {
        return Pattern.matches(PASSWORD_PATTERN, password);
    }

    public static void main(String[] args) {
        String validUsername = "john_doe123";
        String invalidUsername = "@#john";
        String validPassword = "Password123";
        String invalidPassword = "pass";

        System.out.println("Username validation examples:");
        System.out.println(validUsername + ": " + validateUsername(validUsername));
        System.out.println(invalidUsername + ": " + validateUsername(invalidUsername));

        System.out.println("\nPassword validation examples:");
        System.out.println(validPassword + ": " + validatePassword(validPassword));
        System.out.println(invalidPassword + ": " + validatePassword(invalidPassword));
    }
}
```
Output:
```
Username validation examples:
john_doe123: true
@#john: false

Password validation examples:
Password123: true
pass: false
```