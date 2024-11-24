import java.util.Arrays;

public class FrquencyOfMostFreq {
    public static void main(String[] args) {
        int[] nums = { 1, 4, 2 };
        int k = 5;
        int mostFreq = mostFreq(nums, k);
        System.out.println(mostFreq);
    }

    private static int mostFreq(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int maxFreq = 0;
        int start = 0;

        for (int end = 1; end < n; end++) {
            total += (long) (nums[end] - nums[end] - 1) * (end - start);
            while (total > k) {
                total -= nums[end] - nums[start];
                start += 1;
            }

            maxFreq = Math.max(maxFreq, end - start + 1);
        }
        return maxFreq;
    }
}
