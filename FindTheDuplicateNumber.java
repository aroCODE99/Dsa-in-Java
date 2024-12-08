public class FindTheDuplicateNumber {
        public static void main(String[] args) {
                int[] nums = { 1, 2, 4, 5, 3, 2 };
                System.out.println(findDuplicate(nums));
        }

        public static int findDuplicate(int[] nums) {
                int n = nums.length;
                int i = 0;
                while (i < n) {
                        // find correct index
                        int cIndex = nums[i];
                        // swapp with correct index
                        if (cIndex > 0 && cIndex < n && nums[i] != nums[cIndex]) { int temp = nums[i];
                                nums[i] = nums[cIndex];
                                nums[cIndex] = temp;
                        } else {
                                i++;
                        }
                }
                // ek bar sort karne ke baad jo element bach jaata he usko return karde
                for (int j = 0; j < nums.length; j++) {
                        if (nums[j] != j) {
                                return nums[j];
                        }
                }
                return nums.length;
        }
}
