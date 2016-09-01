/**
 * Created by achaurasia on 9/1/16.
 */
public class Problem6_ZigZagConversion_Easy {
    public String convert(String s, int numRows) {
        int len = s.length();
        if(numRows == 1 || len < numRows) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int buffer = 2*(numRows - 1);
        for(int i = 0; i < numRows; i++) {
            result.append(s.charAt(i));
            int j = i;
            while(j < len) {
                if(i > 0 && i < numRows - 1) {
                    int second = j + 2 * (numRows - i - 1);
                    if(second < len) {
                        result.append(s.charAt(second));
                    }
                }

                j += buffer;
                if(j < len) {
                    result.append(s.charAt(j));
                }
            }
        }
        return result.toString();
    }

    public static void main(String args[]) {
        Problem6_ZigZagConversion_Easy problem = new Problem6_ZigZagConversion_Easy();
        System.out.println(problem.convert("", 1));
    }
}
