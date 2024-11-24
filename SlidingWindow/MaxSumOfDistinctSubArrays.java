import java.util.HashSet;
import java.util.Set;

public class MaxSumOfDistinctSubArrays {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 7, 8, 9 };
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        int n = nums.length;
        long maxSum = 0;
        int currSum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            int currNum = nums[end];

            while (seen.contains(currNum)) {
                seen.remove(nums[start]);
                currSum -= nums[start];
                start += 1;
            }
            seen.add(currNum);
            currSum += currNum;

            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, currSum);
                seen.remove(nums[start]);
                currSum -= nums[start++];
            }
        }
        return maxSum;
    }
}
