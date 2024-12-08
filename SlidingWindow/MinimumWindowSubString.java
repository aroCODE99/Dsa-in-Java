import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        String s = "ADOBEBANCCODE", t = "ABC";
        String minWindowStr = minWindowMine(s, t);
        System.out.println(minWindowStr);
    }

    public static String minWindowMine(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        String minWindowStr = "";
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            if (tMap.containsKey(currChar)) {
                sMap.put(currChar, sMap.getOrDefault(currChar, 0) + 1);
            }

            while (allCharMatched(sMap, tMap)) {
                char startChar = s.charAt(start);
                String currWindowStr = s.substring(start, end + 1);
                // Check if minWindowStr is still empty before comparison
                if (minWindowStr.isEmpty() || currWindowStr.length() < minWindowStr.length()) {
                    minWindowStr = currWindowStr;
                }

                Integer count = sMap.get(startChar);
                if (count != null) {
                    if (sMap.get(startChar) > 1) {
                        sMap.put(startChar, sMap.get(startChar) - 1);
                    } else {
                        sMap.remove(startChar);
                    }
                }

                start++;
            }
        }
        return minWindowStr;
    }

    private static boolean allCharMatched(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (sMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        // unique char count
        int requiredMatches = tMap.size();
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
