import java.time.LocalTime;

public class SwatchInternetTimeConverter {
    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.now();
        int internetTime = calculateInternetTime(currentTime);
        System.out.println("The Swatch Internet Time is: " + internetTime);
    }

    public static int calculateInternetTime(LocalTime currentTime) {
        int totalSeconds = currentTime.getHour() * 3600 + currentTime.getMinute() * 60 + currentTime.getSecond();
        int internetTime = (int) Math.ceil(totalSeconds / 86.4);
        return internetTime;
    }
}