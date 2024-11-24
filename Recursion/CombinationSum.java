import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> res = new ArrayList<>();
        combinationSumArray(nums, new ArrayList<>(), res, 0, 0, target);
        System.out.println(res);
    }

    private static void combinationSumArray(int[] nums, List<Integer> currList,
            List<List<Integer>> resList, int sum, int i, int target) {
        if (sum == target) {
            resList.add(new ArrayList<>(currList));
            return;
        }

        if (i == nums.length || sum > target) {
            resList.add(new ArrayList<>(currList));
            return;
        }

        currList.add(nums[i]);
        combinationSumArray(nums, currList, resList, sum + nums[i], i, target);
        currList.remove(currList.size() - 1);
        combinationSumArray(nums, currList, resList, sum, i + 1, target);
        // we do not have to remove the sum as that stack level the sum is not added
    }
}
