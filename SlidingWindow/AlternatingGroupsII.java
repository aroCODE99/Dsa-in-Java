import java.util.Arrays;

public class AlternatingGroupsII {
    public static void main(String[] args) {
        int[] colors = { 1, 1, 0, 1 };
        int k = 4;
        System.out.println(numberOfAlternatingGroups(colors, k));
    }

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        if (colors.length < k) {
            return 0;
        }

        int n = colors.length;
        int countOfGroups = 0;
        int windowLen = 1;

        int[] extendedColors = new int[n + k - 1];
        System.arraycopy(colors, 0, extendedColors, 0, n);
        System.arraycopy(colors, 0, extendedColors, n, k - 1);

        for (int i = 1; i < extendedColors.length; i++) {
            if (extendedColors[i - 1] != extendedColors[i]) {
                windowLen += 1;
            } else {
                windowLen = 1;
            }

            if (windowLen >= k) {
                countOfGroups++;
            }

        }

        return countOfGroups;
    }
}
