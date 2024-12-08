public class FindTargetInRotatedArr {
        public static void main(String[] args) {
                int[] nums = { 1, 0, 1, 1, 1 };
                int target = 0;
                System.out.println(search(nums, target));
        }

        private static boolean search(int[] nums, int target) {
                int start = 0;
                int end = nums.length - 1;

                while (end >= start) {
                        int mid = start + (end - start) / 2;

                        if (nums[mid] == target) {
                                return true;
                        } else if (nums[start] < nums[mid]) {
                                if (nums[start] <= target && target < nums[mid]) {
                                        end = mid - 1;
                                } else {
                                        start = mid + 1;
                                }
                        } else if (nums[mid] < nums[start]) {
                                if (nums[mid] < target && target <= nums[end]) {
                                        start = mid + 1;
                                } else {
                                        end = mid - 1;
                                }
                        } else {
                                start++;
                        }
                }
                return false;
        }
}
