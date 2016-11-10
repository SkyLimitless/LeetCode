package Hard;

import java.util.Stack;

/**
 * Created by Aakash on 11/10/2016.
 */
public class Problem84_LargestRectangleHistogram {
    public static void main(String[] args) {
        Problem84_LargestRectangleHistogram largestRectangleHistogram = new Problem84_LargestRectangleHistogram();
        int a[] = {3, 2, 4, 5, 2, 3, 6};
        int max = largestRectangleHistogram.largestRectangleArea(a);
        System.out.println("max = " + max);
    }

    public int largestRectangleArea(int[] heights) {
        System.out.println("Problem84_LargestRectangleHistogram.getMaxArea");
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        for (i = 0; i < heights.length; i++) {
            int i1 = heights[i];
            if(stack.empty() || heights[stack.peek()] <= i1) {
                stack.push(i);
            } else {
                int temp = stack.pop();
                int new_area = 0;
                if(stack.empty()) {
                    new_area = heights[temp]*i;
                } else {
                    new_area = heights[temp] * (i - stack.peek() - 1);
                }
                max = max < new_area ? new_area : max;
                i--;
            }
        }
        while(!stack.empty()) {
            int temp = stack.pop();
            int new_area = 0;
            if(stack.empty()) {
                new_area = heights[temp] * i;
            } else {
                new_area = heights[temp] * (i - stack.peek() - 1);
            }
            max = max < new_area ? new_area : max;
        }
        return max;
    }
}
