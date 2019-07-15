package company.Houzz;
import java.util.Deque;
import java.util.LinkedList;

// (11 + (21 * 3 + 4 - 1)) * 3 + 2 - 1 /5
/**
 * Created by zhang on 2018/1/18.
 */
public class BasicCalculator3_stack {
    public static void main(String[] args){
        calculate3("(11 + (21 * 3 + 4 - 1)) * 3 + 2 - 1 /5");
    }
    public static int calculate3 (String input) {
        input = input.replaceAll(" ", "");
        if (input == null || input.length() == 0) return 0;
        // if have bracket first consider bracket
        int num = 0;
        char prev_sign = '+';
        int negative = 1;
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);

            if (Character.isDigit(c)) {      // digit
                num = num * 10 + (c - '0');
            }

            if (i == input.length() - 1 || !Character.isDigit(c)) {
                if (c == '-' && (i == 0 || (!Character.isDigit(input.charAt(i - 1))))) {
                    if (i == 0 || input.charAt(i - 1) != ')') {
                        negative = -1;
                        continue;
                    }
                }


                if (c == '(') {
                    int count = 1;
                    int start = i;
                    i++;
                    while (i < input.length() && count > 0) {
                        c = input.charAt(i);
                        if (c == '(') {
                            count++;
                        } else if (c == ')') {
                            count--;
                        }
                        i++;
                    }
                    i = i - 1;
                    String sub_input = input.substring(start + 1, i);
                    num = calculate3(sub_input);
                    if (i == input.length() - 1)
                        i = i - 1;
                    continue;
                }
                if (prev_sign == '+') {
                    stack.offerLast(negative * num);
                } else if (prev_sign == '-') {
                    stack.offerLast(negative * num * -1);
                } else if (prev_sign == '*') {
                    int temp = stack.pollLast();
                    stack.offerLast(temp * negative * num);
                } else if (prev_sign == '/') {
                    int temp = stack.pollLast();
                    stack.offerLast(temp / (negative * num));
                }
                num = 0;
                prev_sign = c;
                negative = 1;
            }
        }
        int result = 0;
        while (!stack.isEmpty()){
            result += stack.pollLast();
        }
        return  result;
    }

}
