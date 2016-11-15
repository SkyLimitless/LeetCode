package Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aakash on 11/14/2016.
 */
public class Problem17_LetterCombinationOfAPhoneNumber {
    public static void main(String[] args) {
        Problem17_LetterCombinationOfAPhoneNumber letter = new Problem17_LetterCombinationOfAPhoneNumber();
        String digits = "59";
        List<String> list = letter.letterCombinations(digits);
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String next =  iterator.next();
            System.out.println("next = " + next);
        }
    }
    public List<String> result= new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() > 0)
        generateCombo(digits);
        return result;
    }

    private void generateCombo(String digits) {
        char t = digits.charAt(0);
        int extra = 0;
        if (t == '7' || t == '9') {
            extra = 1;
        }
        char start = 'a';
        if (t > '7') {
            start += (t - '2') * 3 + 1;
        } else {
            start += (t - '2') * 3;
        }
        int len = result.size();
        if (len == 0) {
            for (int j = 0; j < 3 + extra; j++) {
                result.add("" + start++);
            }
        } else {
            for (int i = 0; i < len; i++) {
                String temp = result.remove(0);
                for (int j = 0; j < 3 + extra; j++) {
                    result.add(temp + start++);
                }
                start -= 3 + extra;
            }
        }
        if(digits.length() > 1) {
            generateCombo(digits.substring(1));
        }
    }
}
