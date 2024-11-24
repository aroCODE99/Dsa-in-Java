import java.util.PriorityQueue;

public class HeapsIntro {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> a - b);
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(30);
        maxHeap.add(9);

        System.out.println(maxHeap.remove(30));
        System.out.println(maxHeap);
    }
}
