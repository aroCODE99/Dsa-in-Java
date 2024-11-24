public class LongestAlphabeticalSubString {
    public static void main(String[] args) {
        String s = "abacaba";
        int length = longestContinuousSubstring(s);
        System.out.println(length);
    }

    public static int longestContinuousSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int currLen = 0;
        for (int end = 0; end < n; end++) {
            char currChar = s.charAt(end);
            if (end > 0 && (currChar - 'a') - 1 != s.charAt(end - 1) - 'a') {
                currLen = 0;
            }
            currLen++;
            maxLen = Math.max(currLen, maxLen);
        }
        return maxLen;
    }
}
