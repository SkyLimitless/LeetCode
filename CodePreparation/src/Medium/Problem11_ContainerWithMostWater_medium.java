package Medium;

/**
 * Created by Aakash on 10/29/2016.
 */
public class Problem11_ContainerWithMostWater_medium {
    public int maxArea(int[] height) {
        if(height ==  null || height.length < 2) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int max = -1;
        while(start < end) {
            max = Math.max(max, (end - start)* Math.min(height[start], height[end]));
            if(height[start] < height[end]) {
                start++;
            } else {
                end --;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem11_ContainerWithMostWater_medium problem11_containerWithMostWater_medium = new Problem11_ContainerWithMostWater_medium();
        int a[] = {1, 2, 4, 2, 3, 2, 5, 2};
        int result = problem11_containerWithMostWater_medium.maxArea(a);
        System.out.println("result = " + result);
    }
}
