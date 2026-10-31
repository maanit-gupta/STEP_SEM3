package week11.classwork;

import java.util.Scanner;

/**
 * Problem 2: Warehouse Bin Grid Scan
 *
 * Scans every cell of an m × n grid to compute the total item count
 * and find the coordinates of the bin holding the most items.
 *
 * Time Complexity:  O(m * n) — must visit every cell exactly once.
 * Space Complexity: O(1) additional — only a running total, max value,
 *                   and max coordinates are stored beyond the input grid.
 */
public class WarehouseBinGridScan {

    public static void warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
                if (grid[r][c] > maxVal) {
                    maxVal = grid[r][c];
                    maxRow = r;
                    maxCol = c;
                }
            }
        }

        System.out.println("total = " + total + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")");
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        warehouseSummary(grid);
    }
}
