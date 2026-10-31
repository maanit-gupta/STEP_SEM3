package week11.classwork;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 8: Spiral Order Traversal
 *
 * Traverses a 2D grid in clockwise spiral order using four boundary
 * pointers (top, bottom, left, right) that shrink inward.
 *
 * Time Complexity:  O(m * n) — every element is visited exactly once.
 * Space Complexity: O(m * n) for the output list (no additional space
 *                   beyond the result).
 */
public class SpiralOrderTraversal {

    public static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid == null || grid.length == 0) {
            return result;
        }

        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                result.add(grid[top][c]);
            }
            top++;

            for (int r = top; r <= bottom; r++) {
                result.add(grid[r][right]);
            }
            right--;

            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    result.add(grid[bottom][c]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    result.add(grid[r][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(spiralOrder(grid));
    }
}
