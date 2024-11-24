import java.util.Arrays;

public class CountTheNumberOfFairPairs {
    public static void main(String[] args) {
        int[] nums = { 1, 7, 9, 2, 5 };
        int lower = 11;
        int upper = 11;
        long numOfParis = countFairPairsOpt(nums, lower, upper);
        System.out.println(numOfParis);
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i < nums.length && nums[i] + nums[i + 1] > upper) {
                break;
            }
            count += countFairPairsHelper(nums, lower, upper, i);
        }
        return count;
    }

    public static long countFairPairsHelper(int[] nums, int lower, int upper, int i) {
        int j = i + 1;
        int n = nums.length;
        long count = 0;
        while (j < n) {
            long sum = nums[i] + nums[j];
            if (sum >= lower && sum <= upper) {
                count++;
            }
            j++;
        }
        return count;
    }

    public static int BinarySearch(int[] nums, int start, int target, boolean findingRightBound) {
        int end = nums.length - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target || (findingRightBound && nums[mid] == target)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return findingRightBound ? end : start;
    }

    private static long countFairPairsOpt(int[] nums, int upper, int lower) {
        int n = nums.length;
        long count = 0;
        for (int i = 0; i < n - 1; i++) {
            int leftBound = BinarySearch(nums, i + 1, lower - nums[i], false);
            int rightBound = BinarySearch(nums, i + 1, upper - nums[i], true);
            if (rightBound >= leftBound) {
                count += rightBound - leftBound + 1;
            }
        }
        return count;
    }
}
