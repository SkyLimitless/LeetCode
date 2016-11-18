package Easy;

import java.util.Stack;

/**
 * Created by achaurasia on 11/18/16.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Problem20_ValidParantheses {
    public static void main(String[] args) {
        Problem20_ValidParantheses validParantheses = new Problem20_ValidParantheses();
        boolean result = validParantheses.isValid("()");
        System.out.println("validParantheses = " + result);
    }

    public boolean isValid(String s) {
        char[] ca = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character c : ca) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if(stack.empty()) {
                    return false;
                }
                Character temp = stack.pop();
                if((c == ')' && temp != '(') || (c == '}' && temp != '{') || (c == ']' && temp != '[')) {
                    return false;
                }
            }
        }

        if(stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
