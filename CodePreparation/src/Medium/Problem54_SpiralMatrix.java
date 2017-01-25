package Medium;

import Hard.Problem85_MaximalRectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aakash on 1/25/2017.
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */
public class Problem54_SpiralMatrix {
    public static void main(String[] args) {
        Problem54_SpiralMatrix spiralMatrix = new Problem54_SpiralMatrix();
        int mat[][] = {{1, 2, 3, 10}, {4, 5, 6, 11}, {7, 8, 9, 12}, {13, 14, 15, 16}};
        List<Integer> res = spiralMatrix.spiralOrder(mat);
        for (Iterator<Integer> iterator = res.iterator(); iterator.hasNext(); ) {
            Integer next =  iterator.next();
            System.out.println("next = " + next);
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rs = 0;
        int re = matrix.length - 1;
        int cs = 0;
        int ce = matrix[0].length - 1;

        while(rs <= re && cs <= ce) {
            for (int i = cs; i <= ce; i++) {
                result.add(matrix[rs][i]);
            }
            rs++;

            for (int i = rs; i <= re; i++) {
                result.add(matrix[i][ce]);
            }
            ce--;
            if(rs <= re) {
                for (int i = ce; i >= cs; i--) {
                    result.add(matrix[re][i]);
                }
                re--;
            }

            if(cs <= ce) {
                for (int i = re; i >= rs; i--) {
                    result.add(matrix[i][cs]);
                }
                cs++;
            }
        }
        return result;
    }
}
