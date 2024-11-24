public class CountOfSubstringWithK {
    public static void main(String[] args) {
        String s = "abacb";
        int k = 2;
        System.out.println(numberOfStrings(s, k));
    }

    private static int numberOfStrings(String s, int k) {
        int n = s.length();
        int count = 0;
        int start = 0;
        int[] freqMap = new int[26];
        for (int end = 0; end < n; end++) {
            char currChar = s.charAt(end);
            freqMap[currChar - 'a'] += 1;

            while (freqMap[currChar - 'a'] == k) {
                count += n - end;
                freqMap[s.charAt(start) - 'a'] -= 1;
                start += 1;
            }
        }
        return count;
    }

    // String s = "abacb";
    private static int numberOfStringsII(String s, int k) {
        int n = s.length();
        int substrings = 0;

        for (int i = 0; i < n; i++) {
            int[] map = new int[26];
            for (int j = i; j < n; j++) {
                char currChar = s.charAt(j);
                map[currChar - 'a'] += 1;
                if (hasAtleast(map, k)) {
                    substrings += 1;
                }
            }
        }
        return substrings;
    }

    private static boolean hasAtleast(int[] map, int k) {
        for (int freq : map) {
            if (freq >= k) {
                return true;
            }
        }
        return false;
    }
}
