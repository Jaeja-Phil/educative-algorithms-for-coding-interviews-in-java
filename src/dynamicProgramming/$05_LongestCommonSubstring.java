package dynamicProgramming;

import java.util.Arrays;

/**
 * Given two strings, find the length of the longest common substring
 *
 * ex) s1 = "www.educative.io/explore"
 *     s2 = "educative.io/edpresso"
 *     res = 14 ("educative.io/e")
 */
public class $05_LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(solutionBottomUp("www.educative.io/explore", "educative.io/edpresso"));
    }

    public static int solutionTopDown(String s1, String s2) {
        int size1 = s1.length();
        int size2 = s2.length();
        int maxLen = Math.max(size1, size2);
        int[][][] dp = new int[size1][][];
        for (int i = 0; i < size1; i++) {
            dp[i] = new int[size2][];
            for (int j = 0; j < size2; j++) {
                dp[i][j] = new int[maxLen];
                for (int k = 0; k < maxLen; k++) {
                    dp[i][j][k] = -10;
                }
            }
        }

        return solutionTopDownRecursive(dp, s1, s2, 0, 0, 0);
    }

    private static int solutionTopDownRecursive(int[][][] dp, String s1, String s2,
                                                int idx1, int idx2, int count) {
        // base check
        if (idx1 == s1.length() || idx2 == s2.length()) {
            return count;
        }

        // if we have not already processed a similar problem...
        if (dp[idx1][idx2][count] == -10) {
            // c1 is the count of the longest common substring we have seen so far
            int c1 = count;
            // if current characters are the same, increment the count and move to the next character
            if (s1.charAt(idx1) == s2.charAt(idx2)) {
                c1 = solutionTopDownRecursive(dp, s1, s2, idx1 + 1, idx2 + 1, count + 1);
            }

            // start fresh (with count 0) and move to the next character in s1
            int c2 = solutionTopDownRecursive(dp, s1, s2, idx1 + 1, idx2, 0);
            // start fresh (with count 0) and move to the next character in s2
            int c3 = solutionTopDownRecursive(dp, s1, s2, idx1, idx2 + 1, 0);
            dp[idx1][idx2][count] = Math.max(c1, Math.max(c2, c3));
        }

        return dp[idx1][idx2][count];
    }

    public static int solutionBottomUp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][]; // +1 for empty string

        // init
        for (int i = 0; i <= s1.length(); i++) {
            dp[i] = new int[s2.length() + 1];
        }

        int maxLen = 0;
        // filling from bottom up
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                // if current letters are the same
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // add one to the previous longest common substring
                    // which locates at 1 row above and 1 column left
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(dp[i][j], maxLen);
                }
            }
        }

        return maxLen;
    }

}
