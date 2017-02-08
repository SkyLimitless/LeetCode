package Hard;

/**
 * Created by Aakash on 1/28/2017.
 */
public class Problem214_ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1, end = s.length() - 1;
        if(s.length() < 2) {
            return s;
        }
        char[] chs = s.toCharArray();
        while(i < j) {
            if(chs[i] == chs[j]) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().append(s).toString();
    }

    public static void main(String[] args) {
        Problem214_ShortestPalindrome shortestPalindrome = new Problem214_ShortestPalindrome();
        String out = shortestPalindrome.shortestPalindrome("aacecaaa");
        System.out.println("out = " + out);
    }
}
