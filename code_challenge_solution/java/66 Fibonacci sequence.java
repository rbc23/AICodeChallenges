public class FibonacciSequence {
    public static void main(String[] args) {
        int n = 20; // define the number of terms to generate in the sequence
        
        // variables to store the current and previous terms in the sequence
        int currentTerm = 0;
        int previousTerm = 1;
        
        // print the first two terms in the sequence
        System.out.print(previousTerm + " " + currentTerm + " ");
        
        // generate the remaining terms in the sequence
        for (int i = 2; i < n; i++) {
            int nextTerm = previousTerm + currentTerm;
            System.out.print(nextTerm + " ");
            
            previousTerm = currentTerm;
            currentTerm = nextTerm;
        }
    }
}