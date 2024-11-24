import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String s = "contains";
        int ans = LongestSubstring(s);
        System.out.println(ans);
    }

    public static int LongestSubstring(String s) {
        int n = s.length();
        Set<Character> seen = new HashSet<>();
        int maxLen = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            char currChar = s.charAt(end);

            while (seen.contains(currChar)) {
                char startChar = s.charAt(start);
                seen.remove(startChar);
                start++;
            }

            seen.add(currChar);
            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }
}
