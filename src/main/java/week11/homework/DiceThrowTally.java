package week11.homework;

import java.util.Arrays;

/**
 * Problem 5: The Dice Throw Tally
 *
 * Counting Sort — counts occurrences of each face (1–6), then
 * reconstructs the sorted array from the counts. No element-to-element
 * comparisons are performed.
 *
 * Time Complexity:  O(n + k) where k = 6 (constant), so effectively O(n).
 * Space Complexity: O(k) = O(1) for the count array (fixed size 7).
 */
public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int roll : rolls) {
            count[roll]++;
        }

        StringBuilder sb = new StringBuilder("Counts: ");
        for (int v = 1; v <= 6; v++) {
            if (v > 1) {
                sb.append(" ");
            }
            sb.append(v).append(":").append(count[v]);
        }
        System.out.println(sb);

        int[] sorted = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[idx++] = v;
            }
        }

        System.out.println("Sorted: " + Arrays.toString(sorted));
        return sorted;
    }

    public static void main(String[] args) {
        System.out.println("--- Test 1 ---");
        diceSort(new int[]{4, 1, 6, 4, 2, 1, 4});

        System.out.println("--- Custom Test ---");
        diceSort(new int[]{6, 6, 3, 1, 2, 5, 3, 1});
    }
}
