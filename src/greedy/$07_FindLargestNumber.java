package greedy;

/**
 * Given number of digits and sum of digits, find the largest number that can be formed
 */
public class $07_FindLargestNumber {
    public static void main(String[] args) {
        int res = solution(3, 20);
        System.out.println(res); // 992

        res = solution(1, 0);
        System.out.println(res); // 0
    }

    public static int solution(int numberOfDigits, int sumOfDigits) {
        /**
         * edge case 1:
         * - if sum of digits is 0, return -1 unless number of digits is 1 (0 is the largest number)
         */
        if (sumOfDigits == 0) {
            return numberOfDigits == 1 ? 0 : -1;
        }

        /**
         * edge case 2:
         * - if sum of digits is greater than 9 * number of digits, return -1
         *   - ex) 3 digits, the largest number is 999, and the sum of digits should not be greater than 27
         */
        if (sumOfDigits > 9 * numberOfDigits) {
            return -1;
        }

        int answer = 0;
        while (numberOfDigits > 0 && sumOfDigits > 0) {
            /**
             * if sum of digits is greater than or equal to 9,
             * add 9 * 10^(number of digits - 1) to the answer
             */
            if (sumOfDigits >= 9) {
                answer += 9 * Math.pow(10, numberOfDigits - 1);
                sumOfDigits -= 9;
            } else {
                /**
                 * if sum of digits is less than 9,
                 * add sum of digits * 10^(number of digits - 1) to the answer
                 */
                answer += sumOfDigits * Math.pow(10, numberOfDigits - 1);
                sumOfDigits = 0;
            }

            numberOfDigits--;
        }

        return answer;
    }
}
