package sortingAndSearching;

import java.util.Arrays;

public class $03_QuickSort {
    public static void main(String[] args) {
        /**
         * Quicksort
         * - start with an array of n elements
         * - choose a pivot element from the array to be sorted
         * - on the left side of the pivot, all elements are less than the pivot
         * - on the right side of the pivot, all elements are greater than the pivot
         * - recursively sort the left and right side of the pivot
         * - the base case is when the array has 0 or 1 elements
         * - the pivot can be chosen in many ways
         */

        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        // base case, when the array has 0 or 1 elements, return since it is sorted
        if (left >= right) {
            return;
        }

        /**
         * pick a pivot
         * there are many ways to pick a pivot (random, first, last, median, etc.)
         * here, we pick the middle element
         */
        int pivot = arr[left + (right - left) / 2];

        // find the partitioned index
        int index = partition(arr, left, right, pivot);

        // recursively sort the left and right sub-arrays
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    public static int partition(int[] arr, int left, int right, int pivot) {
        // while the left and right pointers have not crossed
        while (left <= right) {
            // find the first element on the left that is greater than the pivot
            while (arr[left] < pivot) {
                left++;
            }
            // find the first element on the right that is less than the pivot
            while (arr[right] > pivot) {
                right--;
            }

            // if the left and right pointers have not crossed, swap the elements
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        // return the partitioned index (where left to pivot is less than pivot and right to pivot is greater than pivot)
        return left;
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
