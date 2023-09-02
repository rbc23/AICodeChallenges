import java.util.ArrayList;
import java.util.Random;

public class RandomNamePicker {
    
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Emma");
        names.add("Michael");
        names.add("Sophia");
        names.add("Daniel");
        names.add("Olivia");
        
        Random rand = new Random();
        int index = rand.nextInt(names.size());
        String randomName = names.get(index);
        
        System.out.println("Randomly picked name: " + randomName);
    }
}