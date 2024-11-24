import java.util.Stack;

public class ReverseSubstringsBetweenEachParenthesis {
    public static void main(String[] args) {
        String s = "(u(love)i)";
        String ans = reverseParentheses(s);
        System.out.println(ans);
    }

    public static String reverseParentheses(String s) {
        int n = s.length();
        int[] teleport = new int[n]; // Array to store teleport links between parentheses
        Stack<Integer> stack = new Stack<>();

        // First pass to fill in the teleport links
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int openIndex = stack.pop();
                teleport[openIndex] = i;
                teleport[i] = openIndex; // Link both parentheses to each other
            }
        }

        // now we will travel
        StringBuilder res = new StringBuilder();
        int direction = 1;
        int i = 0;

        while (i < n) {
            char currChar = s.charAt(i);
            if (currChar == '(' || currChar == ')') {
                i = teleport[i];
                // change the direction
                direction = -direction;
            } else {
                res.append(currChar);
            }

            i += direction;
        }

        return res.toString();
    }

}
