import java.util.Random;

public class HaikuGenerator {
    // Haiku syllable pattern
    private static final int[] HAIKU_SYLLABLES = { 5, 7, 5 };

    // Haiku word pools
    private static final String[] HAIKU_WORDS_5_SYLLABLES = { "automobile", "cherry blossom", "waterfall" };
    private static final String[] HAIKU_WORDS_7_SYLLABLES = { "gentle raindrops", "mountainous landscape", "whispering wind" };
    private static final String[] HAIKU_WORDS_5_SYLLABLES_2 = { "frosted windowpane", "silence in the night", "wandering shadows" };

    public static void main(String[] args) {
        generateHaiku();
    }

    public static void generateHaiku() {
        Random random = new Random();

        for (int i = 0; i < HAIKU_SYLLABLES.length; i++) {
            StringBuilder haikuLine = new StringBuilder();

            int syllablesRemaining = HAIKU_SYLLABLES[i];
            while (syllablesRemaining > 0) {
                // Randomly select a word from the appropriate word pool
                String[] wordPool;
                if (syllablesRemaining == 5) {
                    wordPool = i == 0 ? HAIKU_WORDS_5_SYLLABLES : HAIKU_WORDS_5_SYLLABLES_2;
                } else {
                    wordPool = HAIKU_WORDS_7_SYLLABLES;
                }
                String word = wordPool[random.nextInt(wordPool.length)];

                // Determine the number of syllables in the selected word
                int syllablesInWord = countSyllables(word);

                // If the selected word fits within the remaining syllables, add it to the current line
                if (syllablesInWord <= syllablesRemaining) {
                    haikuLine.append(word).append(" ");
                    syllablesRemaining -= syllablesInWord;
                }
            }

            System.out.println(haikuLine);
        }
    }

    private static int countSyllables(String word) {
        int count = 0;
        word = word.toLowerCase().replaceAll("[^a-z]", "");

        if (word.length() <= 3) {
            return 1;
        }

        if (word.endsWith("e")) {
            count--;
        }

        for (int i = 0; i < word.length(); i++) {
            if (i == word.length() - 1 && word.charAt(i) == 'y') {
                break;
            }
            if ("aeiou".contains(Character.toString(word.charAt(i)))) {
                count++;
            }
        }

        return count > 0 ? count : 1;
    }
}