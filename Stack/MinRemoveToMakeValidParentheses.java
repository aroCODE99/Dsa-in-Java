import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        String s = "))((";
        String validString = minRemoveToMakeValid(s);
        System.out.println(validString);
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
