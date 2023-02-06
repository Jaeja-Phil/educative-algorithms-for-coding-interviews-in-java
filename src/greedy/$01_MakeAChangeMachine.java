package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given infinite quarters, dimes, nickels, and pennis, calculate the min # of coins to represent
 * a collection of amount "C".
 */
public class $01_MakeAChangeMachine {
    public static int[] coins = {25, 10, 5, 1};

    public static void main(String[] args) {
        List<Integer> ans = solution(50);
        System.out.println(ans); // [25, 25]

        ans = solution(66);
        System.out.println(ans); // [25, 25, 10, 5, 1]

        ans = solution(99);
        System.out.println(ans); // [25, 25, 25, 10, 10, 1, 1, 1, 1]
    }

    public static List<Integer> solution(int amount) {
        List<Integer> result = new ArrayList<>();

        // iterate through coins
        for (int coinValue : coins) {
            // subtract amount until amount is greater than or equal to coinValue
            // if subtracted, add it to the result list
            while (amount >= coinValue) {
                result.add(coinValue);
                amount -= coinValue;
            }
            // break early if amount reached 0
            if (amount == 0) {
                break;
            }
        }

        return result;
    }
}
