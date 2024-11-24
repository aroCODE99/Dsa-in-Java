public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 2, 3, 4, 5, 6, 7, 4, 6, 7 };
        int singleNumber = uniqueNumber(nums);
        System.out.println(singleNumber);
    }

    private static int uniqueNumber(int[] nums) {
        int uniqueNum = 0;
        for (int num : nums) {
            uniqueNum ^= num;
        }
        return uniqueNum;
    }
}
