import java.util.HashSet;

public class JewelsAndStones {
    public static void main(String[] args) {
        String stones = "aAAbbbb";
        String jewels = "aA";
        System.out.println(jewelsInStones(stones, jewels));
    }

    private static int jewelsInStones(String stones, String jewels) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for (char ch : jewels.toCharArray()) {
            set.add(ch);
        }
        for (char ch : stones.toCharArray()) {
            if (set.contains(ch)) {
                count += 1;
            }
        }
        return count;
    }
}
