import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BaseBallGame {
    public static void main(String[] args) {
        String[] ops = { "5", "2", "C", "D", "+" };
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] operations) {
        int n = operations.length;
        Stack<Integer> stack = new Stack<>();

        for (String ops : operations) {
            if (!stack.isEmpty() && ops.equals("C")) {
                stack.pop();
            } else if (!stack.isEmpty() && ops.equals("D")) {
                int pop = stack.pop();
                stack.push(pop);
                stack.push(pop * 2);
            } else if (stack.size() >= 2 && ops.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();

                stack.push(num2);
                stack.push(num1);
                stack.push(num1 + num2);
            } else {
                stack.push(Integer.parseInt(ops));
            }

        }

        int score = 0;

        for (int num : stack) {
            score += num;
        }
        return score;
    }
}
