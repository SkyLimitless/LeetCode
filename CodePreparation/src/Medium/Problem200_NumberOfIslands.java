package Medium;

/**
 * Created by Aakash on 1/27/2017.
 */
public class Problem200_NumberOfIslands {
    int n;
    int m;
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if(n == 0) {
            return 0;
        }
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    propagateZero(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void propagateZero(char[][] grid, int i, int j) {
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        propagateZero(grid, i + 1, j);
        propagateZero(grid, i - 1, j);
        propagateZero(grid, i, j + 1);
        propagateZero(grid, i, j - 1);
    }

    public static void main(String[] args) {
        Problem200_NumberOfIslands numberOfIslands = new Problem200_NumberOfIslands();
        char[][] grid = {{1, 0, 1, 1}, {1, 1, 0, 1}};
        int count = numberOfIslands.numIslands(grid);
        System.out.println(count);
    }
}
