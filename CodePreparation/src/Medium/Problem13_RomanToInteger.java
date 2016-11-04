package Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by achaurasia on 11/3/16.
 */
public class Problem13_RomanToInteger {
    Map<Character, Integer> value = new HashMap<>();

    public void populateValue() {
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);
    }

    public int romanToInt(String s) {
        populateValue();
        char input[] = s.toCharArray();
        int result = 0;
        int i;
        for (i = 0; i < input.length - 1; i++) {
            int curr = value.get(input[i]);
            int next = value.get(input[i + 1]);
            if (curr < next) {
                result -= curr;
            } else {
                result += curr;
            }
        }
        result += value.get(input[i]);
        return result;
    }

    public static void main(String[] args) {
        Problem13_RomanToInteger problem13_romanToInteger = new Problem13_RomanToInteger();
        int result = problem13_romanToInteger.romanToInt("CIX");
        System.out.println("result = " + result);
    }
}
