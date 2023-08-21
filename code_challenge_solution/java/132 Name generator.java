import java.util.Random;

public class NameGenerator {
    private static final String[] firstNames = { "John", "Emma", "Michael", "Olivia", "William", "Sophia", "James", "Ava", "Daniel", "Isabella" };
    private static final String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson" };
    
    public static void main(String[] args) {
        String randomName = generateRandomName();
        System.out.println("Random Name: " + randomName);
    }
    
    public static String generateRandomName() {
        Random rand = new Random();
        
        String firstName = firstNames[rand.nextInt(firstNames.length)];
        String lastName = lastNames[rand.nextInt(lastNames.length)];
        
        return firstName + " " + lastName;
    }
}