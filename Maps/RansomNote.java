import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mapOfRansom = new HashMap<>();
        for (char ch : ransomNote.toCharArray()) {
            mapOfRansom.put(ch, mapOfRansom.getOrDefault(ch, 0) + 1);
        }

        for (char ch : magazine.toCharArray()) {
            if (mapOfRansom.containsKey(ch)) {
                mapOfRansom.put(ch, mapOfRansom.getOrDefault(ch, 0) - 1);
                if (mapOfRansom.get(ch) < 1) {
                    mapOfRansom.remove(ch);
                }
            }

        }
        return mapOfRansom.isEmpty();
    }
}
