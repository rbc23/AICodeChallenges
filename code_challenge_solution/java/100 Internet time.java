Sure! Here's the Java code to convert time to Swatch Internet Time:

```java
import java.time.LocalTime;

public class InternetTimeConverter {
    public static void main(String[] args) {
        // Get the current time
        LocalTime currentTime = LocalTime.now();
        
        // Calculate the Internet Time
        int internetTime = calculateInternetTime(currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond());
        
        // Print the Internet Time
        System.out.println("Internet Time: " + internetTime);
    }
    
    private static int calculateInternetTime(int hour, int minute, int second) {
        // Convert the time to seconds
        int totalSeconds = (hour * 3600) + (minute * 60) + second;
        
        // Calculate the Internet Time
        int internetTime = (int) Math.floor((totalSeconds / 86.4));
        
        return internetTime;
    }
}
```

Note that this code uses the `java.time` package introduced in Java 8. If you are using an older version of Java, you may need to use a different library or approach to retrieve the current time.