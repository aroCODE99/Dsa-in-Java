import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = { 38, 27, 43, 3, 9, 82, 10 };
        mergeSort(nums, 0, nums.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            // Find the middle point
            int mid = start + (end - start) / 2;

            // Recursively sort the first and second halves
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);

            // Merge the sorted halves
            merge(nums, start, mid, end);
        }
    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = nums[start + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = nums[mid + 1 + i];
        }

        // Merge the temporary arrays back into nums[start..end]
        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements of leftArray[], if any
        while (i < n1) {
            nums[k++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray[], if any
        while (j < n2) {
            nums[k++] = rightArray[j++];
        }
    }
}
