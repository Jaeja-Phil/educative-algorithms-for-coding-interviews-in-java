package sortingAndSearching;

public class $07_FindTheMedianOfTwoSortedArrays {
    public static void main(String[] args) {
        solution(new int[]{1, 2, 3}, new int[]{4, 5, 6});
    }

    /**
     * Given two sorted arrays, find the median of the two arrays.
     * first array is smaller than the second array in terms of size.
     */
    public static double solution(int[] arr1, int[] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int endIdx = arr1Length;
        int startIdx = 0;
        // i is number of elements to be inserted from arr1
        int i = 0;
        // j is number of elements to be inserted from arr2
        int j = 0;
        int median = 0;

        while (startIdx <= endIdx) {
            // start i with middle of arr1, and adjust the start/end index
            // based on which element should be inserted (from arr1 or arr2)
            // ex) arr1 = [1, 2, 3], arr2 = [4, 5, 6]
            // i = (0 + 2) / 2 = 1

            // number of elements to be added in j is calculated by
            // total number of elements in arr1 and arr2 plus 1
            // - why plus 1?
            //   - because we need to find the median, which is the middle element
            // j = (3 + 3 + 1) / 2 - i = 7 / 2 - 1 = 2
            i = (startIdx + endIdx) / 2;
            j = ((arr1Length + arr2Length + 1) / 2) - i;
            System.out.println("i = " + i + ", j = " + j);

            // number of elements to be added in arr1 hasn't reached the end (all elements)
            // and number of elements to be added in arr2 hasn't reached the beginning (0)
            // find whether expected element to add in arr1 is greater than
            // expected already added element in arr2 (hence j - 1)
            if (i < arr1Length && j > 0 && arr2[j - 1] > arr1[i]) {
                // greater number from arr1 is needed, so move start index to the right
                startIdx = i + 1;

                // there are elements to be added in arr1
                // and number of elements to be added in arr2 hasn't reached the end (all elements)
                // find whether expected added element from arr1 is less than
                // expected to add element in arr2
            } else if (i > 0 && j < arr2Length && arr2[j] < arr1[i - 1]) {
                // smaller number from arr1 is needed, so move end index to the left
                endIdx = i - 1;
            } else {
                // if there are no elements to be added in arr1
                if (i == 0) {
                    // median is from arr2
                    median = arr2[j - 1];
                    // if there are no elements to be added in arr2
                } else if (j == 0) {
                    // median is from arr1
                    median = arr1[i - 1];
                } else {
                    // if both arr1 and arr2 have elements to be added
                    // find the max of the already added elements
                    median = Math.max(arr1[i - 1], arr2[j - 1]);
                }
                break;
            }
        }

        // if total number of elements in arr1 and arr2 is odd, return median
        if ((arr1Length + arr2Length) % 2 == 1) {
            return (double) median;
        }

        // if total number of elements in arr1 and arr2 is even...

        // if all elements from arr1 are added
        // (median + next element from arr2) / 2
        if (i == arr1Length) {
            return (median + arr2[j]) / 2.0;
        }

        // if all elements from arr2 are added
        // (median + next element from arr1) / 2
        if (j == arr2Length) {
            return (median + arr1[i]) / 2.0;
        }

        // if both arr1 and arr2 have elements to be added
        // (median + next min target from arr1/arr2) / 2
        return (median + Math.min(arr1[i], arr2[j])) / 2.0;
    }
}
