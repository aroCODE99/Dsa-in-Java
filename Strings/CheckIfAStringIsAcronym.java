import java.util.ArrayList;
import java.util.List;

public class CheckIfAStringIsAcronym {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("aro", "bob", "charlie"));
        String s = "abc";
        System.out.println(isAcronym(words, s));
    }

    public static boolean isAcronym(List<String> words, String s) {
        if (s.length() < words.size()) {
            return false;
        }
        int j = 0;
        int count = 0;
        for (String word : words) {
            if (word.charAt(0) == s.charAt(j)) {
                count++;
                j += 1;
            }
        }
        return count == s.length();
    }
}
