import java.util.HashMap;
import java.util.Map;

/**
 * Created by achaurasia on 8/30/16.
 */
public class Problem3_LengthOfLongestSubstring_Medium {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int len = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);
            Integer prev = map.get(temp);
            if(prev == null) {
                map.put(temp, i);
                len++;
            } else if ( prev < start ) {
                map.replace(temp, i);
                len++;
            } else {
                if(len > max) {
                    max = len;
                }
                start = prev + 1;
                len = i - prev;
                map.replace(temp, i);
            }

        }
        if(len > max) {
            max = len;
        }
        return max;
    }

    public static void main(String args[]) {
        Problem3_LengthOfLongestSubstring_Medium problem3 = new Problem3_LengthOfLongestSubstring_Medium();
        System.out.println(problem3.lengthOfLongestSubstring("abcdefghcaijkla"));
    }
}
