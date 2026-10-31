package week11.classwork;

/**
 * Problem 7: Insert Position in a Sorted List
 *
 * Uses binary search to find the target or its insertion point
 * in a sorted array of distinct integers.
 *
 * Time Complexity:  O(log n) — binary search halves the search space
 *                   each iteration; ideal for very large arrays
 *                   with frequent lookups.
 * Space Complexity: O(1) — only index variables.
 */
public class InsertPositionInSortedList {

    public static int searchInsertPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        System.out.println(searchInsertPosition(nums, 5));
        System.out.println(searchInsertPosition(nums, 2));
    }
}
