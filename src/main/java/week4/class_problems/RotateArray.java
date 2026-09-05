package week4.class_problems;

import java.util.Arrays;

public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        k = k % n;
        if (k < 0) {
            k += n;
        }

        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = newArray[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(rotateArray(nums1, k1)));

        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println(Arrays.toString(rotateArray(nums2, k2)));
    }
}
