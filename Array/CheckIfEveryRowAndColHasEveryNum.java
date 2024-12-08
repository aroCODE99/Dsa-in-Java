import java.util.HashSet;
import java.util.Set;

public class CheckIfEveryRowAndColHasEveryNum {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3 },
                { 2, 3, 1 },
                { 3, 1, 2 }
        };
        System.out.println(doesContainsRowsAndCols(arr));
    }

    private static boolean doesContains(int[][] nums) {
        // this approach only checks if for rows
        // numbers are expected to be till 1 to n
        int n = nums.length;
        Set<Integer> expectedSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            expectedSet.add(i);
        }

        System.out.println(expectedSet);

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> currSet = new HashSet<>();
            for (int j = 0; j < nums[0].length; j++) {
                int currNum = nums[i][j];
                currSet.add(currNum);
            }
            if (!currSet.equals(expectedSet)) {
                return false;
            }
        }

        return true;
    }

    private static boolean doesContainsRowsAndCols(int[][] matrix) {
        // n for nums to (1 -> n)
        int n = matrix.length;
        // this is the expectedNums i.e 1 - n
        Set<Integer> expectedNums = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            expectedNums.add(i);
        }

        System.out.println(expectedNums);
        // now we are going to fill the rowSet and colset

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < matrix[0].length; j++) {
                // now we need to fill these sets out
                rowSet.add(matrix[i][j]);
                // learn why the ulta i and j gives us the col
                colSet.add(matrix[j][i]);
            }
            if (!rowSet.equals(expectedNums) && !colSet.equals(expectedNums)) {
                return false;
            }
        }
        return true;
    }
}

//
//
// Now i did understand the question
// its stating that validate that whole rows and col contains the num from 1 to
// n (n being the matrix.length)
//
// now how will we solve this question
//
// {1,2,3},
// {2,3,1},
// {3,1,2}
//
//
//
// now lets look at why ulta i,j gives us the col
