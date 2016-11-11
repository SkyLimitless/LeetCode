package Medium;

/**
 * Created by achaurasia on 11/11/16.
 */
public class Problem53_MaxSubArray {
    public static void main(String[] args) {
        Problem53_MaxSubArray maxSubArray = new Problem53_MaxSubArray();
        int a[] = {3, -1, 2, 4, 5, -8, 5, 10};
        maxSubArray.maxSubArray(a);
    }
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > max) {
                max = sum;
            }
            if (sum < 0 ){
                sum = 0;
            }
        }
        return max;
    }
}
