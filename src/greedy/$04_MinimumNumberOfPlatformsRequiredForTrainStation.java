package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Implement a function that returns the min # of platforms taht are required for the trains
 * so that none of them wait
 */
public class $04_MinimumNumberOfPlatformsRequiredForTrainStation {
    public static void main(String[] args) {
        int res = solution(new int[]{900, 940, 950, 1100, 1500, 1800}, new int[]{910, 1200, 1120, 1130, 1900, 2000});
        System.out.println(res); // 3

        res = solution(new int[] {200, 210, 300, 320, 350, 500}, new int[] {230, 240, 320, 430, 400, 520});
        System.out.println(res); // 2
    }

    public static int solution(int[] arrival, int[] departure) {
        // base case
        if (arrival.length == 0 || departure.length == 0) {
            return 0;
        }

        // sort arrival and departure in ascending order
        Arrays.sort(arrival);
        Arrays.sort(departure);

        // create min heap
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.naturalOrder());
        // add first (sorted) departure time
        q.add(departure[0]);
        // since one train is in queue, maxCount is initialized as 1
        int maxCount = 1;
        // to start iterating from idx 1
        int currTrainIdx = 1;

        // while queue is not empty and current train idx doesn't exceed total length...
        while (!q.isEmpty() && currTrainIdx < arrival.length - 1) {
            // set current time as next train's arrival time
            int currTime = arrival[currTrainIdx];
            // check first item in min heap (which hold the earliest departure time)
            // if departure time is same or before current time, no extra train is needed, take it out of the queue
            while (!q.isEmpty() && q.peek() <= currTime) {
                q.poll();
            }
            // add current train and increment train idx
            q.add(departure[currTrainIdx++]);
            // compare and replace maxCount with amount of trains departed
            maxCount = Math.max(maxCount, q.size());
        }

        // return maxCount which hold max # of trains required
        return maxCount;
    }
}
