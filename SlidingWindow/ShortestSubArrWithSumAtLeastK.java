import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubArrWithSumAtLeastK {
    public static void main(String[] args) {
        int[] nums = { 84, -37, 32, 40, 95 };
        int k = 167;
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
            System.out.println(deque);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int shortestSubarrayII(int[] nums, int k) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        int start = 0;
        for (int end = 0; end < n; end++) {
            int currNum = nums[end];
            sum += currNum;

            while (sum >= k) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start += 1;
            }

        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
// [84, -37, 32, 40, 95]
// so this -num is funking our solution
//
// if -num is funcking this thing, so could deque solve this thing ?
// let's see
// 84 is max till 1 and sum < k
// -37 is not max till 2 and still sum < k
// 32 is also not max till 3 and still sum < k
// and this goes on till the end
// and in the end the sum goes above k and it cal the minLen and then it tries
// to shrink the window and it is unable to do so
// so, it return's the minLen to be 5
// but the real op is 3 last 3 nums
//
// so the -37 is really messing the solution
//
// i think i got it
// we could check if the sum has been decreased than prev sum
