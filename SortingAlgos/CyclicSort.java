import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = { 5, 4, 3, 2, 1 };
        sortIt(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortIt(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int cIndex = nums[i] - 1;

            if (cIndex > 0 && cIndex < n && nums[cIndex] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[cIndex];
                nums[cIndex] = temp;
            } else {
                i++;
            }
        }
    }
}
