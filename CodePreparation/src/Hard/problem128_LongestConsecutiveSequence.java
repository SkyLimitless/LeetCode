package Hard;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Aakash on 1/25/2017.
 */
public class problem128_LongestConsecutiveSequence {
    public int longestConsecutive(List<Integer> nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if(!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                int sum = left + right + 1;
                res = Math.max(res, sum);
                map.put(n, sum);
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }
        return res;
    }
}
