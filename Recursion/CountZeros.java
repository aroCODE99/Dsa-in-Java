public class CountZeros {
    public static void main(String[] args) {
        int num = 302020;
        int countNumOfZeros = countNumOfZerosII(num);
        System.out.println(countNumOfZeros);
    }

    private static int countNumOfZeros(int num, int count) {
        // base case if the num is diminished we return the count
        if (num == 0) {
            return count;
        }

        // if the curr num is zero we increment the count
        if (num % 10 == 0) {
            count += 1;
        }

        return countNumOfZeros(num / 10, count);
    }

    private static int countNumOfZerosII(int num) {
        int countOfZeros = 0;

        // base case if the num is diminished we return the count
        if (num == 0) {
            return countOfZeros;
        }

        // if the curr num is zero we increment the count
        if (num % 10 == 0) {
            countOfZeros += 1;
        }

        countOfZeros += countNumOfZerosII(num / 10);

        return countOfZeros;
    }
}

// working of countNumOfZerosII this function
//
//
// 3020 this is the num that we need to count lets suppose
//
// function - 1 (count-1)
// the currnum i.e num % 10 is 0
// if (num % 10 == 0) countOfZeros += 1
//
// at function one the count is been 1
//
// function - 2 (count-0)
// the currnum i.e num % 10 is 2
// at this function the count is going to be the 0
// countOfZeros+=countNumOfZerosII(num/10);
// function 2 just calls another function i.e function-3
//
// function-3 (count-1)
//
// the currnum i.e num % 10 is 0
// if (num % 10 == 0) countOfZeros += 1
//
// function-4 (count-0)
// at this function theres nothing i mean curr num is 3 which is not zero so
// same thing
// function 4 just calls another function i.e function-5 which has the currNum
// to be 0
// thats our base-case
//
//
// function-1 (count-1)
// function-2 (count-0)
// function-3 (count-1)
// function-4 (count-0)
// function-5 (count-0)
//
//
//
// so now when the function 5 returns the count (which is 0 btw) to function 4
//
// function 4 also has the currCount to be 0 so function 5 count + function 4
// count is going to be (0 + 0) = 0
// now function 4 returns that whole count to function 3
//
// now function 3 has the count 1
// now function 3 has total-count to be (0 + 1) = 1
// this function so (hopeully you are understanding the pattern in this
// function-calls)
//
// now as this returns to the function-1 this has the total-count to be 2
