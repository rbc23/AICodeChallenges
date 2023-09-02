Sure! Here's the Java code to create a To-Do List Application:

```java
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    public static void main(String[] args) {
        ArrayList<String> toDoList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        while (choice != 4) {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItem(toDoList, scanner);
                    break;
                case 2:
                    removeItem(toDoList, scanner);
                    break;
                case 3:
                    displayToDoList(toDoList);
                    break;
                case 4:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nTo-Do List Application");
        System.out.println("======================");
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Display To-Do List");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addItem(ArrayList<String> toDoList, Scanner scanner) {
        System.out.print("Enter the item to add: ");
        String item = scanner.next();
        toDoList.add(item);
        System.out.println("Item added successfully!");
    }

    private static void removeItem(ArrayList<String> toDoList, Scanner scanner) {
        System.out.print("Enter the item to remove: ");
        String item = scanner.next();
        if (toDoList.contains(item)) {
            toDoList.remove(item);
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Item not found in the list.");
        }
    }

    private static void displayToDoList(ArrayList<String> toDoList) {
        System.out.println("To-Do List:");
        if (toDoList.isEmpty()) {
            System.out.println("No items in the list.");
        } else {
            for (String item : toDoList) {
                System.out.println("- " + item);
            }
        }
    }
}
```

This code creates a To-Do List Application that allows the user to add, remove, and display items in a to-do list. It uses an `ArrayList` to store the items and a `Scanner` to read user input. The menu options are displayed in a loop until the user chooses to exit the application.