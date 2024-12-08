import java.util.Arrays;

public class MoveTheZeros {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeros(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;

        while (r < n) {
            int currNum = nums[r];
            if (currNum != 0) {
                nums[r] = nums[l];
                nums[l++] = currNum;
            }

            r++;
        }
    }
}

// 1,0,0,3,12
// it also has the negative numbers
