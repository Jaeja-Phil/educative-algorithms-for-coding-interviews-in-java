package dynamicProgramming;

/**
 * Given 3 strings m, n, and p, write a function to find out if p has been formed by interleaving m and n.
 * p is considered interleaved of m and n if it contains all the letters from m and n
 * with the order of the letters preserved
 */
public class $10_StringsInterleaving {
    public static void main(String[] args) {
        String m = "abc";
        String n = "def";
        String p = "abcdef";
        boolean res = solution(m, n, p);
        System.out.println(res); // true
    }

    public static boolean solution(String m, String n, String p) {
        int mLen = m.length();
        int nLen = n.length();

        boolean[][] dp = new boolean[mLen + 1][nLen + 1];

        for (int mIdx = 0; mIdx <= mLen; mIdx++) {
            for (int nIdx = 0; nIdx <= nLen; nIdx++) {
                // base case, when m and n are empty
                if (mIdx == 0 && nIdx == 0) {
                    dp[mIdx][nIdx] = true;
                }
                // if m is empty, check interleaving with n only
                else if (mIdx == 0 && n.charAt(nIdx - 1) == p.charAt(nIdx - 1)) {
                    dp[mIdx][nIdx] = dp[mIdx][nIdx - 1];
                }
                // if n is empty, check interleaving with m only
                else if (nIdx == 0 && m.charAt(mIdx - 1) == p.charAt(mIdx - 1)) {
                    dp[mIdx][nIdx] = dp[mIdx - 1][nIdx];
                } else {
                    // if letter of m and p match, take whatever is matched until mIdx - 1
                    if (mIdx > 0 && m.charAt(mIdx - 1) == p.charAt(mIdx + nIdx - 1)) {
                        dp[mIdx][nIdx] = dp[mIdx - 1][nIdx];
                    }

                    // if letter of n and p match, take whatever is matched until nIdx - 1
                    if (nIdx > 0 && n.charAt(nIdx - 1) == p.charAt(mIdx + nIdx - 1)) {
                        // |= is required for common letters between m and n
                        dp[mIdx][nIdx] |= dp[mIdx][nIdx - 1];
                    }
                }
            }
        }

        return dp[mLen][nLen];
    }
}
