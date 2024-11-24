import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> b - a // Sort in descending order of frequency
        );

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int big = maxHeap.poll();
            int small = maxHeap.poll();
            int newNum = big - small;
            maxHeap.add(newNum);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
