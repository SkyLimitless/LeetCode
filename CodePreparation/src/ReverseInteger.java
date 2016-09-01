/**
 * Created by achaurasia on 9/1/16.
 */
public class ReverseInteger {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(Math.abs(x) + "");
        if(sb.length() < 2) {
            return x;
        }
        try {
            if (x < 0) {
                return Integer.parseInt("-" + sb.reverse());
            } else {
                return Integer.parseInt(sb.reverse() + "");
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int reverseOptimize(int x) {
        boolean negative = x < 0;
        if(negative) {
            x = -1 * x;
        }

        int ans = 0;
        while(x > 0) {
            if(ans > Integer.MAX_VALUE/10) {
                return 0;
            }
            ans = ans*10 + x%10;
            x = x/10;
        }
        if(negative) {
            ans = -1 * ans;
        }
        return ans;
    }

    public static void main(String args[]){
        ReverseInteger rev = new ReverseInteger();
        System.out.print(rev.reverseOptimize(-123));
    }
}
