import java.util.Stack;

public class RemoveDuplicateAdjacents {
    public static void main(String[] args) {
        String s = "abbaca";
        String uniques = removeDuplicates(s);
        System.out.println(uniques);
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
                stack.push(ch);
            }
        }
        return sb.toString();
    }
}
