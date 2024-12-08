import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] newStr = s.toCharArray();
            Arrays.sort(newStr);
            String sortedStr = new String(newStr);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            map.get(sortedStr).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> grouped : map.values()) {
            res.add(grouped);
        }

        return res;
    }
}

// { "eat", "tea", "tan", "ate", "nat", "bat" }
//
//
// ate ant atb
//
