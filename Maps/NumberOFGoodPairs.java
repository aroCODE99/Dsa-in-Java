import java.util.HashMap;
import java.util.Map;

public class NumberOFGoodPairs {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 1, 3 };
        System.out.println(numIdenticalPairsII(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int numIdenticalPairsII(int[] nums) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (mapFreq.containsKey(nums[i])) {
                count += mapFreq.get(nums[i]);
            }
            mapFreq.put(nums[i], mapFreq.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }
}
