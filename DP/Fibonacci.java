import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static Map<Integer, Integer> memo;

    public static void main(String[] args) {
        memo = new HashMap<>();
        memo.put(0, 0);
        memo.put(1, 1);

        int num = 9;
        int fiboOfNum = Fibo(num);
        System.out.println(fiboOfNum);
    }

   private static int Fibo(int num) {
        if (num < 2) {
            return num;
        }

        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        memo.put(num, Fibo(num - 1) + Fibo(num - 2));

        return memo.get(num);
    }

}
