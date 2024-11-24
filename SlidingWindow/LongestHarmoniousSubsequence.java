import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
        int longestHarmoniousSeq = findLHS(nums);
        System.out.println(longestHarmoniousSeq);
    }

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int maxLen = 0;
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (frequency.containsKey(nums[i] + 1)) {
                int currLen = frequency.get(nums[i]) + frequency.get(nums[i] + 1);
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
}
