import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] stocksPrices = { 100, 80, 60, 70, 60, 75, 85 };
        int[] stoprintlnckSpan = stockSpan(stocksPrices);
        System.out.println(Arrays.toString(stoprintlnckSpan));
    }

    private static int[] stockSpan(int[] stocksPrices) {
        int n = stocksPrices.length;
        Stack<Integer> stack = new Stack<>();
        int[] stockSpan = new int[n];
        Arrays.fill(stockSpan, -1);

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && stocksPrices[stack.peek()] < stocksPrices[i]) {
                stack.pop();
            }
            stockSpan[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        return stockSpan;
    }
}
