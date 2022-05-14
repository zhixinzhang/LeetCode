package Company.Houzz;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by zhang on 2018/1/18.
 */
// + - * / ^
public class BasicCalculate4 {
    public static int calculate4 (String input) {
        input = input.replaceAll(" ", "");
        if (input == null || input.length() == 0) return 0;
        int num = 0;
        Deque<Integer> operand = new LinkedList<>();
        Deque<Character> operator = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        map.put('^',3);
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);

            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }else{
                operand.offerLast(num);
                num = 0;
                if(operator.size() == 0 || map.get(c) > map.get(operator.peekLast())){
                    operator.offerLast(c);
                }else{
                    while (!operator.isEmpty() && map.get(c) <= map.get(operator.peekLast())){
                        helper(operand,operator);
                    }
                    operator.offerLast(c);
                }
            }
        }
        operand.offerLast(num);
        while (!operand.isEmpty()){
            helper(operand,operator);
        }
        return operand.pollLast();
    }

    public static void helper(Deque<Integer> operand, Deque<Character> operator){
        int b = operand.pollLast();
        int a = operand.pollLast();
        int op = operator.pollLast();
        if(op == '+'){
            operand.offerLast(a + b);
        }else if (op == '-'){
            operand.offerLast(a - b);
        }else if (op == '*'){
            operand.offerLast(a * b);
        }else if (op == '/'){
            operand.offerLast(a / b);
        }else if (op == '^'){
            operand.offerLast((int)Math.pow(a,b));
        }
        return;
    }
}
