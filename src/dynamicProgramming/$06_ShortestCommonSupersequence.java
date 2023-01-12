package dynamicProgramming;

import java.util.Arrays;

/**
 * Given two strings, write a function to find the length of their shortest common superstring.
 * a superstring is a string that has both input strings as sub-strings
 *
 * ex) "abcf" and "bdcf" -> "abdcf"
 */
public class $06_ShortestCommonSupersequence {
    public static void main(String[] args) {
        int res = solution("abcf", "bdcf");
        System.out.println(res); // 5
    }

    public static int solution(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i] = new int[s2.length() + 1];
        }

        // populate the first row and column
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = j;
        }

        // populate the rest of the matrix
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                // if characters match, increase the count by 1 from previous min result
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // if characters don't match, smaller number between previous idx of s1 or s2 + 1
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
