package sortingAndSearching;

import java.util.Arrays;

public class $13_DutchNationalFlagProblem {
    public static void main(String[] args) {
        int[] arr = {2, 0, 0, 1, 2, 1, 0};
        solution(arr);
        System.out.println(Arrays.toString(arr)); // [0, 0, 0, 1, 1, 2, 2]
    }

    /**
     * implement a function that sorts an array of 0, 1, and 2s
     * try solving this problem inplace and linear time, without using extra space
     */
    public static int[] solution(int[] arr) {
        int zeroIdx = 0;
        int oneIdx = 0;
        int twoIdx = arr.length - 1;

        while (oneIdx <= twoIdx) {
            if (arr[oneIdx] == 0) {
                swap(arr, zeroIdx++, oneIdx++);
            } else if (arr[oneIdx] == 2) {
                swap(arr, oneIdx, twoIdx--);
            } else { // arr[currentIdx] == 1
                oneIdx++;
            }
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
