import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static void main(String[] args) {
        String s = "tree";
        String ans = FrequencySortFunc(s);
        System.out.println(ans);
    }

    private static String FrequencySortFunc(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue() // Sort in descending order of frequency
        );

        maxHeap.addAll(map.entrySet());// this will add all the map entries
        StringBuilder str = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            str.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
        }

        return str.toString();
    }
}
