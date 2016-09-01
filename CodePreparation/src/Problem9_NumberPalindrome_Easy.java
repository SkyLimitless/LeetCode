/**
 * Created by achaurasia on 9/1/16.
 */
public class Problem9_NumberPalindrome_Easy {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        if(x < 10 && x >= 0) {
            return true;
        }
        int raise = (int) Math.log10(x);
        int result = x;
        int i = 0;
        while(result > 0) {
            int base = (int) (Math.pow(10, raise));
            if (result % 10 != result / base) {
                return false;
            } else {
                int temp1 = base*(int)Math.pow(10, i++);
                int temp2 = x%temp1;
                int temp3 = (int)Math.pow(10, i);
                result = temp2/temp3;
            }
            raise -= 2;
        }
        return true;
    }

    public boolean isPalindromeOptimized(int x) {
        if(x < 0) {
            return false;
        }
        if(x < 10 && x >= 0) {
            return true;
        }
        int n = (int)Math.log10(x) + 1;
        for(int i = 0; i < n/2; i++) {
            if((x/(int)Math.pow(10, i)) % 10 != (x/(int)Math.pow(10, n - i - 1))%10) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Problem9_NumberPalindrome_Easy problem = new Problem9_NumberPalindrome_Easy();
        System.out.print(problem.isPalindromeOptimized(10));
    }
}
