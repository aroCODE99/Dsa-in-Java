public class PowFunction {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        // if n is neqative it become 1 / x^n
        if (n < 0) {
            return 1 / BitPow(x, -n);
        }
        return BitPow(x, n);
    }

    private static double BitPow(double x, int n) {
        if (n == 0)
            return 1;

        double half = BitPow(x, n >>> 1);

        if ((n & 1) == 0) {
            // if n is even we do half * half
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
