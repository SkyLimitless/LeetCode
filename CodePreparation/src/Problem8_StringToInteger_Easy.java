/**
 * Created by achaurasia on 9/1/16.
 */
public class Problem8_StringToInteger_Easy {
    public int myAtoi(String str) {
        double ans = 0;
        boolean l_space = false;
        boolean r_space = false;
        boolean minus =  false;
        boolean isMinus = false;
        boolean overflow = false;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                if(l_space) {
                    r_space = true;
                }
            } else if((str.charAt(i) == '-') && !minus) {
                minus = true;
                isMinus = true;
                l_space = true;
            } else if((str.charAt(i) == '+') && !minus) {
                minus = true;
                l_space = true;
            } else if(minus && (str.charAt(i) == '+') || (str.charAt(i) == '-')) {
                return 0;
            } else if(str.charAt(i) - '0' < 10 && !r_space) {
                minus = false;
                l_space = true;
                ans = ans*10 + str.charAt(i) - '0';
                if(ans > Integer.MAX_VALUE) {
                    overflow = true;
                    break;
                }
            } else {
                if(str.charAt(i) == ' ') {
                    return 0;
                }
                break;
            }
        }
        if(overflow && isMinus) {
            return Integer.MIN_VALUE;
        } else if (overflow && !isMinus) {
            return Integer.MAX_VALUE;
        } else if(isMinus) {
            return -1 * (int)ans;
        } else {
            return (int)ans;
        }
    }

    public static void main(String args[]) {
        Problem8_StringToInteger_Easy problem = new Problem8_StringToInteger_Easy();
        System.out.print(problem.myAtoi(" - 321"));
    }
}
