package Medium;

/**
 * Created by achaurasia on 8/31/16.
 */
public class Problem5_LongestPalindrome_Medium {
    public String longestPalindrome(String s) {
        int l = s.length();
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for(int i = 1; i < l; i++) {
            int j = 1;
            while((i - j) > -1 && (i + j) < l && s.charAt(i - j) == s.charAt(i + j)) {
                if(2*j + 1 > max) {
                    start = i - j;
                    end = i + j;
                    max = 2*j + 1;
                }
                j++;
            }

            if(s.charAt(i) == s.charAt(i-1)) {
                if(2 > max) {
                    start = i - 1;
                    end = i;
                    max = 2;
                }
                j = 1;
                while((i - j - 1) > -1 && (i + j) < l && s.charAt(i - j - 1) == s.charAt(i + j)) {
                    if(2*(j + 1) > max) {
                        start = i - j - 1;
                        end = i + j;
                        max = 2*(j + 1);
                    }
                    j++;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String args[]) {
        Problem5_LongestPalindrome_Medium problem =  new Problem5_LongestPalindrome_Medium();
        System.out.println(problem.longestPalindrome("aaaa"));
    }
}
