package company.Houzz;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by zhang on 2018/1/18.
 */
// + - * /  有负号 negative
public class BasicCalculatorNegative {
    public static int calculate(String input) {
        // 1 + 2 * 3 /4 + 6 / 1 + 2
        int num = 0;
        char prev_sign = '+';
        int negative = 1;
        input = input.replaceAll(" ","");
        if(input == null || input.length() == 0) return num;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i<input.length(); i ++){
            char c = input.charAt(i);
            if (Character.isDigit(c)){              //find digit
                num = num * 10 + (c -'0');
            }

            if(i == input.length() - 1 || !Character.isDigit(c)){   // include negative
                if(c == '-' &&(i == 0 || !Character.isDigit(input.charAt(i-1)))){  //  1 + 2 - -3
                    negative = -1;
                    continue;
                }
                if(prev_sign == '+'){
                    stack.offerLast(negative * num);
                }else if(prev_sign == '-'){
                    stack.offerLast(-1 * num * negative);
                }else if(prev_sign == '*'){
                    int temp = stack.pollLast();
                    stack.offerLast(temp * num * negative);
                }else if(prev_sign == '/'){
                    int temp = stack.pollLast();
                    stack.offerLast(temp / num * negative);
                }
                num = 0;
                prev_sign = c;
                negative = 1;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pollLast();
        }
        return  res;
    }
}
