import java.util.Arrays;

public class SortTheColors {
    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int low = 0, current = 0, high = nums.length - 1;

        while (current <= high) {
            if (nums[current] == 0) {
                // Swap nums[current] and nums[low]
                int temp = nums[low];
                nums[low] = nums[current];
                nums[current] = temp;

                low++;
                current++;
            } else if (nums[current] == 2) {
                // Swap nums[current] and nums[high]
                int temp = nums[high];
                nums[high] = nums[current];
                nums[current] = temp;

                high--;
            } else {
                // nums[current] == 1
                current++;
            }
        }
    }
}

//
// i am thinking more of bubble sort but let's think little differently
//
// so we have {0, 1, 2}
//
// 1 0 2
//
// when the high num is at low i.e 2 at low
// we swapp it with the high num
