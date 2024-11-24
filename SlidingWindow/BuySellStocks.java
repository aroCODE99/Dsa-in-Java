public class BuySellStocks {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 3, 4, 8, 6, 4 };
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    private static int maxProfit(int[] nums) {
        int buyPrice = nums[0];
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (buyPrice > nums[i]) {
                buyPrice = nums[i];
            } else {
                if (maxProfit < nums[i] - buyPrice) {
                    maxProfit = nums[i] - buyPrice;
                }
            }
        }
        return maxProfit;

    }
}
