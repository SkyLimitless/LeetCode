package Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aakash on 12/17/2016.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        constructParentheses(list, "", 0, 0, n);
        return list;
    }

    private void constructParentheses(List<String> list, String s, int i, int i1, int n) {
        if(s.length() == n*2) {
            list.add(s);
            return;
        }
        
        if(i < n) {
            constructParentheses(list, s + "(", i + 1, i1, n);
        }
        if(i1 < i) {
            constructParentheses(list, s + ")", i, i1 + 1, n);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> res = generateParentheses.generateParenthesis(4);
        for (Iterator<String> iterator = res.iterator(); iterator.hasNext(); ) {
            String next =  iterator.next();
            System.out.println("next = " + next);
        }
    }
}
