package sortingAndSearching;

import java.util.Arrays;
import java.util.HashMap;

public class $05_Challenge1_FindTwoNumbersThatAddUpToN {
    public static void main(String[] args) {
        int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
        int[] res = solution(arr, 27);
        System.out.println(Arrays.toString(res)); // [21, 6]

        int[] res2 = solution(arr, 81);
        System.out.println(Arrays.toString(res2)); // [21, 60]
    }

    public static int[] solution(int[] arr, int target) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // find the complement of target
            int complement = target - arr[i];
            // if the complement is in the map, return the complement and the current element
            if (map.containsKey(complement)) {
                return new int[] {complement, arr[i]};
            }
            map.put(arr[i], true);
        }

        // if not found, return {-1, -1}
        return new int[] {-1, -1};
    }
}
