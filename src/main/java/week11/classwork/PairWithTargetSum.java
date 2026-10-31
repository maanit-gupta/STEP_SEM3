package week11.classwork;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 5: Pair With Target Sum (Unsorted)
 *
 * Approach 1 — Brute Force (nested loops):
 *   Time:  O(n²)   Space: O(1)
 *   Check every pair; simple but slow for large inputs.
 *
 * Approach 2 — HashSet (chosen):
 *   Time:  O(n)    Space: O(n)
 *   For each element, check if (target - element) is already in the set.
 *   Fast at the cost of extra memory.
 *
 * Approach 3 — Sort + Two Pointers:
 *   Time:  O(n log n)   Space: O(1) if in-place sort allowed
 *   Sort first, then use two pointers. Good middle ground.
 */
public class PairWithTargetSum {

    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(hasPairWithSum(nums1, target1));

        int[] nums2 = {3, 4, 6};
        int target2 = 20;
        System.out.println(hasPairWithSum(nums2, target2));
    }
}
