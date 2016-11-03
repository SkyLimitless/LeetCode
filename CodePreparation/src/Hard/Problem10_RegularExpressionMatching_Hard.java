package Hard;

/**
 * Created by achaurasia on 9/9/16.
 */
public class Problem10_RegularExpressionMatching_Hard {

    public boolean isMatch(String s, String p) {
        int index = 0;
        int sLen = s.length();
        int pLen = p.length();
        char currChar = p.charAt(index);
        char prev = '\0';
        for(int i = 0; i < sLen; i++) {
            char strChar = s.charAt(i);
            currChar = p.charAt(index);
            if(currChar == '.') {
                index++;
                prev = '\0';
            } else if(currChar == '*') {

            } else if(currChar == strChar) {
                index++;
                prev = strChar;
            } else {
                return false;
            }
        }
        return true;
    }
}
