package Hard;

import java.util.Stack;

/**
 * Created by Aakash on 2/7/2017.
 */
public class Problem224_BasicCalculator {
    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c > 47 && c < 58) {
                sb.append(c - '0');
            } else if (c == 43) {
                sb.append('+');
            } else if (c == 45) {
                sb.append('-');
            }
        }
        s = sb.toString();
        String[] str = s.replace('+', ' ').split(" ");
        int res = 0;
        for (String ss : str) {
            int temp = 0;
            boolean first = true;
            String sstr[] = ss.split("-");
            for (String sss : sstr) {
                if(first) {
                    temp = Integer.parseInt(sss);
                    first = false;
                } else {
                    temp -= Integer.parseInt(sss);
                }
            }
            res += temp; 
        }
        return res;
    }

    public int calc(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        int sign = 1;
        int res = 0;
        for (char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if(c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if(c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if(c == '(') {
                st.push(res);
                st.push(sign);
                sign = 1;
                res = 0;
            } else if(c == ')') {
                res += sign*num;
                num = 0;
                res *= st.pop();
                res += st.pop();
            }
        }
        res += num*sign;
        return res;
    }

    public static void main(String[] args) {
        Problem224_BasicCalculator calculator = new Problem224_BasicCalculator();
        int res = calculator.calculate("(1+(4+5+2)-3)+(6+8)");
        res = calculator.calculate("0-2147483647");
        res = calculator.calculate("2-(5-6)");
        System.out.println("res = " + res);
    }
}
