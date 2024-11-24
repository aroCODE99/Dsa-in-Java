public class MinInsertionToMakeParenthesisValid {
    public static void main(String[] args) {
        String s = "))())(";
        int minInsertions = minInsertions(s);
        System.out.println(minInsertions);
    }

    public static int minInsertions(String s) {
int openCount = 0;
int insertions = 0;
int i = 0;
while (i < s.length()) {
            char currChar = s.charAt(i);
            if (currChar == '(') {
                // if the curr is '('
                openCount++;
            } else {
                if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
                    // if it is the closing then we check the next one and
                    // insertion++ and skipp if the next is also closing
                    if (openCount > 0) {
                        openCount--;
                    } else {
                        insertions++;
                    }
                    i++; // skipping the next one
                } else {
                    if (openCount > 0) {
                        openCount--;
                        insertions++;
                    } else {
                        // that means we need both opening and closing
                        insertions += 2;
                    }
                }
            }
            i++;
        }
        insertions += openCount * 2;
        return insertions;
    }
}
