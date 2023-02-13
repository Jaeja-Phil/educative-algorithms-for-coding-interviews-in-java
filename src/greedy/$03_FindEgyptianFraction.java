package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive fraction, break it down into its Egyptian fractions.
 * - a fraction is a unit fraction if **numerator is 1** and denominator is a positive #
 * ex)
 * numerator = 2
 * denominator = 3
 * 2 / 3 --> 1 / 2 + 1 / 6
 * answer = 1 / 2 + 1 / 6
 */
public class $03_FindEgyptianFraction {
    public static void main(String[] args) {
        solution(2, 3);
        System.out.println();
        solution(6, 14);
    }

    public static void solution(int numerator, int denominator) {
        // when numerator or denominator is 0
        if (numerator == 0 || denominator == 0) {
            return;
        }

        // if numerator divides denominator, finish by printing 1/n
        // ex) numerator = 2, denominator = 4 --> 1/2
        if (denominator % numerator == 0) {
            System.out.print("1/" + denominator / numerator);
            return;
        }

        // if denominator divides numerator, given number is not a fraction
        // ex) numerator = 4, denominator = 4 --> 1, not a fraction
        // ex) numerator = 4, denominator = 2 --> 2, not a fraction
        if (numerator % denominator == 0) {
            System.out.print(numerator / denominator);
            return;
        }

        // if numerator is greater than denominator
        if (numerator > denominator) {
            System.out.println(numerator / denominator + " + ");
            solution(numerator % denominator, denominator);
            return;
        }

        // reaching here means
        // - denominator > numerator
        // - denominator % numerator is non-zero
        // find ceiling of denominator / numerator and print it as first fraction.
        int n = denominator / numerator + 1;
        System.out.print("1/" + n + " + ");

        // recursion for the remaining part
        solution(numerator * n - denominator, denominator * n);
    }

    // TODO:phil
    // - understand the explanation part
    //   link: https://www.educative.io/courses/algorithms-coding-interviews-java/JPnmDXmPJ0v
}
