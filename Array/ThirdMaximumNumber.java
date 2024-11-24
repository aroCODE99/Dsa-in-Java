import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 4, 5 };
        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        List<Integer> seen = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (!seen.contains(num)) {
                seen.add(num);
                if (seen.size() >= 3) {
                    break;
                }
            }
        }
        return seen.size() < 3 ? seen.getFirst() : seen.getLast();
    }
}
