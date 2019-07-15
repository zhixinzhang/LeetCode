package company.uber;

import java.util.Stack;

/**
 * Created by zhang on 2018/9/16.
 * follow up 是可以有负数的情况
 */
public class _772_BasicCalculator3_followUp {
    //
    public static void main(String[] args){
        calculate_followUp("5 - (-3 / 3 + 1) * 2"); // 1
    }
    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> nums = new Stack<>(); // the stack that stores numbers
        Stack<Character> ops = new Stack<>(); // the stack that stores operators (including parentheses)
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = c - '0';
                // iteratively calculate each number
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                nums.push(num);
                num = 0; // reset the number to 0 before next calculation
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                // do the math when we encounter a ')' until '('
                while (ops.peek() != '(') nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                ops.pop(); // get rid of '(' in the ops stack
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && precedence(c, ops.peek())) nums.push(operation(ops.pop(), nums.pop(),nums.pop()));
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private static int operation(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b; // assume b is not 0
        }
        return 0;
    }
    // helper function to check precedence of current operator and the uppermost operator in the ops stack
    private static boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }

    //比如5 - 21 * 3  , 5 - (-21) * 3, -5 - (-21) * 3, 第一个表达式中的'-'减号，第二个表达式中(-21)表示负数，第三个表达式中-5也是负数。

    public static int calculate_followUp(String s){
        if (s == null || s.length() == 0) return 0;
        s = s.replaceAll(" ","");
        Stack<Integer> count = new Stack<>();
        Stack<Character> op = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if ((cur == '-' && i == 0) || (cur == '-' && s.charAt(i-1) == '(')) {         //handle negative
                int[] res = findInteger(++i,0,s, -1);
                i = res[0];
                count.push(res[1]);
            }else if (Character.isDigit(cur)){              // positive
                int[] res = findInteger(i,0,s, 1);
                i = res[0];
                count.push(res[1]);
            }else if(cur == '('){
                op.push('(');
            }else if (cur == ')'){                  //calcul
                // do the math when we encounter a ')' until '('
                while (op.peek() != '('){
                    count.push(operation(op.pop(), count.pop(), count.pop()));

                }
                op.pop(); // get rid of '(' in the ops stack
            } else if (cur == '+' || cur == '-' || cur == '*' || cur == '/') {
                while (!op.isEmpty() && precedence(cur, op.peek())) count.push(operation(op.pop(), count.pop(),count.pop()));
                op.push(cur);
            }
        }
        while (!op.isEmpty()) {
            count.push(operation(op.pop(), count.pop(), count.pop()));
        }
        return count.pop();
    }
    public static int[] findInteger(int i, int num,String s, int n){
        num = n * (s.charAt(i) - '0');
        while (i < s.length()-1 && Character.isDigit(s.charAt(i+1))){
            num = num * 10 + s.charAt(i+1) - '0';
            i++;
        }
        return new int[]{i,num};
    }


}
