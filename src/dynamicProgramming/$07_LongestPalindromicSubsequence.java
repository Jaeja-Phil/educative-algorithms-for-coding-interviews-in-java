package dynamicProgramming;

import java.util.Arrays;

public class $07_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        int res = solution("abdbca");
        System.out.println(res); // 5, "abdba"
    }

    public static int solution(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // populate the diagonal with 1s as every sequence with one element is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // start with second last letter (since last letter itself will be a palindrome of length 1)
        // iterate and move left pointer
        for (int left = n - 1; left >= 0; left--) {
            // iterate and move right pointer
            for (int right = left + 1; right < n; right++) {
                // elements at the beginning and end are the same
                if (s.charAt(left) == s.charAt(right)) {
                    // 2 + length of last best result
                    dp[left][right] = 2 + dp[left + 1][right - 1];
                } else {
                    // skip one element from either left or right and take the best result
                    dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }


}
