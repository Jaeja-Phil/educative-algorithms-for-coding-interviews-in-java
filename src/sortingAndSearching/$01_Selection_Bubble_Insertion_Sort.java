package sortingAndSearching;

import java.util.Arrays;

public class $01_Selection_Bubble_Insertion_Sort {
    public static void main(String[] args) {
        /**
         * Selection Sort
         * - divides input array into 2 parts
         *   1. sublist of already sorted
         *   2. sublist of remaining unsorted
         * - initially, sorted sublist is empty and unsorted sublist is entire input array
         * - algorithm proceeds by finding the smallest element in unsorted sublist, swapping it with leftmost unsorted element
         *   (putting it in sorted sublist)
         * - selection sort works by iterating over the array, and swapping each element with minimum element found
         *   in the rest of the array
         */
        int[] arr = {5, 3, 6, 2, 10};
        int minIndex;
        // iterate over the array
        for (int i = 0; i < arr.length; i++) {
            // find the min element in the unsorted array
            minIndex = findMin(arr, i, arr.length - 1);

            // swap found min element with leftmost unsorted element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println(Arrays.toString(arr)); // [2, 3, 5, 6, 10]

        /**
         * Time complexity for selection sort is O(n^2)
         * - findMin iterates over the entire array for each element in the array
         */

        /**
         * Bubble Sort
         * - compare adjacent pairs of elements and swapping them if they are in wrong order.
         *   - repeated until array is sorted
         */
        int[] arr2 = {5, 3, 6, 2, 10};
        // iterate over the array, rightmost element will be sorted after each iteration
        // hence, we don't need to iterate over the last element
        for (int i = 0; i < arr2.length - 1; i++) {
            // iterate over the array, swapping adjacent elements if they are in wrong order
            for (int j = 0; j < arr2.length - i - 1; j++) {
                if (arr2[j] > arr2[j + 1]) {
                    int temp = arr2[j];
                    arr2[j] = arr2[j + 1];
                    arr2[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr2)); // [2, 3, 5, 6, 10]

        /**
         * Time complexity for bubble sort is O(n^2)
         */

        /**
         * Insertion Sort
         * - iterates over given array, figure out what the correct position of every element is and
         *   "inserts" each element in its place
         */
        int[] arr3 = {5, 3, 6, 2, 10};
        // iterate over the array from index 1 to the end
        // skip index 0 because first element inserted doesnt need any sorting (already sorted)
        for (int i = 1; i < arr3.length; i++) {
            int element = arr3[i]; // element to be inserted
            int j = i - 1; // index of last element in sorted sublist

            while (j >= 0 && arr3[j] > element) {
                arr3[j + 1] = arr3[j]; // shift element to the right
                j--;
            }
            arr3[j + 1] = element; // insert element in its correct position
        }

        System.out.println(Arrays.toString(arr3)); // [2, 3, 5, 6, 10]

        /**
         * Time complexity for insertion sort is O(n^2)
         */
    }

    public static int findMin(int[] arr, int start, int end) {
        if (end <= 0 || start < 0) {
            return 0;
        }

        int minIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }

        return minIndex;
    }
}
