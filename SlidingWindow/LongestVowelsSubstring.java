import java.util.Set;

public class LongestVowelsSubstring {
    public static void main(String[] args) {
        // Test cases
        System.out.println(findLongestVowelSubstring("aeiouu")); // Output: 6
        System.out.println(findLongestVowelSubstring("leetcode")); // Output: 2
        System.out.println(findLongestVowelSubstring("rhythm")); // Output: 0
    }

    private static int findLongestVowelSubstring(String s) {
        Set<Character> setOfVowels = Set.of('a', 'e', 'i', 'o', 'u');
        int currLen = 0;
        int maxLen = 0;

        System.out.println(s);
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (setOfVowels.contains(ch)) {
                currLen++;
            } else {
                currLen = 0;
            }
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}
