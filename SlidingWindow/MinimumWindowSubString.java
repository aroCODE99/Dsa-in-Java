import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        String s = "ADOBEBANCCODE", t = "ABC";
        String minWindowStr = minWindow(s, t);
        System.out.println(minWindowStr);
    }

    private static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        String minWindowStr = "";
        int matchedCount = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            if (tMap.containsKey(currChar)) {
                sMap.put(currChar, sMap.getOrDefault(currChar, 0) + 1);
                // Only count as matched if the frequency is equal to that in tMap
                if (sMap.get(currChar).equals(tMap.get(currChar))) {
                    matchedCount++;
                }
            }

            // Try to contract the window till it ceases to be 'desirable'
            while (matchedCount == requiredMatches) {
                String currWindowStr = s.substring(start, end + 1);
                // Check for minimum length
                if (minWindowStr.isEmpty() || currWindowStr.length() < minWindowStr.length()) {
                    minWindowStr = currWindowStr;
                }

                char startChar = s.charAt(start);
                if (tMap.containsKey(startChar)) {
                    sMap.put(startChar, sMap.get(startChar) - 1);
                    // Check if we have lost a required character
                    if (sMap.get(startChar) < tMap.get(startChar)) {
                        matchedCount--;
                    }
                }
                start++;
            }
        }
        return minWindowStr;
    }
}
