public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int ans = lengthOfLastWord(s);

        System.out.println(ans);
    }

    private static int lengthOfLastWord(String s) {
        s = s.strip();
        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currChar = s.charAt(i);
            if (currChar == ' ') {
                break;
            }
            length++;
        }

        return length;
    }
}
