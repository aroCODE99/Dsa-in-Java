public class MaximumConcesutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }

    private static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;

        int maxSkips = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            int currNum = nums[end];

            if (currNum == 0) {
                maxSkips += 1;
            }

            while (maxSkips > k) {
                if (nums[start] == 0) {
                    maxSkips -= 1;
                }
                start += 1;
            }

            maxLen = Math.max(maxLen, end - start + 1);

        }

        return maxLen;
    }
}

// {1,1,1,0,0,0,1,1,1,1,0}
