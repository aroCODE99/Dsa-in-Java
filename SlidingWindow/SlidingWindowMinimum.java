import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMinimum {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, -5, 3, 6, 7 };
        int k = 3;
        int[] minPerWindows = minSlidingWindow(nums, k);
        System.out.println(Arrays.toString(minPerWindows));
    }

    private static int[] minSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[i] <= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }

        }

        return res;
    }
}
