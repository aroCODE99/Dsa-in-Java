import java.util.HashSet;
import java.util.Set;

public class MaximumRemovalChar {
    public static void main(String[] args) {
        String s = "abcacb";
        String p = "ab";
        int[] removable = { 3, 1, 0 };

        int ans = maximumRemovals(s, p, removable);
        System.out.println(ans);
    }

    public static int maximumRemovals(String s, String p, int[] removable) {
        int start = 0;
        int end = removable.length;

        while (end >= start) {
            int mid = start + (end - start) / 2;

            // Create a set with the first `mid` indices to remove
            Set<Integer> removedIndices = new HashSet<>();
            for (int i = 0; i < mid; i++) {
                removedIndices.add(removable[i]);
            }

            // Check if `p` is still a subsequence after removing these indices
            if (isValid(s, p, removedIndices)) {
                start = mid + 1; // Try to remove more characters
            } else {
                end = mid - 1; // Try to remove fewer characters
            }
        }
        return end;
    }

    private static boolean isValid(String s, String p, Set<Integer> removedIndices) {
        int left = 0;
        int right = 0;

        while (left < s.length() && right < p.length()) {
            if (removedIndices.contains(left)) {
                left += 1;
                continue;
            }

            if (s.charAt(left) == p.charAt(right)) {
                right += 1;
            }
            left += 1;
        }
        return right == p.length();
    }

}
