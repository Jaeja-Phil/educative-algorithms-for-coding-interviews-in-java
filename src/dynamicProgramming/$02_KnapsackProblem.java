package dynamicProgramming;

import java.util.Arrays;

/**
 * Given 2 integer arrays that represent the weights and profits of N items,
 * implement a function that finds a subset of these items that gives us
 * max profit whout their cumulative weight exceeding a given capacity.
 *
 * each item can only be selected once
 */
public class $02_KnapsackProblem {
    public static void main(String[] args) {
        int[] profit = {1, 6, 10, 16};
        int[] weight = {1, 2, 3, 5};
        int capacity = 7;
        int res = knapsackTopDown(profit, weight, capacity);
        System.out.println(res);
    }

    public static int knapsackTopDown(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][];

        for (int i = 0; i < profits.length; i++) {
            dp[i] = new int[capacity + 1];
            for (int j = 0; j < capacity + 1; j++) {
                dp[i][j] = 0;
            }
        }
        return knapsackTopDownRecursive(dp, profits, profits.length, weights, weights.length, capacity, 0);
    }

    private static int knapsackTopDownRecursive(int[][] dp, int[] profits, int profitsLength,
                                         int[] weights, int weightsLength,
                                         int capacity, int currIdx) {
        // base check
        if (capacity <= 0 || currIdx >= profitsLength || currIdx < 0 || weightsLength != profitsLength) {
            return 0;
        }

        // if already solved the problem, return result from table
        if (dp[currIdx][capacity] != 0) {
            return dp[currIdx][capacity];
        }

        // recursive call after choosing the element at the current index
        // if the weight of the element at current index exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if (weights[currIdx] <= capacity) {
            profit1 = profits[currIdx] + knapsackTopDownRecursive(dp, profits, profitsLength, weights, weightsLength, capacity - weights[currIdx], currIdx + 1);
        }

        // recursive call after excluding element at current index
        int profit2 = knapsackTopDownRecursive(dp, profits, profitsLength, weights, weightsLength, capacity, currIdx + 1);
        dp[currIdx][capacity] = Math.max(profit1, profit2);

        return dp[currIdx][capacity];
    }

    public static int knapsackBottomUp(int[] profits, int profitsLength, int[] weights, int weightsLength, int capacity) {
        // base check
        if (capacity <= 0 || profitsLength == 0 || profitsLength != weightsLength) {
            return 0;
        }

        int[][] dp = new int[profitsLength + 1][capacity + 1];

        // build table in bottom-up manner
        for (int i = 0; i <= profitsLength; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    // fill the first row and first column with 0
                    dp[i][j] = 0;
                } else if (weights[i - 1] <= j) { // check if current weight is less than or equal to capacity
                    // fill dp table with max profit between
                    // 1. profit of current item + profit of remaining capacity
                    // 2. profit excluding current item
                    dp[i][j] = Math.max(profits[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    // since current weight is more than capacity, exclude current item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[profitsLength][capacity];
    }

}
