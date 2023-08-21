
import java.util.Scanner;

public class TextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();

        System.out.println("Text Editor");
        System.out.println("Enter 'q' to quit");

        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.equalsIgnoreCase("q")) {
                break;
            }
            text.append(line).append("\n");
        }

        System.out.println("Your text:");
        System.out.println(text);
    }
}
