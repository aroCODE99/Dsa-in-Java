import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        boolean ans = containsNearbyDuplicate(nums, k);
        System.out.println(ans);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i]))
                return true;

            seen.add(nums[i]);
            //we only move the window start (end - k) forward when the length of window is above k
            if (seen.size() > k) {
                seen.remove(nums[i - k]);
            }
        }
        return false;
    }
}
