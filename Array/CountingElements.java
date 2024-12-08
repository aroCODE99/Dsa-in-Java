import java.util.HashSet;
import java.util.Set;

public class CountingElements {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 4, 5, 1, 3 };
        int ans = countElements(nums);
        System.out.println(ans);
    }

    private static int countElements(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            seen.add(num);
        }

        for (int num : nums) {
            if (seen.contains(num + 1)) {
                count += 1;
            }
        }
        return count;
    }
}
// The problem provides an integer array called arr. We are asked to count the
// number of elements, x, in this array such that there exists another element
// in the array which is exactly one more than x (that is, x + 1). If there are
// multiple instances of the same value in arr, each occurrence should be
// considered separately for our count.

// An example to illustrate the problem could be if we have the array [1, 2, 3].
// Here, the element 1 has a companion 2, and 2 has a companion 3. Thus, we have
// two elements (1 and 2) that meet the condition, so our result would be 2.
