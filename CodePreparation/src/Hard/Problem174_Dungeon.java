package Hard;

/**
 * Created by achaurasia on 11/4/16.
 */
public class Problem174_Dungeon {
    public int calculateMinimumHP(int[][] dungeon) {
        int m  = dungeon.length;
        int n = dungeon[0].length;
        int str[][] = dungeon.clone();
        str[0][0] = dungeon[0][0] >= 0 ? 0 : dungeon[0][0]
    }

    public static void main(String[] args) {
        Problem174_Dungeon dungeon = new Problem174_Dungeon();
        int mat[][] = {{0, 5, 0}, {4, 6, 10}, {9, 2, 5}};
        int mat1[][] = {{1, 0}};
        int mat2[][] = {{0}};
        int res = dungeon.calculateMinimumHP(mat);
        System.out.println("res = " + res);
    }
}
