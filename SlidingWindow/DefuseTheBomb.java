import java.util.Arrays;

public class DefuseTheBomb {
    public static void main(String[] args) {
        int[] code = { 10, 5, 7, 7, 3, 2, 10, 3, 6, 9, 1, 6 };
        int n = code.length;
        int k = -4;
        int[] decryptedCode = decrypt(code, k);
        System.out.println(Arrays.toString(decryptedCode));
    }

    public static int[] decrypt(int[] code, int k) {
        int[] decryptCode = new int[code.length];
        if (k > 0) {
            decryptPostive(code, k, decryptCode);
        } else if (k < 0) {
            decryptNegative(code, -k, decryptCode); // Convert to positive for easier handling
        }
        return decryptCode;
    }

    static int helperSumFunc(int[] code, int start, int end) {
        int sum = 0;
        if (start < end) {
            for (int i = start; i < end; i++) {
                sum += code[i % code.length]; // Use modulo for wrapping
            }
        } else {
            // Sum from start to end of the array
            for (int i = start; i < code.length; i++) {
                sum += code[i];
            }
            // Sum from beginning of the array to end index
            for (int i = 0; i < end; i++) {
                sum += code[i];
            }
        }
        return sum;
    }

    public static void decryptPostive(int[] code, int k, int[] decryptCode) {
        int n = code.length;
        for (int i = 0; i < n; i++) {
            int start = (i + 1) % n; // Start from the next index
            int end = (start + k) % n; // Calculate the end index
            decryptCode[i] = helperSumFunc(code, start, end);
        }
    }

    private static void decryptNegative(int[] code, int k, int[] decryptCode) {
        int n = code.length;
        for (int i = 0; i < n; i++) {
            int start = (i + n - k) % n; // Start from the next index
            int end = (start + k) % n; // Calculate the end index
            decryptCode[i] = helperSumFunc(code, start, end);
        }
    }
}
