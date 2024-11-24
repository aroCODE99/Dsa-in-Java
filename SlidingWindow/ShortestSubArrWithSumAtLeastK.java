import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubArrWithSumAtLeastK {
    public static void main(String[] args) {
        int[] nums = { 2, -1, 2 };
        int k = 3;
        System.out.println(shortestSubarray(nums, k));
    }

    private static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1]; // prefixSum[i] includes sum of nums[0] to nums[i-1]
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int result = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();

        // we have iterating the nums from left to right
        for (int i = 0; i <= n; i++) {
            // Remove indices where subarray sum >= k
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                result = Math.min(result, i - deque.pollFirst());
            }

            // Remove indices to maintain monotonicity in deque
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add the current index
            deque.addLast(i);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
