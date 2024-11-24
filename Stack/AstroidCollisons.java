import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AstroidCollisons {
    public static void main(String[] args) {
        int[] astroids = { -2, 1, -1, -2 };
        int[] res = asteroidCollision(astroids);
        System.out.println(Arrays.toString(res));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        List<Integer> stack = new ArrayList<>();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            boolean destroyed = false;
            while (!stack.isEmpty() && stack.getLast() > 0 && asteroids[i] < 0) {
                int top = Math.abs(asteroids[i]);
                if (stack.getLast() < top) {
                    stack.removeLast();
                } else if (stack.getLast() == top) {
                    stack.removeLast();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) {
                stack.add(asteroids[i]);
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
