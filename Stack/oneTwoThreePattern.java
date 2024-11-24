import java.util.Stack;

public class oneTwoThreePattern {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2 };
        boolean ans = find132pattern(nums);
        System.out.println(ans);
    }

    public static boolean find132pattern(int[] nums) {
        // stack for finding k and j
        Stack<Integer> stack = new Stack<>();
        int num_k = Integer.MIN_VALUE;
        for (int j = nums.length - 1; j >= 0; j--) {
            // this means we have found the i
            if (nums[j] < num_k) {
                return true;
            }
            while (!stack.empty() && nums[j] > stack.peek()) {
                num_k = stack.pop();
            }
            stack.push(nums[j]);
        }
        return false;
    }
}
