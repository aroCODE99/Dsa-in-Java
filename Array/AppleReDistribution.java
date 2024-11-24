import java.util.Arrays;

public class AppleReDistribution {
    public static void main(String[] args) {
        int[] apple = { 1, 3, 2 };
        int[] capacity = { 4, 3, 1, 5, 2 };
        System.out.println(minimumBoxes(apple, capacity));
    }

    public static int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalApples = 0;
        for (int i = 0; i < apple.length; i++) {
            totalApples += apple[i];
        }

        int numOfBoxesReq = 0;
        for (int i = capacity.length - 1; i >= 0 && totalApples > 0; i--) {
            totalApples -= capacity[i];
            numOfBoxesReq++;
        }

        return numOfBoxesReq;
    }
}
