import java.util.Arrays;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        int k = 2;
        int ans = splitArray(nums, k);
        System.out.println(ans);
    }

    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        while (end >= start) {
            int mid = start + (end - start) / 2;
            System.out.println(mid);

            if (kSplits(nums, mid, k) > k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private static int kSplits(int[] nums, int midSum, int k) {
        int splits = 1;
        int currSum = 0;
        for (int num : nums) {
            if (currSum + num > midSum) {
                splits++;
                currSum = num;
            } else {
                currSum += num;
            }
        }
        return splits;
    }
}
