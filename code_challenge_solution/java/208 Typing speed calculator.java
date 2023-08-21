
import java.util.Scanner;

public class TypingSpeedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the text to calculate typing speed: ");
        String inputText = scanner.nextLine();
        
        System.out.println("Enter the time taken to type the text (in seconds): ");
        int timeInSeconds = scanner.nextInt();
        
        scanner.close();
        
        int wordsCount = inputText.split(" ").length;
        int charactersCount = inputText.replaceAll("\\s", "").length();
        
        double wordsPerMinute = (wordsCount / (double) timeInSeconds) * 60;
        double charactersPerMinute = (charactersCount / (double) timeInSeconds) * 60;
        
        System.out.println("Typing Speed Report:");
        System.out.println("Words per Minute: " + wordsPerMinute);
        System.out.println("Characters per Minute: " + charactersPerMinute);
    }
}
