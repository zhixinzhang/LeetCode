package DataStructure.Stack;
/**
 * Created by zhang on 2017/9/26.
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 */
import java.util.Stack;
/**逆波兰  适用于计算机  先进后出 FILO Stack
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * */
public class _150_StackEvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<String>  sc = new Stack<>();
        for(String token:tokens){
            if(!isOp(token)){
                sc.push(token);
            }else {
                int y = Integer.parseInt(sc.pop());
                int x = Integer.parseInt(sc.pop());
                switch (token.charAt(0)){
                    case '+':x += y;break;
                    case '-':x -= y;break;
                    case '*':x*= y;break;
                    default:x/=y;
                }
                sc.push(String.valueOf(x));
            }
        }
        return  Integer.parseInt(sc.peek());
    }
    private static  String OPS  = new String("+-*/");
    private  static boolean isOp(String op){
        return  op.length() == 1 && OPS.indexOf(op)!=-1;
    }


        public static void main(String args[]){
            String[] a = {"0","3","/"};
            int re = evalRPN(a);
        }
}
