import java.util.Stack;

public class MinRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        // First pass to find unmatched ')'
        for (int i = 0; i < sb.length(); i++) {
            char currChar = sb.charAt(i);
            if (currChar == '(') {
                stack.push(i); // Track '(' positions in sb
            } else if (currChar == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // Valid pair found, keep ')'
                } else {
                    sb.deleteCharAt(i); // Unmatched ')', remove it
                    i--; // Adjust index after deletion
                }
            }
        }

        // Second pass: Remove unmatched '(' by deleting indices stored in the stack
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }
}

// String s = "lee(t(c)o)de)";
//
// "lee(t(c)o)de)"
//
//
// if (s.charAt('(')) stack.push(currChar);
// else {
// if (s.charAt(')')) stack.pop();
// else
// }
