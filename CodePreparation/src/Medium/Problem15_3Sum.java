package Medium;

import java.util.*;

/**
 * Created by Aakash on 11/5/2016.
 * Need to chanbge
 */
public class Problem15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            if(first > 0)
                break;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int temp = first + nums[j] + nums[k];
                if(temp == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(first);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    j++;
                } else if(temp > 0) {
                    k--;
                } else {
                    j++;
                }
            }
            while(i <  nums.length - 2 && nums[i] == nums[i + 1])i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = {1, 1, -2};
        Problem15_3Sum problem15_3Sum = new Problem15_3Sum();
        problem15_3Sum.threeSum(a);
    }
}
