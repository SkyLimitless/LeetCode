package Hard;

/**
 * Created by Aakash on 1/10/2017.
 *
 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false
 */
public class Problem44_WildcardMatching {
    public static void main(String[] args) {
        Problem44_WildcardMatching wildcardMatching = new Problem44_WildcardMatching();
        if (wildcardMatching.isMatch("zacabz", "*a?b*")) {
            System.out.println("Regex matched");
        } else {
            System.out.println("Regex not matched");
        }
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if(p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*' && (dp[i][j - 1] || dp[i - 1][j])) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
