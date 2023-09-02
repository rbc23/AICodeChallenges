Here is the Java code to create an ASCII Digital Clock:

```java
import java.text.SimpleDateFormat;
import java.util.Date;

public class ASCIIDigitalClock {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        while (true) {
            String currentTime = dateFormat.format(new Date());
            printDigitalClock(currentTime);

            try {
                Thread.sleep(1000); // wait for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printDigitalClock(String currentTime) {
        String[][] digits = {
                {
                        "  ###  ",
                        " #   # ",
                        "#     #",
                        "#     #",
                        "#     #",
                        " #   # ",
                        "  ###  "
                },
                {
                        "   #   ",
                        "  ##   ",
                        " # #   ",
                        "   #   ",
                        "   #   ",
                        "   #   ",
                        " ##### "
                },
                {
                        " ##### ",
                        "#     #",
                        "      #",
                        "   ### ",
                        " #     ",
                        "#      ",
                        "#######"
                },
                {
                        " ##### ",
                        "#     #",
                        "      #",
                        "  #### ",
                        "      #",
                        "#     #",
                        " ##### "
                },
                {
                        "#      ",
                        "#    # ",
                        "#    # ",
                        "#    # ",
                        "#######",
                        "     # ",
                        "     # "
                },
                {
                        "#######",
                        "#      ",
                        "#      ",
                        "###### ",
                        "      #",
                        "#     #",
                        " ##### "
                },
                {
                        "  ###  ",
                        " #     ",
                        "#      ",
                        "###### ",
                        "#     #",
                        "#     #",
                        " ##### "
                },
                {
                        "#######",
                        "#    # ",
                        "    #  ",
                        "   #   ",
                        "  #    ",
                        " #     ",
                        "#      "
                },
                {
                        " ##### ",
                        "#     #",
                        "#     #",
                        " ##### ",
                        "#     #",
                        "#     #",
                        " ##### "
                },
                {
                        " ##### ",
                        "#     #",
                        "#     #",
                        " ######",
                        "      #",
                        "#     #",
                        " ##### "
                },
        };

        String[] digitsArray = currentTime.split(":");
        int hour = Integer.parseInt(digitsArray[0]);
        int minute = Integer.parseInt(digitsArray[1]);
        int second = Integer.parseInt(digitsArray[2]);

        String[] hourDigit1 = digits[hour / 10];
        String[] hourDigit2 = digits[hour % 10];
        String[] minuteDigit1 = digits[minute / 10];
        String[] minuteDigit2 = digits[minute % 10];
        String[] secondDigit1 = digits[second / 10];
        String[] secondDigit2 = digits[second % 10];

        String[][] clock = {
                hourDigit1, hourDigit2,
                minuteDigit1, minuteDigit2,
                secondDigit1, secondDigit2
        };

        for (int i = 0; i < 7; i++) {
            for (String[] digit : clock) {
                System.out.print(digit[i] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
```

This program will continuously print the current time in the form of ASCII art for a digital clock. It uses a 2D array to store the ASCII representation of each digit (0-9), and then fetches the ASCII representation for each digit from the current time to display it on the console. The program will update the time every second.