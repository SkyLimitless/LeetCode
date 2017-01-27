package Medium;

/**
 * Created by Aakash on 1/26/2017.
 */
public class Problem162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return 0;
        }
        for (int i = 1; i < len - 1; i++) {
            if(nums[i] > nums[i - 1] && nums[i] >nums[i + 1]) {
                return i;
            }
        }
        if(nums[0] > nums[1]) {
            return 0;
        }
        if(nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        return 0;
    }
}
