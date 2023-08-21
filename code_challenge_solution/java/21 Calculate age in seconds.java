import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class AgeInSecondsCalculator {

    public static void main(String[] args) {
        LocalDate birthdate = LocalDate.of(1990, 4, 15);
        LocalDate currentDate = LocalDate.now();

        long ageInYears = Period.between(birthdate, currentDate).getYears();
        long ageInSeconds = ageInYears * 365 * 24 * 60 * 60;

        System.out.println("The age in seconds is: " + ageInSeconds);
    }
}
