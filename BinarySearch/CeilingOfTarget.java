public class CeilingOfTarget {
        public static void main(String[] args) {
                int[] arr = { -18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 48 };
                // int[] arr = { 99, 80, 75, 22, 11, 10, 5, 2, -3 };
                int target = 80;
                int ans = CeilingOfNum(arr, target);
                if (ans != -1) {
                        System.out.printf("Ceiling of target %d is %d", target, arr[ans]);
                } else {
                        System.out.println("Ceiling not found");
                }
        }

        private static int CeilingOfNum(int[] arr, int target) {
                int start = 0;
                int end = arr.length - 1;

                // to check if the array is ascending or descending
                boolean isAsc = arr[start] < arr[end];

                while (start <= end) {
                        int mid = start + (end - start) / 2;

                        if (isAsc) {
                                if (target < arr[mid]) {
                                        end = mid - 1;
                                } else if (arr[mid] == target) {
                                        return mid + 1;
                                } else {
                                        start = mid + 1;
                                }
                        } else {
                                if (target > arr[mid]) {
                                        end = mid - 1;
                                } else if (arr[mid] == target) {
                                        return mid - 1;
                                } else {
                                        start = mid + 1;
                                }
                        }
                }
                return (start < arr.length ? start : -1);
        }
}
