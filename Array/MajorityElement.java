public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = { 8, 8, 7, 7, 7 };
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int currMajor = nums[0];
        int countOfCurrMaj = 0;

        for (int num : nums) {
            if (countOfCurrMaj == 0) {
                currMajor = num;
            }
            if (num == currMajor) {
                countOfCurrMaj -= 1;
            } else {
                countOfCurrMaj += 1;
            }
        }
        return currMajor;
    }
}
