package dynamicProgramming;

/**
 * Given an array of integers, write a function to find if any two subsets of the input array
 * exist such that the sum of both subset is equal
 *
 * array will only consist of positive integers
 *
 * ex) [1, 2, 3, 4] -> true (1 + 4 = 2 + 3)
 */
public class $04_PartitionProblem {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        boolean res = solutionTopDown(arr);
        System.out.println(res);
    }

    public static boolean solutionTopDown(int[] arr) {
        int arrLength = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        // if sum is odd, we can't have two subsets with equal sum
        if (sum % 2 == 1) {
            return false;
        }

        int[][] dp = new int[arrLength][];
        for (int i = 0; i < arrLength; i++) {
            dp[i] = new int[sum / 2 + 1];
            for (int j = 0; j < sum / 2 + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return solutionTopDownRecursive(dp, arr, sum / 2, 0) == 1;
    }

    private static int solutionTopDownRecursive(int[][] dp, int[] arr, int sum, int currIdx) {
        int arrLength = arr.length;

        // base check
        if (sum == 0) { // found matching subset
            return 1;
        }
        if (arrLength == 0 || currIdx >= arrLength) { // no matching subset
            return 0;
        }

        // if we have not already processed a similar problem
        if (dp[currIdx][sum] == -1) {
            // recursive call after choosing the number at the current index
            // if number at currIdx/exceeds the sum, we shouldn't process this
            if (arr[currIdx] <= sum) {
                // == 1 means either
                // - sum reached 0
                // - return of dp[currIdx + 1][sum - arr[currIdx]] == 1
                // both meaning found a matching subset
                if (solutionTopDownRecursive(dp, arr, sum - arr[currIdx], currIdx + 1) == 1) {
                    dp[currIdx][sum] = 1;
                    return 1;
                }
            }
            // recursive call after excluding number at currIdx
            dp[currIdx][sum] = solutionTopDownRecursive(dp, arr, sum, currIdx + 1);
        }

        return dp[currIdx][sum];
    }

    public static boolean solutionBottomUp(int[] num) {
        int n = num.length;
        int sum = 0;
        // find total sum
        for (int i : num) {
            sum += i;
        }

        // if sum is odd, can't find two subsets with equal sum
        if (sum % 2 == 1) {
            return false;
        }

        sum /= 2;
        boolean[][] dp = new boolean[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new boolean[sum + 1];
        }

        // populate the sum=0 columns, as we can always have '0' sum without including any element
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // process all subsets for all sums
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                // if we can get the sum 's' without the number at index 'i'
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= num[i]) {
                    // else include the number and see if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i - 1][s - num[i]];
                }
            }
        }

        // return the bottom-right corner value
        return dp[n - 1][sum];
    }
}
