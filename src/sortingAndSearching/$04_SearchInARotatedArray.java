package sortingAndSearching;

public class $04_SearchInARotatedArray {
    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 0, 3, 5, 6};
        int res = solution(arr, 0, 6, 3);
        System.out.println(res); // 4
    }

    /**
     * Given a sorted array of n integers that has been rotated an unknown number of times,
     * write code to find an element in the array.
     * You may assume that the array was originally sorted in ascending order.
     */
    public static int solution(int[] arr, int left, int right, int target) {
        /**
         * rotated array would have two sorted sub-arrays
         * use binary search to find the subarray that contains the target
         */
        int mid = left + (right - left) / 2;

        // if target is found, return the index right away
        if (target == arr[mid]) {
            return mid;
        }

        // do a sanity check
        if (right < left) {
            return -1;
        }

        // if the left sub-array is sorted
        if (arr[left] < arr[mid]) {
            // if searching value is in the left sub-array
            if (target >= arr[left] && target < arr[mid]) {
                return solution(arr, left, mid - 1, target);
            } else { // if target is not in the left sub-array, search the right sub-array
                return solution(arr, mid + 1, right, target);
            }
        } else if (arr[mid] < arr[right]) { // if right sub-array is sorted
            // if target is in the right sub-array
            if (target <= arr[right] && target > arr[mid]) {
                return solution(arr, mid + 1, right, target);
            } else {
                return solution(arr, left, mid - 1, target);
            }
        } else if (arr[left] == arr[mid]) { // if left is all repeats
            if (arr[mid] != arr[right]) { // unless right sub-array is repeats
                return solution(arr, mid + 1, right, target); // search the right sub-array
            } else { // search both sub-arrays
                // search left first
                int result = solution(arr, left, mid - 1, target);
                // if not found from left, search right
                if (result == -1) {
                    return solution(arr, mid + 1, right, target);
                } else { // if found, return result from left
                    return result;
                }
            }
        }

        // when searching fails, return -1 indicating not found
        return -1;
    }
}
