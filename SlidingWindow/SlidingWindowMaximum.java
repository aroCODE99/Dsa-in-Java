import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, -5, 3, 6, 7 };
        int k = 3;
        int[] maxPerWindows = maxSlidingWindowII(nums, k);
        System.out.println(Arrays.toString(maxPerWindows));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return res;
    }

    private static int[] maxSlidingWindowII(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        int resPtr = 0;

        for (int end = 0; end < n; end++) {
            int currNum = nums[end];

            if (!deque.isEmpty() && deque.peekFirst() < (end - k + 1)) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < currNum) {
                deque.pollLast();
            }

            deque.offerLast(end);

            if (end - k + 1 >= 0) {
                res[resPtr++] = nums[deque.peekFirst()];
            }
        }
        return res;

    }
}
// int[] nums = { 1, 3, -1, -3, -5, 3, 6, 7 };
// now how will i know that currwindow.size() is == 3
//
//
// thoda hiearchy galat ho chuka he
