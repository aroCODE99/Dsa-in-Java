public class TargetSum {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        int ways = findSumWays(nums, target, 0, 0);
        System.out.println(ways);
    }

    private static int findSumWays(int[] nums, int target, int i, int currSum) {
        if (i == nums.length) {
            return currSum == target ? 1 : 0;
        }

        int count = 0;
        count += findSumWays(nums, target, i + 1, currSum + nums[i]);
        count += findSumWays(nums, target, i + 1, currSum - nums[i]);

        return count;
    }
}

// now how this is working let's see
//
// 1 1 1 1 1
// we got 5 one (we only have array of one's) ;
// so with we have to build expression of each element's in the array which is
// very important
//
// target 3.
// -1 + 1 + 1 + 1 + 1 = 3
// +1 - 1 + 1 + 1 + 1 = 3
// +1 + 1 - 1 + 1 + 1 = 3
// +1 + 1 + 1 - 1 + 1 = 3
// +1 + 1 + 1 + 1 - 1 = 3
//
// so thie is what we have to do
//
// so at first we just add add add and add all elements
// count+=findSumWays(nums,target,i+1,currSum+nums[i]);
//
// and then after going into the base case
// we return 1 only if currSum == target
// if(i==nums.length){
// return currSum==target ? 1 : 0;
// }
//
// and then adding all it goes into next call to subtraction
// count+=findSumWays(nums,target,i+1,currSum-nums[i]);
