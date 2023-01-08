package dynamicProgramming;

import java.util.Arrays;

public class $01_Fibonacci {
    public static void main(String[] args) {
        int result = fibonacciUsingRecursion(10);
        System.out.println(result); // 55

        // create int[] of 11 elements and fill it with -1
        // why 11?: fib(10) would be stored at 10th index, so we need an array of size 11
        int[] memo = new int[11];
        Arrays.fill(memo, -1);
        result = fibonacciUsingMemoization(10, memo);
        System.out.println(result); // 55
    }

    public static int fibonacciUsingRecursion(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacciUsingRecursion(n - 1) + fibonacciUsingRecursion(n - 2);
    }

    public static int fibonacciUsingMemoization(int n, int[] memo) {
        if (memo[n] == -1) { // check if already computed
            // if not already computed, compute and store in memo
            // base case
            if (n <= 1) {
                memo[n] = n;
                // fill nth memo with recursively calculated n - 1 and n - 2 case
            } else {
                memo[n] = fibonacciUsingMemoization(n - 1, memo) + fibonacciUsingMemoization(n - 2, memo);
            }
        }

        // return nth memo
        return memo[n];
    }

    public static int fibonacciUsingDP(int n) {
        int[] dp = new int[n + 1];

        // set base cases
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * note, only the last 2 elements are needed from dp
     */
    public static int fibonacciUsingDPImproved(int n) {
        if (n <= 1) {
            return n;
        }

        int secondLast = 0;
        int last = 1;

        for (int i = 2; i <= n; i++) {
            int current = secondLast + last;
            secondLast = last;
            last = current;
        }

        return last;
    }
}
