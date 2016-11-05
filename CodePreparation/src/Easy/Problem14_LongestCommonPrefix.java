package Easy;

/**
 * Created by Aakash on 11/5/2016.
 */
public class Problem14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs.length > 0) {
            for (int i = 0; i < strs[0].length(); i++) {
                char t = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || strs[j].charAt(i) != t) {
                        return sb.toString();
                    }
                }
                sb.append(t);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem14_LongestCommonPrefix longestCommonPrefix = new Problem14_LongestCommonPrefix();
        String str[] = {"aakash", "aakasbh", "aakasu", "aakajk"};
        String res = longestCommonPrefix.longestCommonPrefix(str);
        System.out.println("res = " + res);
    }
}
