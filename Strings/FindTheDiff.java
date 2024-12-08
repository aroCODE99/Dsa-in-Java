import java.util.HashMap;
import java.util.Map;

public class FindTheDiff {
    public static void main(String[] args) {
        // just XOR it
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                return ch;
            }
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) < 1) {
                map.remove(ch);
            }
        }

        return '1';
    }

    public static char findTheDifferencII(String s, String t) {
        // this is the duplicate pattern
        char res = 0;

        for (char ch : s.toCharArray()) {
            res ^= ch;
        }

        for (char ch : t.toCharArray()) {
            res ^= ch;
        }

        return res;
    }
}

// can we do this without sorting
// i mean with hashmaps or two pointers
//
// "abcd"
// "abcde"
//
//
// we also need to handle the duplicates
//
//
// so this is quite simple problem but the pattern is super important like
// duplicate pattern
//
// this is similar to find Single Number leetcode problem
// now in that question the nmbers were duplicated like mirroring this pattern
//
// in this question alos is quite simillar becuause it also states that same
// thing but in different way
