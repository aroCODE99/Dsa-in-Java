import java.util.ArrayList;
import java.util.Arrays;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        // see we could compare char with numbers
        System.out.println('1' > '0');
        String ans = removeKdigits(num, k);
        System.out.println(ans);
    }

    private static String removeKdigits(String num, int k) {
        int n = num.length();

        if (n == k) {
            return "0";
        }

        ArrayList<Character> stack = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char currChar = num.charAt(i);

            while (stack.size() > 0 && stack.getLast() > currChar && k > 0) {
                stack.removeLast();
                k--;
            }

            if (stack.size() > 0 || currChar != '0') {
                stack.add(currChar);
            }
        }

        // if the number didn't follow the monotonic approach
        while (stack.size() > 0 && k > 0) {
            stack.removeLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
            sb.append(ch);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
