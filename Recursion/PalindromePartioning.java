import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {
    public static void main(String[] args) {
        String str = "aab";
        List<List<String>> res = new ArrayList<>();
        backTrackPalindrome(str, 0, new ArrayList<>(), res);
        System.out.println(res);
    }

    private static void backTrackPalindrome(String str, int start, List<String> curr, List<List<String>> res) {
        if (start == str.length()) {
            res.add(new ArrayList<>(curr));
        }
        for (int end = start; end < str.length(); end++) {
            if (isPalindrome(str, start, end)) {
                curr.add(str.substring(start, end + 1));
                backTrackPalindrome(str, end + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (end >= start) {
            if (s.charAt(end) != s.charAt(start)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

}
