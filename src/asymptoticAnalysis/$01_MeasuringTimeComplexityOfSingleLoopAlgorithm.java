package asymptoticAnalysis;

public class $01_MeasuringTimeComplexityOfSingleLoopAlgorithm {
    public static void main(String[] args) {
        /**
         * variable initialization, each accounts for 1 primitive operation
         * = 2
         */
        int n = 10;
        int sum = 0;


        /**
         * initialization occurs once
         * increment (i++) reads the value of i, adds 1 to it, and writes the result back to i
         * - this is 3 primitive operations
         * - the increment is executed n times
         * test operation (i < n) read current value of i and n and compares them
         * - this is also 3 primitive operations
         *
         * in total
         * - 1 for initialization of i
         * - 3(n + 1) for i < n operation
         *   - n + 1 because i is incremented n times and the test is performed once more
         * - 3n for sum += i operation (read, add, write)
         * - 3n for i++ operation
         * = 9n + 4
         */
        for (int i = 0; i < n; i++) {
            sum += i;
        }

        /**
         * accessing sum accounts for 1 primitive operation
         * displaying to console also accounts for 1 primitive operation
         * = 2
         */
        System.out.println(sum);

        /**
         * TOTAL:
         * - 9n + 8 time complexity
         */
    }
}
