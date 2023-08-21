import java.util.ArrayList;
import java.util.Random;

public class RandomNamePicker {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Mike");
        names.add("Emily");
        names.add("Tom");
        
        Random random = new Random();
        int index = random.nextInt(names.size());
        String randomName = names.get(index);
        
        System.out.println("Randomly picked name: " + randomName);
    }
}