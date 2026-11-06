/**
 * Week 10 Assignment - Problem 10: Busiest Bus Row
 * Returns the row with the largest total; on a tie the smaller index wins (update only on strictly larger).
 *
 * Complexity: O(r * c) time (every seat is visited once), O(1) additional space.
 */
public class A10_BusiestBusRow {

    // Returns {rowIndex, total}
    static int[] busiestRow(int[][] grid) {
        int bestRow = 0, bestTotal = -1;
        for (int r = 0; r < grid.length; r++) {
            int total = 0;
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = r;
            }
        }
        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 0, 1}, {3, 3, 1}, {1, 1, 1}};
        int[] result = busiestRow(grid);
        System.out.println("grid = [[2, 0, 1], [3, 3, 1], [1, 1, 1]] -> Row " + result[0] + ", Total " + result[1]);
    }
}
