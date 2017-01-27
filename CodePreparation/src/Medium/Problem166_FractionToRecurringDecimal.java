package Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aakash on 1/26/2017.
 */
public class Problem166_FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        if(numerator == 0) {
            return "0";
        }

        res.append(((numerator > 0 ^ denominator > 0) ? "-" : ""));
        long numer = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);
        res.append(numer/denom);
        long num = numer%denom;
        if(num == 0) {
            return res.toString();
        }
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(num != 0) {
            map.put(num, res.length());
            num *= 10;
            res.append(num/denom);
            num %= denom;
            if(map.containsKey(num)) {
                int pos = map.get(num);
                res.insert(pos, '(');
                res.append(')');
                break;
            }
        }
        return res.toString();
    }
}
