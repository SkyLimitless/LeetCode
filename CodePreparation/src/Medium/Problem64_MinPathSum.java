package Medium;

/**
 * Created by achaurasia on 11/4/16.
 */
public class Problem64_MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[m-1].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += grid[i - 1][j] < grid[i][j - 1] ? grid[i - 1][j] : grid[i][j - 1];
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Problem64_MinPathSum minPathSum = new Problem64_MinPathSum();
        int mat[][] = {{0, 5, 0}, {4, 6, 10}, {9, 2, 5}};
        int mat1[][] = {{1, 0}};
        int mat2[][] = {{0}};
        int result = minPathSum.minPathSum(mat2);
        System.out.println("result = " + result);
    }
}
