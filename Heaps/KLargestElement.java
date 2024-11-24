import java.util.PriorityQueue;

public class KLargestElement {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 5, 4 };
        int k = 2;
        int topkthfreqelement = FindExceptionn(nums, k);
        System.out.println(topkthfreqelement);
    }

    public static int FindExceptionn(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
