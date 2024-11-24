import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = { 0, 2, 3, 1, 4, 5, 6 };
        boolean containsDuplicate = containsDuplicate(nums);
        System.out.println(containsDuplicate);
    }

    private static boolean containsDuplicates(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            } else {
                seen.add(num);
            }
        }
        return false;
    }
}
