package Company.uber.Calculate;

/**
 * Created by zhang on 2018/1/27.
 */
// 6 + 3 * 2 + 4 / 2 + 1
// if we use stack the space time complexity O(n) not use stack
// we define 2 integer  curVal and resValue
//for loop String from left to right
//
public class _Calculate_plus_reduce_times_division {


    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int num = 0;
        char sign = '+';
        int curr = 0, res = 0; //important, use curr to store value of last segment.
        s= s.replaceAll(" " ,"");
        int len = s.length();

        for (int i = 0; i < len; i++) {
//            if (s.charAt(i) == ' ') continue;
            if (!Character.isDigit(s.charAt(i))) {
                num = 0;
                sign = s.charAt(i);
                if (sign == '+' || sign == '-') {
                    res += curr;
                    curr = 0; // not necessary
                }
            } else {
                num = num * 10 + s.charAt(i) - '0';
                if (i == len - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    if (sign == '+') curr = num;
                    if (sign == '-') curr = -num;
                    if (sign == '*') curr *= num;
                    if (sign == '/') curr /= num;
                }
            }
        }
        res += curr; // add last segment
        return res;
    }
    public static void main(String[] args){
        calculate(" 3/2 ");
//        calculate("62+3 * 2 + 4 / 2 + 1");
    }
}
