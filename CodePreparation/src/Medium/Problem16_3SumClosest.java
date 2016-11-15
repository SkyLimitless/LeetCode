package Medium;

import java.util.Arrays;

/**
 * Created by Aakash on 11/14/2016.
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Problem16_3SumClosest {
    public static void main(String[] args) {
        Problem16_3SumClosest sumClosest = new Problem16_3SumClosest();
        int a[] = {-1, 2, 1, 4};
        int a1[] = {0,0,0};
        int result = sumClosest.threeSumClosest(a1, 2);
        System.out.println("result = " + result);
    }

    private int threeSumClosest(int[] a, int v) {
        int res =  Integer.MIN_VALUE;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            int first = a[i];
            int j = i + 1;
            int k = a.length - 1;
            while(j < k) {
                int temp = first + a[j] + a[k];
                if(res == Integer.MIN_VALUE) {
                    res = temp;
                }
                if (temp == v) {
                    return v;
                } else if (temp < v) {
                    j++;
                    if(Math.abs(v - res) > Math.abs(v - temp)) {
                        res = temp;
                    }
                } else {
                    k--;
                    if(Math.abs(v - res) > Math.abs(v - temp)) {
                        res = temp;
                    }
                }
            }
        }
        return res;
    }
}
