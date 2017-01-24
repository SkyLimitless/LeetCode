package Hard;

/**
 * Created by Aakash on 1/10/2017.
 */
public class Problem42_TrappingRainWater {
    public static void main(String[] args) {
        Problem42_TrappingRainWater rainWater = new Problem42_TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int output = rainWater.trap(height);
        System.out.println("output = " + output);
    }

    public int trap(int[] height) {
        int len = height.length;
        if(len == 0) {
            return 0;
        }
        int[] left = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        int[] right = new int[len];
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        
        int water = 0;
        for (int i = 0; i < len; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }

        return water;
    }
}
