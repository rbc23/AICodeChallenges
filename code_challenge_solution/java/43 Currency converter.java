```java
public class CurrencyConverter {
    public static void main(String[] args) {
        double amount = 100.0;
        double exchangeRate = 0.85;
        double convertedAmount = convertCurrency(amount, exchangeRate);
        System.out.println(amount + " USD = " + convertedAmount + " EUR");

        amount = 500.0;
        exchangeRate = 1.1;
        convertedAmount = convertCurrency(amount, exchangeRate);
        System.out.println(amount + " EUR = " + convertedAmount + " USD");
    }

    public static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}
```