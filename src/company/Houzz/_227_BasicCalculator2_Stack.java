package company.Houzz;

/**
 * Created by zhang on 2018/1/17.
 */

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 */
//+ - * /
public class _227_BasicCalculator2_Stack {
    public static void main(String[] args){
        calculate("112 + 2 * 3 /4 + 6 / 1 + 2");
    }
    public static int calculate(String input) {
        // 1 + 2 * 3 /4 + 6 / 1 + 2
        int num = 0;
        char prev_sign = '+';
        input = input.replaceAll(" ","");
        if(input == null || input.length() == 0) return num;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i<input.length(); i ++){
            char c = input.charAt(i);
            if (Character.isDigit(c)){              //find digit
                num = num * 10 + (c -'0');
            }
            if(i == input.length() - 1 || !Character.isDigit(c)){
                if(prev_sign == '+'){
                    stack.offerLast(num);
                }else if(prev_sign == '-'){
                    stack.offerLast(-1 * num);
                }else if(prev_sign == '*'){
                    int temp = stack.pollLast();
                    stack.offerLast(temp*num);
                }else if(prev_sign == '/'){
                    int temp = stack.pollLast();
                    stack.offerLast(temp / num);
                }
                num = 0;
                prev_sign = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pollLast();
        }
        return  res;
    }
}
