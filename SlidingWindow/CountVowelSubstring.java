import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountVowelSubstring {
    public static void main(String[] args) {
        String word = "unicornarihan";
        System.out.println(countVowelSubstrings(word));
    }

    private static int countVowelSubstrings(String word) {
        return countVowelSubstringsHelper(word, 5) - countVowelSubstringsHelper(word, 4);
    }

    public static int countVowelSubstringsHelper(String word, int atMost) {
        Set<Character> setOfVowels = Set.of('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> mapFreq = new HashMap<>();
        int countOfVowels = 0;
        int start = 0;

        for (int end = 0; end < word.length(); end++) {
            char currChar = word.charAt(end);
            mapFreq.put(currChar, mapFreq.getOrDefault(currChar, 0) + 1);

            if (!setOfVowels.contains(currChar)) {
                start = end + 1;
                mapFreq.clear();
            } else {
                while (mapFreq.size() > atMost) {
                    char startChar = word.charAt(start);
                    mapFreq.put(startChar, mapFreq.get(word.charAt(start)) - 1);
                    if (mapFreq.get(startChar) == 0) {
                        mapFreq.remove(startChar);
                    }
                    start += 1;
                }
            }
            countOfVowels += end - start + 1;
        }
        return countOfVowels;
    }
}
// Count all substrings with at most 3 distinct vowels.
// Subtract all substrings with at most 2 distinct vowels.
// The difference will give you substrings with exactly 3 vowels.
