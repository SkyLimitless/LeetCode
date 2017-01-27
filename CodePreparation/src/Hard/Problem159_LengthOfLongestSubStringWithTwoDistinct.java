package Hard;

import java.util.HashMap;

/**
 * Created by Aakash on 1/26/2017.
 */
public class Problem159_LengthOfLongestSubStringWithTwoDistinct {
    
    public int twoDistincts(String s) {
        if(s.length() < 1) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int low = 0, high = 0, max = 0;
        
        while (high < s.length()) {
            if(map.size() <= 2) {
                map.put(s.charAt(high), high++);
            }
            if(map.size() > 2) {
                int lmost = s.length();
                for(int i : map.values()) {
                    lmost = Math.min(lmost, i);
                }
                map.remove(s.charAt(lmost));
                low = lmost + 1;
            }
            max = Math.max(max, high - low);
        }
        return max;
    }

    public static void main(String[] args) {
        Problem159_LengthOfLongestSubStringWithTwoDistinct lengthOfLongestSubStringWithTwoDistinct = new Problem159_LengthOfLongestSubStringWithTwoDistinct();
        int len = lengthOfLongestSubStringWithTwoDistinct.twoDistincts("aakash");
        System.out.println("len = " + len);
    }
}
