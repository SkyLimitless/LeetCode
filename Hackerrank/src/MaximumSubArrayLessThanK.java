/**
 * Created by Aakash on 10/19/2016.
 */
public class MaximumSubArrayLessThanK {

    public int maxLength(int[] a, int k) {
        int max = 0;
        int sum = 0;
        int start = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
            if(sum <= k){
                if(max < i - start + 1) {
                    max = i - start + 1;
                }
            } else {
                while(sum > k && start < a.length){
                    sum -= a[start];
                    start++;
                }
            }
        }
        return max;
    }
}
