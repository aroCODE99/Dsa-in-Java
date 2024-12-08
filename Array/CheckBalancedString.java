public class CheckBalancedString {
    public static void main(String[] args) {
        String num = "1234";
        System.out.println(isBalanced(num));
    }

    private static boolean isBalanced(String num) {
        int n = num.length();
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < n; i++) {
            // To convert a character that represents a digit ('0' to '9') into its
            // corresponding integer value, you can subtract '0' from it
            int currNum = num.charAt(i) - '0';

            if ((i + 1) % 2 == 0) {
                evenSum += currNum;
            } else {
                oddSum += currNum;
            }
        }

        return oddSum == evenSum;
    }
}
