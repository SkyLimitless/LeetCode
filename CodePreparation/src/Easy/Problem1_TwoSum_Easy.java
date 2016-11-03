package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by achaurasia on 8/30/16.
 */
public class Problem1_TwoSum_Easy {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> set = new HashMap<>();
        Integer first = -1;
        for(int i = 0; i < nums.length; i++) {
            first = set.get(target - nums[i]);
            if(first != null) {
                return new int[]{first, i};
            } else {
                set.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}