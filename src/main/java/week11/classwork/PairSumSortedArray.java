package week11.classwork;

/**
 * Problem 9: Pair Sum in a Sorted Array
 *
 * Two-pointer approach (leverages sorted order):
 *   Time Complexity:  O(n) — each pointer moves at most n times total.
 *   Space Complexity: O(1) — only two index variables.
 *
 * Brute-force (ignoring sorted property):
 *   Time Complexity:  O(n²) — checks every pair.
 *   Space Complexity: O(1).
 *
 * The two-pointer approach is dramatically faster for large sorted
 * inputs, reducing O(n²) to O(n) with no extra memory.
 */
public class PairSumSortedArray {

    public static String pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return "(" + nums[left] + ", " + nums[right] + ")";
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 5, 9};
        System.out.println(pairSumSorted(nums1, 4));

        int[] nums2 = {1, 2, 3};
        System.out.println(pairSumSorted(nums2, 100));
    }
}
