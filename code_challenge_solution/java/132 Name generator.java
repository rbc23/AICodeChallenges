```java
import java.util.Random;

public class NameGenerator {
    private static final String[] FIRST_NAMES = {"John", "Michael", "Emily", "Emma", "Olivia", "Sophia", "Liam", "Jacob"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia"};

    public static void main(String[] args) {
        String randomFirstName = getRandomName(FIRST_NAMES);
        String randomLastName = getRandomName(LAST_NAMES);

        System.out.println("Random Name: " + randomFirstName + " " + randomLastName);
    }

    private static String getRandomName(String[] names) {
        Random random = new Random();
        int randomIndex = random.nextInt(names.length);
        return names[randomIndex];
    }
}
```