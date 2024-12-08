public class BalancedParenthesis {
    public static void main(String[] args) {
        String s = "))())(";
        int minInsertions = minInsertions(s);
        System.out.println(minInsertions);
    }

    public static int minInsertions(String s) {
        int openCount = 0;
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '(') {
                openCount++;
            } else {
                if (i < s.length() - 1 && currChar == s.charAt(i + 1)) {
                    if (openCount > 0) {
                        openCount--;
                    } else {
                        insertions += 1;
                    }
                    i++;
                } else {
                    if (openCount > 0) {
                        openCount--;
                        insertions++;
                    } else {
                        insertions += 2;
                    }
                }
            }
        }

        insertions += openCount * 2;
        return insertions;
    }
}
