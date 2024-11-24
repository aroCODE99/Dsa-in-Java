import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDistinctInt {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int K = 2;
        System.out.println(subarraysWithKDistinct(nums, K)); // Output: 7 
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        // The function atMost(nums, k) counts subarrays with at most k distinct
        // integers.
        // These subarrays also include those with fewer than k distinct integers. When
        // you subtract atMost(nums, k-1), the result is subarrays that were only
        // included because they have exactly k distinct integers.
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            while (map.size() > k) {
                map.put(nums[start], map.get(nums[start]) - 1);

                if (map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }
                start++;
            }

            count += end - start + 1;
        }
        return count;
    }
}
