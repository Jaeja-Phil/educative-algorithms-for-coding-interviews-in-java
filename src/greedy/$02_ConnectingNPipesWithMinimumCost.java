package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given "N" blockchains of varying lengths, find min cost of connecting them
 * - cost to connect 2 pipes is equal to the sum of their lengths
 */
public class $02_ConnectingNPipesWithMinimumCost {
    public static void main(String[] args) {
        int[] pipes = new int[] {4, 2, 3, 7};
        System.out.println(solution(pipes)); // 30

        pipes = new int[] {5, 6, 7, 9};
        /**
         * 5 + 6 = 11, total cost = 11, pipes = {7, 9, 11}
         * 7 + 9 = 16, total cost = 27, pipes = {11, 16}
         * 11 + 16 = 27, total cost = 54, all pipes used.
         */
        System.out.println(solution(pipes)); // 54
    }

    // inserting into heap takes approximately takes log(n)
    // there are n elements in pipes
    // n - 1 elements has to be added back to the queue
    // time complexity: n^2 * log(n)
    public static int solution(int[] pipes) {
        // early end condition, with no pipe or just one pipe, return as following:
        if (pipes.length == 0) {
            return 0;
        } else if (pipes.length == 1) {
            return pipes[0];
        }

        // use min heap to store pipes in order
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.naturalOrder());

        // start with cost 0
        int cost = 0;
        // add all items in to the queue, and priority queue will sort them in ascending order
        Arrays.stream(pipes).forEach(q::add);

        // while there are 2 or more items in the queue..
        while (q.size() > 1) {
            // take 2 items out from the queue
            int firstPipeLength = q.poll();
            int secondPipeLength = q.poll();
            // find the sum of those two pipes
            int sumLength = firstPipeLength + secondPipeLength;
            // add it to cost and then add back to the queue, which will be positioned in ascending order again
            cost += sumLength;
            q.add(sumLength);
        }

        // finally, return total cost
        return cost;
    }
}
