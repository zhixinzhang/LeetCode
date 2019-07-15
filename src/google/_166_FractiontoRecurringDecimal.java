package google;

import java.util.HashMap;

/**
 * Created by zhang on 2018/5/14.
 *        // -1 / 3 = -0.(3333333333.......)
 //
 */
public class _166_FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        // in case overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(sign);
        result.append(num / den);
        long reminder = num % den;
        if (reminder == 0)
            return result.toString();
        result.append(".");

        HashMap<Long,Integer> hm = new HashMap<>();
        while (!hm.containsKey(reminder)){
            hm.put(reminder,result.length());
            result.append(10 * reminder / den);
            reminder = 10 * reminder % den;
        }
        int index = hm.get(reminder);
        result.insert(index, "(");
        result.append(")");
        return result.toString().replace("(0)", "");

    }
}
