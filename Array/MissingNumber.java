import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };

        System.out.println(missingNum(nums));
    }

    private static int missingNum(int[] nums) {
        int n = nums.length;
        // this is the formula of sum of first natural numbers
        int reqSum = n * (n + 1) / 2;
        System.out.println(reqSum);

        int currSum = 0;

        for (int num : nums) {
            currSum += num;
        }

        return reqSum - currSum;
    }
}
//
// 3 0 1 reqSum = 3
// 3 0 1 iss array ka sum = 4
