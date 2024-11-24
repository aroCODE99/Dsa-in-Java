import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstringOfAllVowelsInOrder {
    public static void main(String[] args) {
        String word = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
        int longestSubString = tongestBeautifulSubstring(word);
        System.out.println(longestSubString);
    }

    public static int longestBeautifulSubstring(String word) {
        int maxLen = 0;
        int n = word.length();
        int start = 0; // Start of the current substring
        int countVowels = 0; // Number of unique vowels in current substring

        for (int end = 0; end < n; end++) {
            // If characters are not in non-decreasing order, reset
            if (end > 0 && word.charAt(end) < word.charAt(end - 1)) {
                start = end;
                countVowels = 0;
            }

            // Count a new unique vowel
            if (end == 0 || word.charAt(end) != word.charAt(end - 1)) {
                if ("aeiou".indexOf(word.charAt(end)) != -1) {
                    countVowels++;
                }
            }

            // If we have seen all 5 vowels in order, update maxLen
            if (countVowels == 5) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }

        return maxLen;
    }
}
