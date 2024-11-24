import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithAtMostKDistinctChar {
    public static void main(String[] args) {
        String s = "araaci";
        int k = 2;
        int result = lengthOfLongestSubstringKDistinct(s, k);
        System.out.println(result);
    }

    private static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int start = 0, maxLen = 0;

        for (int end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            charCount.put(currChar, charCount.getOrDefault(currChar, 0) + 1);

            while (charCount.size() > k) {
                char prevChar = s.charAt(start);
                charCount.put(prevChar, charCount.get(prevChar) - 1);

                if (charCount.get(prevChar) == 0) {
                    charCount.remove(prevChar);
                }

                start += 1;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

}
