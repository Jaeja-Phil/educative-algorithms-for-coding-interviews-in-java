package sortingAndSearching;

public class $09_SearchInSortedMatrix {
    public static void main(String[] args) {
        boolean res = solution(new int[][] {
                {10, 11, 12, 13},
                {14, 15, 16, 17},
                {27, 29, 30, 31},
                {32, 33, 39, 80}
        }, 30);
        System.out.println(res); // true
    }

    public static boolean solution(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int min = 0;
        int max = matrix.length * matrix[0].length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;

            if (target < matrix[row][col]) {
                max = mid - 1;
            } else if (target > matrix[row][col]) {
                min = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
