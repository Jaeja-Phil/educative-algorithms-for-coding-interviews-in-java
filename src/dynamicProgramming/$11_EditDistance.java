package dynamicProgramming;

/**
 * Given two strings, write code to calculate how many min Levenshtein distance operations are required
 * to convert one string to another.
 * - insert, delete, substitution takes same cost
 */
public class $11_EditDistance {
    public static void main(String[] args) {
        String s1 = "Tuesday";
        String s2 = "Thursday";
        int res = solution(s1, s2);
        System.out.println(res); // 2
    }

    public static int solution(String s1, String s2) {
        return -1;
    }
}
