import java.util.HashSet;
import java.util.Set;

public class CheckIfEveryRowAndColHasEveryNum {
    public static void main(String[] args) {
        // this array is validated by doesCOntains as it only checks for rows
        // this array is not-validated by doesContainsRowsAndCols as this checks for
        // both rows and cols
        int[][] arr = {
                { 1, 2, 3 },
                { 2, 3, 1 },
                { 3, 1, 2 }
        };
        System.out.println(doesContainsWithOut1N(arr));
    }

    private static boolean doesContainsWithOut1N(int[][] matrix) {
        int n = matrix.length;
        Set<Integer> expectedSet = new HashSet<>();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                expectedSet.add(matrix[i][j]);
            }
        }

        System.out.println(expectedSet);

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < matrix[0].length; j++) {
                rowSet.add(matrix[i][j]);
                // learn why the ulta i and j gives us the col
                colSet.add(matrix[j][i]);
            }
            // check if any of them is not true return false (rowSet and colSet)
            if (!rowSet.equals(expectedSet) || !colSet.equals(expectedSet)) {
                return false;
            }
        }

        return true;

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
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < nums[0].length; j++) {
                int currNum = nums[i][j];
                rowSet.add(currNum);
            }
            if (!rowSet.equals(expectedSet)) {
                return false;
            }
        }

        return true;
    }

    private static boolean doesContainsRowsAndCols(int[][] matrix) {
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
            // check if any of them is not true return false (rowSet and colSet)
            if (!rowSet.equals(expectedNums) || !colSet.equals(expectedNums)) {
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
// but the real question was to validate the rows and cols from [1 - n]
//
// now lets look at why ulta i,j gives us the col
//
// {1 ,2 ,3 },
// {2 ,3 ,1 },
// {3 ,1 ,2 }
//
// why does i and j gives us row ?
// -> because row is fix
// but why does j and i gives us col ?
// -> because rows keeps moving and col is being static
//
//
//
// now how will i do it if 1 - n was not given
// i could take the first row and put it in set
//
//
// 1st question can be of only checking if the all rows of matrix are same
// that'll be simple
