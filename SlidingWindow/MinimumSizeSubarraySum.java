public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        System.out.println(minSubArrayLen(target, nums));
    }

    private static int minSubArrayLen(int target, int[] arr) {
        int start = 0, subArrayLen = Integer.MAX_VALUE;
        int currSum = 0;

        for (int end = 0; end < arr.length; end++) {
            currSum += arr[end];

            while (currSum >= target) {
                subArrayLen = Math.min(subArrayLen, end - start + 1);
                currSum -= arr[start];
                start++;
            }
        }

        return subArrayLen == Integer.MAX_VALUE ? 0 : subArrayLen;
    }
}
