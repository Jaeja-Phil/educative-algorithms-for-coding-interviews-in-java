package dynamicProgramming;

/**
 * A child is running up a staircase with n steps, and can hop
 * either 1, 2, or 3 steps at a time.
 * Implement a function to count the "number of possible ways" that the child can run up the stairs.
 */
public class $03_StaircaseProblem {
    public static void main(String[] args) {
        int res = solution(4);
        System.out.println(res); // 7
    }

    public static int solution(int n) {
        // return early on base cases
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 1];
        // setting up the first 3
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            // the number of ways to reach the current step is the sum of the number of ways to reach the previous 3 steps
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
}
