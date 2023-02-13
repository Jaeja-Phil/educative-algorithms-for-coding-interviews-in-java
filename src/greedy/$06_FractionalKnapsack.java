package greedy;

import java.util.Arrays;

/**
 * Given weights and values of "n" items, put items in a knapsack with a capacity of W
 * - fractions of each item can be placed in the knapsack
 */
public class $06_FractionalKnapsack {
    public static void main(String[] args) {
        double[] weights = new double[] {2, 1, 6, 0.5, 0.25, 7};
        double[] values = new double[] {50, 70, 100, 50, 30, 99};
        double res = solution(weights, values, 10);
        System.out.println(res); // 303.54
    }

    public static double solution(double[] weights, double[] values, double capacity) {
        int totalItems = weights.length;
        ItemValue[] iVal = new ItemValue[totalItems];

        for (int i = 0; i < totalItems; i++) {
            iVal[i] = new ItemValue(weights[i], values[i], i);
        }

        // sort in descending order of cost efficiency
        Arrays.sort(iVal, (a, b) -> b.cost.compareTo(a.cost));

        double totalValue = 0;
        for (ItemValue i : iVal) {
            double currWeight = i.weight;
            double currValue = i.value;
            if (capacity - currWeight >= 0) {
                capacity -= currWeight;
                totalValue += currValue;
            } else {
                double fraction = capacity / currWeight;
                totalValue += fraction * currValue;
                break;
            }
        }

        return totalValue;
    }

    static class ItemValue {
        Double cost; // declared as a wrapper class in order to sort (need compareTo method)
        double weight, value, idx;

        public ItemValue(double weight, double value, int idx) {
            this.weight = weight;
            this.value = value;
            this.idx = idx;
            this.cost = this.value / this.weight;
        }

        @Override
        public String toString() {
            return "ItemValue{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    ", value=" + value +
                    ", idx=" + idx +
                    '}';
        }
    }
}
