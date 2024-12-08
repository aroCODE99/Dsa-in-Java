public class MaximumConcesutiveOnes {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        System.out.println(findMaxConsecutiveOnesII(nums));
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        int count = 0;
        for (int end = 0; end < n; end++) {
            if (nums[end] == 1) {
                count++;
            } else {
                count = 0;
            }
            maxLen = Math.max(maxLen, count);
        }

        return maxLen;
    }

    private static int findMaxConsecutiveOnesII(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        int start = 0;
        for (int end = 0; end < n; end++) {
            // we had to skip the 0's
            if (nums[end] == 0 && end < n - 1) {
                start = end + 1;
                continue;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

}

// 1,1,0,1,1,1
