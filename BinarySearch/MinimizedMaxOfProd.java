public class MinimizedMaxOfProd {
    public static void main(String[] args) {
        int n = 6;
        int[] quantities = { 11, 6 };
        int ans = minimizedMaximum(n, quantities);
        System.out.println(ans);
    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int start = 1;
        int end = 0;
        for (int i = 0; i < quantities.length; i++) {
            end = Math.max(end, quantities[i]);
        }
        while (end >= start) {
            int mid = start + (end - start) / 2;
            int canDistribute = canDistribute(n, quantities, mid);
            if (canDistribute <= n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int canDistribute(int n, int[] quantities, int k) {
        int distStroreCount = 0;
        for (int product : quantities) {
            distStroreCount += (product + k - 1) / k;
        }
        return distStroreCount;
    }
}
