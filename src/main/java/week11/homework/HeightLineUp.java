package week11.homework;

import java.util.Arrays;

/**
 * Problem 1: The Height Line-Up
 *
 * Bubble Sort implementation — repeatedly sweeps left to right,
 * swapping adjacent elements that are out of order. Stops early
 * if a full sweep produces no swaps.
 *
 * Time Complexity:  O(n²) worst/average, O(n) best (already sorted).
 * Space Complexity: O(1) — in-place swaps only.
 */
public class HeightLineUp {

    public static void lineUp(int[] heights) {
        int n = heights.length;
        int pass = 0;

        while (true) {
            boolean swapped = false;
            pass++;

            for (int j = 0; j < n - pass; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test 1 ---");
        lineUp(new int[]{4, 2, 5, 1});

        System.out.println("--- Test 2 ---");
        lineUp(new int[]{1, 3, 2, 4});

        System.out.println("--- Custom Test ---");
        lineUp(new int[]{5, 3, 8, 1, 2});
    }
}
