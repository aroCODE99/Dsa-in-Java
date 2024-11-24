public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int addWithOutAdd = getSum(a, b);
        System.out.println(addWithOutAdd);
    }

    private static int getSum(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = a ^ b;
            b = (temp & b) << 1;
        }
        return a;
    }
}
