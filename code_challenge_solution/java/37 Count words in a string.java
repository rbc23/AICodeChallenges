
public class WordCount {

    public static void main(String[] args) {
        String str = "Count words in a string";
        
        int wordCount = countWords(str);
        System.out.println("Word Count: " + wordCount);
    }
    
    public static int countWords(String str) {
        int count = 0;
        
        if(str != null && !str.isEmpty()){
            String[] words = str.split("\\s+");
            count = words.length;
        }
        
        return count;
    }
}
