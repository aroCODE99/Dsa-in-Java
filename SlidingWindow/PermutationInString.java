import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        boolean havePermutationInString = permutationInString(s1, s2);
        System.out.println(havePermutationInString);
    }

    private static boolean permutationInString(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a'] += 1;
            s2Freq[s2.charAt(i) - 'a'] += 1;
        }

        for (int end = s1.length(); end < s2.length(); end++) {
            if (Arrays.equals(s1Freq, s2Freq)) {
                return true;
            }
            s2Freq[s2.charAt(end) - 'a']++;
            s2Freq[s2.charAt(end - s1.length()) - 'a']--;
        }
        return Arrays.equals(s1Freq, s2Freq);
    }
}
