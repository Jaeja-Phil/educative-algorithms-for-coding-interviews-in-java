package sortingAndSearching;

public class $11_SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int res = solution(arr, 5);
        System.out.println(res); // 2

        int res2 = solution(arr, 4);
        System.out.println(res2); // 2
    }

    /**
     * Given a sorted array and a target value, return where the target value would be
     * if it were inserted in order.
     *
     * if target index is already present in the array, return the index of where it is found.
     *
     * no duplicates in the array
     */
    public static int solution(int[] arr, int target) {
        int arrSize = arr.length;

        // sanity check
        if (arrSize == 0) {
            return -1;
        }

        int start = 0, end = arrSize - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}
