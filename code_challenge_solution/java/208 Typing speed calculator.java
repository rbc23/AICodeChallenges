import java.util.Scanner;

public class TypingSpeedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Type the given text:");
        String givenText = scanner.nextLine();
        
        System.out.println("Type the text as fast as you can:");
        String typedText = scanner.nextLine();
        
        int givenTextLength = givenText.length();
        int typedTextLength = typedText.length();
        
        long timeTakenInSeconds = System.currentTimeMillis() / 1000; // current time in seconds
        
        double minutes = (double) timeTakenInSeconds / 60;
        double seconds = (double) timeTakenInSeconds % 60;
        
        double accuracy = calculateAccuracy(givenText, typedText, typedTextLength);
        int speed = calculateSpeed(typedTextLength, minutes);
        
        System.out.println("Accuracy: " + accuracy * 100 + "%");
        System.out.println("Speed: " + speed + " characters per minute");
        
        scanner.close();
    }
    
    private static double calculateAccuracy(String givenText, String typedText, int typedTextLength) {
        int commonLength = 0;
        
        for (int i = 0; i < typedTextLength; i++) {
            if (givenText.charAt(i) == typedText.charAt(i)) {
                commonLength++;
            }
        }
        
        return (double) commonLength / typedTextLength;
    }
    
    private static int calculateSpeed(int typedTextLength, double minutes) {
        double speed = typedTextLength / minutes;
        return (int) speed;
    }
}