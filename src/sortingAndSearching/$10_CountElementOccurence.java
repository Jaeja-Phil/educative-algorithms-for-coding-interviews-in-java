package sortingAndSearching;

public class $10_CountElementOccurence {
    public static void main(String[] args) {
        int[] arr = {-5,-3,0,1,3,3,3,3,4,5};
        int res = solution(arr, 3);
        System.out.println(res); // 4
    }

    /**
     * using binary search
     */
    public static int solution(int[] arr, int target) {
        int arrSize = arr.length;
        int start = 0, end = arrSize - 1, mid, result = -1;

        // finding index of the first occurrence
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                result = mid;
                end = mid - 1; // find the lower bound
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // finding index of the second occurrence
        int start2 = 0, end2 = arrSize - 1, mid2, result2 = -1;
        while (start2 <= end2) {
            mid2 = start2 + (end2 - start2) / 2;
            if (arr[mid2] == target) {
                result2 = mid2;
                start2 = mid2 + 1; // find the upper bound
            } else if (arr[mid2] > target) {
                end2 = mid2 - 1;
            } else {
                start2 = mid2 + 1;
            }
        }

        if (result == -1 || result2 == -1) {
            return result2 - result;
        }

        return result2 - result + 1;
    }
}

/**
 * solution found in leetcode:
 * - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/14734/easy-java-o-logn-solution/?q=java&orderBy=most_votes
 */
class $10_CountElementOccurrenceFromLeetCode {
    public static void main(String[] args) {
        int[] arr = {-5,-3,0,1,3,3,3,3,4,5};
        int res = solution(arr, 6);
        System.out.println(res);
    }

    public static int solution(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return (first == -1 || last == -1) ? 0 : last - first + 1;
    }

    private static int findFirst(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start] == target ? start : -1;
    }

    private static int findLast(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return nums[start] == target ? start : -1;
    }
}