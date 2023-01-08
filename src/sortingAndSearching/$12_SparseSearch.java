package sortingAndSearching;

public class $12_SparseSearch {
    public static void main(String[] args) {
        String[] arr = {"", "educative", "", "", "",  "hello", "", "learning", "world", "", "", ""};
        int res = solution(arr, "educative");
        System.out.println(res); // 1
    }

    /**
     * Implement a function that returns the index of the target string in a sorted and sparsed array of strings
     */
    public static int solution(String[] arr, String target) {
        return binarySearch(arr, 0, arr.length - 1, target);
    }

    private static int binarySearch(String [] arr, int low, int high, String target) {
        // exit condition
        if (low > high) {
            return -1;
        }

        // set mid
        int mid = low + (high - low) / 2;

        // if mid is empty, find the closest non-empty string
        if (arr[mid].equals("")) {
            int i = mid - 1; // index for left searching
            int j = mid + 1; // index for right searching
            while (true) {
                // if i and j are out of bound, then none empty string is not found, exit
                if (i < low && j > high) {
                    return -1;
                }

                // while i is in bounds (equal or higher than low), check if arr at position i is not empty
                if (i >= low && !arr[i].equals("")) {
                    // found non empty string, set mid to i
                    mid = i;
                    break;
                    // while j is in bounds (equal or lower than high), check if arr at position j is not empty
                } else if (j <= high && !arr[j].equals("")) {
                    // found non empty string, set mid to j
                    mid = j;
                    break;
                }

                // if non-empty string is not found, move i and j to left and right
                i--;
                j++;
            }
        }

        // reaching here means non-empty string is found from previous check condition
        // check if mid is the target
        if (arr[mid].equals(target)) {
            return mid;
            // if mid is not the target, check if mid at "higher" order than target
        } else if (arr[mid].compareTo(target) > 0) {
            // since mid is higher than target, search in the left half
            return binarySearch(arr, low, mid - 1, target);
            // if mid is not the target, check if mid at "lower" order than target
        } else {
            // since mid is lower than target, search in the right half
            return binarySearch(arr, mid + 1, high, target);
        }
    }
}
