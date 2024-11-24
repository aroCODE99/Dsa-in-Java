import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] temperatures = { 30, 38, 30, 36, 35, 40, 28 };
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int length = temperatures.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int toWarmTemp = stack.pop();
                result[toWarmTemp] = i - toWarmTemp;
            }
            stack.push(i);
        }
        return result;
    }
}
