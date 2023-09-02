Here is the Java code to create a FactorialCalculator class that calculates the factorial of a given number:

```java
public class FactorialCalculator {
    
    public static int calculateFactorial(int number) {
        if (number == 0) {
            return 1;
        } else {
            return number * calculateFactorial(number - 1);
        }
    }
    
    public static void main(String[] args) {
        int number = 5; // Change this to calculate factorial for a different number
        
        int factorial = calculateFactorial(number);
        
        System.out.println("Factorial of " + number + " is " + factorial);
    }
}
```

In the main method, you can change the value of the `number` variable to calculate the factorial for a different number.