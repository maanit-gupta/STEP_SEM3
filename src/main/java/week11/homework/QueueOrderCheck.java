package week11.homework;

/**
 * Problem 4: Is the Queue in Order?
 *
 * Single-pass scan that returns the index of the first token that
 * is smaller than the one before it, or -1 if the queue is sorted.
 *
 * Time Complexity:  O(n) — at most one pass.
 * Space Complexity: O(1) — no extra storage.
 */
public class QueueOrderCheck {

    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstBreak(new int[]{3, 5, 5, 8, 6, 9}));
        System.out.println(firstBreak(new int[]{1, 2, 2, 7}));
        System.out.println(firstBreak(new int[]{10, 5, 3}));
    }
}
