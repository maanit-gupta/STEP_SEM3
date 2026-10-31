package week11.classwork;

import java.util.Arrays;

/**
 * Problem 10: Remove Duplicates From a Sorted Array In-Place
 *
 * Uses the two-pointer technique: a slow writer pointer and a fast
 * reader pointer. When a new unique element is found, it is written
 * at the writer position.
 *
 * Time Complexity:  O(n) — single pass through the array.
 * Space Complexity: O(1) additional — only two index variables.
 *
 * This qualifies as in-place because no second array of comparable
 * size is allocated; modifications happen within the original array.
 */
public class RemoveDuplicatesSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int writer = 0;

        for (int reader = 1; reader < nums.length; reader++) {
            if (nums[reader] != nums[writer]) {
                writer++;
                nums[writer] = nums[reader];
            }
        }

        return writer + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int length = removeDuplicates(nums);

        System.out.println("length = " + length);
        System.out.println("nums[0.." + (length - 1) + "] = " + Arrays.toString(Arrays.copyOf(nums, length)));
    }
}
