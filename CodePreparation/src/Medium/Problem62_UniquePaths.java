package Medium;

/**
 * Created by achaurasia on 11/4/16.
 */
public class Problem62_UniquePaths {
    public int uniquePaths(int m, int n) {

        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            a[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            a[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1];
            }
        }
        
        return a[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Problem62_UniquePaths uniquePaths = new Problem62_UniquePaths();
        int result = uniquePaths.uniquePaths(7, 7);
        System.out.println("result = " + result);
    }
}
