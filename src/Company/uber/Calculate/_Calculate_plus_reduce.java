package Company.uber.Calculate;

/**
 * Created by zhang on 2018/1/27.
 */
// 1 + 2 - 3 + 4
public class _Calculate_plus_reduce {
    public static int calculate(String s) {
        int len = s.length(), sign = 1, res = 0, num = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                if (i == len - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    res += sign * num;
                    num = 0;
                }
            } else { // + or -
                if (c == '+') sign = 1;
                if (c == '-') sign = -1;
            }
        }
        return res;
    }
    public static void main(String[] args){
        calculate("1+2-3+4-5");
    }
}
