import java.util.function.Function;

public class AlternatingGroupsI {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1 };
        System.out.println(numberOfAlternatingGroups(nums));
    }

    public static int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length, alternatingGroups = 0;
        for (int i = 0; i < colors.length; i++) {
            int prev = (i - 1 + n) % n;
            int next = (i + 1) % n;

            if (colors[i] != colors[prev] && colors[i] != colors[next] && colors[prev] == colors[next]) {
                alternatingGroups++;
            }
        }
        return alternatingGroups;
    }
}
