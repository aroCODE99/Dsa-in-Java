public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 6, 7, 8 };
        int target = 5;
        System.out.println(search(nums, target));
    }

    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
