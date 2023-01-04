package sortingAndSearching;

public class $04_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    }

    public static int binarySearch(int[] arr, int target) {
        // sanity check
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        // while the start and end pointers have not crossed
        while (start <= end) {
            /**
             * find the middle element
             * if array size is odd, the middle element is the middle element
             * - ex: 1, 2, 3, 4, 5, 6, 7 --> 4
             * if array size is even, the middle element is the left of the middle two elements
             * - ex: 1, 2, 3, 4, 5, 6 --> 3
             */
            int mid = start + (end - start) / 2;

            if (arr[mid] < target) {
                // if middle element is less than target, increase start pointer to right of mid
                start = mid + 1;
            } else if (arr[mid] > target) {
                // if middle element is greater than target, decrease end pointer to left of mid
                end = mid - 1;
            } else {
                // if found, return the index
                return mid;
            }
        }

        // if not found, return -1
        return -1;
    }


}
