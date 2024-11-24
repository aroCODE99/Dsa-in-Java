import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {
    public static void main(String[] args) {
        String text = "MaximumNumberOfballonos";
        int maxNumOfBalloons = maxnumberofballoons(text);
        System.out.println(maxNumOfBalloons);
    }

    public static int maxnumberofballoons(String text) {
        int[] freq = new int[26];
        for (char c : text.toCharArray())
            freq[c - 'a']++;

        String target = "balloon";
        int minCount = Integer.MAX_VALUE;
        for (char c : target.toCharArray()) {
            if (c == 'o' || c == 'l')
                minCount = Math.min(minCount, freq[c - 'a'] / 2);
            else
                minCount = Math.min(minCount, freq[c - 'a']);
        }
        return minCount;
    }
}
