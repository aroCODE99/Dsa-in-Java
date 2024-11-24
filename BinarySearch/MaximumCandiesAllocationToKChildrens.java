import java.util.Arrays;

public class MaximumCandiesAllocationToKChildrens {
    public static void main(String[] args) {
        int[] candies = { 5, 8, 6 };
        int k = 2;
        System.out.println(maxCandies(candies, k));
    }

    private static int maxCandies(int[] candies, long k) {
        int start = 1;
        int end = Arrays.stream(candies).max().getAsInt();

        // Perform a binary search to find the largest possible pile size.
        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (canAllocate(candies, mid, k)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    private static boolean canAllocate(int[] candies, int mid, long k) {
        long canDivideInto = 0;
        for (int i = 0; i < candies.length; i++) {
            canDivideInto += candies[i] / mid;
        }
        return canDivideInto >= k;
    }
}
