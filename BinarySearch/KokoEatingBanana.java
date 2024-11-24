import java.util.Arrays;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        long maxSpeed = k(piles, h);
        System.out.println(maxSpeed);
    }

    private static int k(int[] nums, int h) {
        long start = 1;
        long end = Arrays.stream(nums).max().getAsInt();

        while (end >= start) {
            long eatingSpeed = start + (end - start) / 2;
            if (hoursTaken(nums, eatingSpeed) <= h) {
                end = eatingSpeed - 1;
            } else {
                start = eatingSpeed + 1;
            }
        }
        return (int) start;
    }

    private static long hoursTaken(int[] nums, long h) {
        long currHours = 0;
        for (int bananas : nums) {
            currHours += (bananas + h - 1) / h;
        }
        return currHours;
    }
}
