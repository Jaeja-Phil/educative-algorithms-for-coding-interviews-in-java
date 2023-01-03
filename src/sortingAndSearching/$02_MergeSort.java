package sortingAndSearching;

import java.util.Arrays;

public class $02_MergeSort {
    public static void main(String[] args) {
        /**
         * Merge Sort
         * - mergesort is a divide and conquer algorithm
         *   - divides given array into 2 halves, sort those halves, and merges them together in order
         *
         * Time Complexity
         * - O(n log n)
         */
        int[] arr = {5, 3, 6, 2, 10, 7, 4, 1, 9, 8};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }

    public static void mergeSort(int[] arr, int leftIndex, int rightIndex) {
        // base case
        if (leftIndex < 0 || rightIndex < 0) {
            return;
        }

        if (rightIndex > leftIndex) {
            // find middle index
            int mid = leftIndex + (rightIndex - leftIndex) / 2; // (leftIndex + rightIndex) / 2 is also possible, but this way avoids overflow

            // sort first and second halves
            mergeSort(arr, leftIndex, mid); // 1st half
            mergeSort(arr, mid + 1, rightIndex); // 2nd half

            // merging the array
            merge(arr, leftIndex, mid, rightIndex);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // initializing sizes of temporary arrays
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        // initializing temporary arrays
        int[] leftArr = new int[sizeLeft];
        int[] rightArr = new int[sizeRight];

        // copying data to temporary arrays
        for (int i = 0; i < sizeLeft; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < sizeRight; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        // merging temporary arrays back into given array
        int i = 0; // initial index of first subarray
        int j = 0; // initial index of second subarray
        int k = left; // initial index of given subarray

        // iterate over both arrays and copy the element that is smaller to the given array
        while (i < sizeLeft && j < sizeRight) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // copying remainder of leftArr, if any
        while (i < sizeLeft) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // copying remainder of rightArr, if any
        while (j < sizeRight) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
