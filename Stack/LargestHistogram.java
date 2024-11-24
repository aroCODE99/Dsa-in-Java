import java.util.Stack;

public class LargestHistogram {
    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        int maxArea = largestRectangleArea(heights);
        System.out.println(maxArea);
    }

    private static int largestRectangleArea(int[] heights) {
        int maxArea = 0; // Start from 0 instead of Integer.MIN_VALUE
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        for (int i = 0; i <= n; i++) { // Loop until n (inclusive)
            int rightBound = (i == n) ? 0 : heights[i]; // Use 0 at the end of the heights array

            while (!stack.isEmpty() && rightBound < heights[stack.peek()]) {
                int idx = stack.pop(); // Get the index of the last bar
                int currHeight = heights[idx];
                // Correct width calculation
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Width calculation
                maxArea = Math.max(maxArea, currHeight * width); // Calculate area
            }
            stack.push(i); // Push the current index onto the stack
        }
        return maxArea;
    }
}
