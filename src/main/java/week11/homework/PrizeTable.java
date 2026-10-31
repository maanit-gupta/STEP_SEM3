package week11.homework;

import java.util.Arrays;

/**
 * Problem 2: The Prize Table
 *
 * Selection Sort (descending) — in each round, find the largest
 * unsorted element and swap it into position. Count only swaps
 * where the max was not already in the correct place.
 *
 * Time Complexity:  O(n²) — nested scan for each position.
 * Space Complexity: O(1) — in-place swaps only.
 */
public class PrizeTable {

    public static int prizeTable(int[] marks) {
        int swaps = 0;
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                }
            }

            if (maxIdx != i) {
                int temp = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] marks1 = {45, 90, 60, 75};
        int swaps1 = prizeTable(marks1);
        System.out.println(Arrays.toString(marks1) + " swaps = " + swaps1);

        int[] marks2 = {80, 70, 60};
        int swaps2 = prizeTable(marks2);
        System.out.println(Arrays.toString(marks2) + " swaps = " + swaps2);

        int[] marks3 = {10, 50, 30, 20, 40};
        int swaps3 = prizeTable(marks3);
        System.out.println(Arrays.toString(marks3) + " swaps = " + swaps3);
    }
}
