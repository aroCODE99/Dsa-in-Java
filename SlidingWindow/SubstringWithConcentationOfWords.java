import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcentationOfWords {
    public static void main(String[] args) {
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = { "fooo", "barr", "wing", "ding", "wing" };
        List<Integer> substrings = findSubstring(s, words);
        System.out.println(substrings);
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordLen = words[0].length();

        Map<String, Integer> wordsFreq = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordsFreq.put(words[i], wordsFreq.getOrDefault(words[i], 0) + 1);
        }

        int totalWordLen = wordLen * words.length;
        int n = s.length() - totalWordLen;
        for (int start = 0; start <= n;) {
            Map<String, Integer> currMap = new HashMap<>();
            for (int end = start; end < totalWordLen + start;) {
                String currWord = s.substring(end, end + wordLen);
                currMap.put(currWord, currMap.getOrDefault(currWord, 0) + 1);
                end += wordLen;
            }
            if (currMap.equals(wordsFreq)) {
                res.add(start);
            }
            start += 1;
        }
        return res;
    }
}
