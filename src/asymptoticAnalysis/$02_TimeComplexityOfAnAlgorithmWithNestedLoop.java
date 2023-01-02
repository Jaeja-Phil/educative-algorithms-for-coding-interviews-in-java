package asymptoticAnalysis;

public class $02_TimeComplexityOfAnAlgorithmWithNestedLoop {
    public static void main(String[] args) {
        int n = 5; // 1 step
        int m = 7; // 1 step
        int sum = 0; // 1 step
        /**
         * total of 3 operations
         */

        /**
         * - outer i initialization accounts for 1 operation
         * - outer i++ operation must read, increment, and write the value of i
         *   - 3n operations
         * - outer i < n operation must read the value of i and n and compare
         *   - 3n + 1 operations (+1 because of last i < n == false comparison)
         * = total of 6n + 4 operations
         */
        for (int i = 0; i < n; i++) {
            /**
             * same as outer loop, but with j
             * - initialization takes place n times tho
             * - j < m operation must read two and compare
             *   - n(3(m + 1)) operations
             * - sum++ operation must read, increment, and write the value of sum
             *   - 3nm operations
             * - j++ operation must read, increment, and write the value of j
             *   - 3nm operations
             */
            for (int j = 0; j < m; j++) {
                sum++;
            }
        }

        /**
         * reading and printing out to the console, 2 operations
         */
        System.out.println("Sum: " + sum);

        /**
         * TOTAL
         * - 3 for n, m, and sum initialization
         * - 6n + 4 for outer loop
         * - 6nm + n(3(m + 1)) + n for inner loop
         *   - 9nm + 4n
         * - 2 for printing out to the console
         * = 3 + 6n + 4 + 9nm + 4n + 2
         * = 9nm + 10n + 9
         */
    }
}
