import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindThePowerOfK {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 3, 2, 5 };
        int k = 3;
        int[] res = resultsArray(nums, k);
        System.out.println(Arrays.toString(res));
    }

    private static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int count = 1;

        for (int end = 0; end < n; end++) {
            // Increment count if current and previous elements are consecutive
            if (end > 0 && nums[end - 1] + 1 == nums[end]) {
                count++;
            }

            // Console.log("ehasda") this just seem fun to me at that tmie 
            // Maintain the sliding window size
            if (end - start + 1 > k) {
                // Decrement count if the element leaving the window breaks a sequence
                if (start + 1 < n && nums[start] + 1 == nums[start + 1]) {
                    count--;
                }
                start++;
            }

            // Check if the current window size is k
            if (end - start + 1 == k) {
                // Add the result based on whether the window contains a full sequence
                if (count == k) { // For k elements, k-1 transitions make a sequence
                    res.add(nums[end]);
                } else {
                    res.add(-1);
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
