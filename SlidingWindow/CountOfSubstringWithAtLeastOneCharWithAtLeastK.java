public class CountOfSubstringWithAtLeastOneCharWithAtLeastK {
    public static void main(String[] args) {
        String s = "abacb";
        int k = 2;
    }

    private static int numberOfStrings(String s, int k) {
        int n = s.length();
        int[] mapFreq = new int[26];
        int start = 0;

        for (int end = 0; end < n; end++) {
            char currChar = s.charAt(end);
            mapFreq[currChar - 'a'] += 1;

            while (isValid && (mapFreq[currChar - 'a'] + 1 == k)) {

            }
        }
    }
}
