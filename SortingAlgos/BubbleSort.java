import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = { 5, 4, 3, 2, 1 };
        sortIt(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortIt(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    // Swap if elements are out of order
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    isSwapped = true; // Mark as swapped
                }
            }

            System.out.println(Arrays.toString(nums));
            if (!isSwapped) {
                break;
            }
        }
    }
}

// you take the currNum and leave it to currect index by checking the currNum
// being the larger than adjacent num
