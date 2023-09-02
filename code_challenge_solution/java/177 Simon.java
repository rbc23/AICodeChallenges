import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Game {
    private List<Integer> sequence;
    private int level;
    private int currentIndex;

    public Game() {
        sequence = new ArrayList<>();
        level = 1;
        currentIndex = 0;
    }

    public void start() {
        System.out.println("Welcome to Simon Clone!");
        System.out.println("Repeat the sequence by entering the numbers separated by spaces.");
        System.out.println("Get ready...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("Level " + level);
            generateSequence(level);

            boolean success = playSequence();
            if (!success) {
                System.out.println("Game Over!");
                System.out.println("You reached level " + level);
                break;
            }

            level++;
            currentIndex = 0;
            System.out.println("Congratulations! Next level...");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void generateSequence(int length) {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sequence.add(random.nextInt(4) + 1);
        }
    }

    private boolean playSequence() {
        for (int num : sequence) {
            System.out.print(num + " ");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        for (String numStr : inputArray) {
            int number = Integer.parseInt(numStr);
            if (number != sequence.get(currentIndex)) {
                return false;
            }
            currentIndex++;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}