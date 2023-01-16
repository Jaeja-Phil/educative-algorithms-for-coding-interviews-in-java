package dynamicProgramming;

import java.util.Arrays;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent),
 * write code to calculate the number of ways of representing n cents.
 */
public class $08_CoinChangeProblem {
    public static void main(String[] args) {
        int res = solution(new int[] {1, 5, 10, 25}, 15);
        System.out.println(res); // 13
    }

    public static int solution(int[] denoms, int amount) {
        int denomsLength = denoms.length;
        if (denomsLength == 0 || amount <= 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        // base case, 1 way to make 0 cents
        dp[0] = 1;
        // iterate through coin type one by one
        for (int i = 0; i < denomsLength; i++) {
            // starting from coin's value until target amount...
            for (int j = denoms[i]; j <= amount; j++) {
                // dp[j], number of ways to make j cents
                // dp[j - denoms[i]], number of ways to make current amount - coin's value cents
                // ex) 10 cents --> 10센트를 만들 수 있었던 방법 가짓수 + 5센트로 5센트를 만들 수 있는 가짓수
                dp[j] += dp[j - denoms[i]];
                System.out.println(Arrays.toString(dp));
            }
            System.out.println("--------------------");
        }

        return dp[amount];
    }
}
