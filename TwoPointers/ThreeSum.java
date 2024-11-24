import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            threeSumHelper(nums, i, res);
        }
        return res;
    }

    private static void threeSumHelper(int[] nums, int i, List<List<Integer>> res) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            int currSumm = nums[i] + nums[j] + nums[k];
            if (currSumm == 0) {
                List<Integer> currRes = new ArrayList<>();
                currRes.addAll(List.of(nums[i], nums[j], nums[k]));
                res.add(currRes);
                while (j < k && nums[j] != nums[j + 1]) {
                    j++;
                }
                while (j < k && nums[k] != nums[k - 1]) {
                    k++;
                }
                j++;
                k++;
            }
            if (currSumm < 0) {
                j++;
            } else {
                k--;
            }
        }
    }
}
