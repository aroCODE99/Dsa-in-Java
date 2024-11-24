import java.util.Arrays;

public class PrefixSum {
    public static void main(String[] args) {
        int[] nums = { 2, -1, 2 };
        System.out.println(Arrays.toString(prefixSum(nums)));
    }

    private static long[] prefixSum(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ans[i + 1] = ans[i] + nums[i];
        }
        return ans;
    }
}
