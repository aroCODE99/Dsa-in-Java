public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 1, 3, 2 };
        int k = 3;
        System.out.println("Maximum sum of subarray of size K: " + maxSumSubArray(arr, k)); // Output: 9
    }

    private static int maxSumSubArray(int[] arr, int k) {
        int maxSum = 0, currSum = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, currSum);
                currSum -= arr[start];
                start++;
            }
        }
        return maxSum;

    }
}
