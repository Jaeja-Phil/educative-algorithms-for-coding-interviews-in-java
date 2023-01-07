package sortingAndSearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class $08_FindDuplicatesInArray {
    public static void main(String[] args) {
        List<Integer> res = solution(new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10});
        System.out.println(res);
    }

    /**
     * Given an array, find all duplicates that exist in that array
     */
    public static List<Integer> solution(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates;
    }
}
