import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculateAgeInSeconds {
    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(1990, 10, 15);
        LocalDateTime currentDateTime = LocalDateTime.now();

        LocalDateTime birthDateTime = birthDate.atStartOfDay();

        long seconds = ChronoUnit.SECONDS.between(birthDateTime, currentDateTime);

        System.out.println("Age in seconds: " + seconds);
    }
}