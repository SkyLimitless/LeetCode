package Easy;

/**
 * Created by Aakash on 1/25/2017.
 */
public class Problem66_plusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        for (int i = 0; i < digits.length; i++) {
            res[i + 1] = digits[i];
        }
        res[0] = 1;
        return res;
    }
}
