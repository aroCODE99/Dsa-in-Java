public class LongestAlternatingSubArray {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 3, 4 };
        int longestSubarray = alternatingSubarray(nums);
        System.out.println(longestSubarray);
    }

    public static int alternatingSubarray(int[] nums) {
        int start = 0;
        int maxLen = 0;
        int n = nums.length;
        int prevNum = 0;

        for (int i = 0; i < n; i++) {
            int currNum = nums[i];
            if (currNum % 2 == 0 && nums[start] < currNum) {
                start++;
            }
            if (i > 0 && currNum == prevNum + 1 || currNum == prevNum - 1) {
                maxLen = Math.max(maxLen, i - start);
            }
            prevNum = nums[i];
        }

        return maxLen;
    }
}
