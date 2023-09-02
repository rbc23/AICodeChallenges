```java
public class WordCount {
    public static void main(String[] args) {
        String sentence = "Count words in a string";
        int wordCount = countWords(sentence);
        System.out.println("Word count: " + wordCount);
    }
    
    public static int countWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }
        
        String[] words = sentence.split("\\s+");
        return words.length;
    }
}
```