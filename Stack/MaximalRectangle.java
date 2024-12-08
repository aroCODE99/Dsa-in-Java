public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        int ans = maximalRectangle(matrix);
        System.out.println(ans);
    }

    public static int maximalRectangle(char[][] matrix) {
        int maxRectangle = Integer.MIN_VALUE;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int currVal = Integer.parseInt(String.valueOf(matrix[i][j]));
                if (currVal == 0) {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
            }
            maxRectangle = Math.max(maxRectangle, largestRectangleArea(heights));
        }
        return maxRectangle;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n + 1];
        int maxArea = 0;
        int top = -1;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];
            while (top >= 0 && currHeight < heights[stack[top]]) {
                // find the area
                int height = heights[stack[top--]];
                int width = top == -1 ? i : i - stack[top] - 1;// width calculation
                maxArea = Math.max(maxArea, height * width); // Update max area
            }
            stack[++top] = i;
        }

        return maxArea;
    }
}
