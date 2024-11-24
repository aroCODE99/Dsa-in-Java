import java.util.Arrays;

public class FirstAndLastOccurence {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 7;
        int[] newTryAns = searchRangeII(nums, target);
        System.out.println(Arrays.toString(newTryAns));
    }

    public static int[] searchRangeII(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] ans = { -1, -1 };

        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                // Target found; find left and right
                int left = mid;
                int right = mid;

                // Find the leftmost index
                while (left > 0 && nums[left] == nums[left - 1]) {
                    left--;
                }

                // Find the rightmost index
                while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right++;
                }

                // Update answer with the found indices
                ans[0] = left; // Left index
                ans[1] = right; // Right index
                return ans; // Return as soon as both indices are found
            }
        }
        return ans;
    }

    public static int searchRange(int[] nums, int target, boolean findFirst) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                ans = mid;
                if (findFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

}
