package Company.Google.Array;

import java.util.Stack;

/**
 * Created by zhang on 2018/6/12.
 * https://zh.wikipedia.org/wiki/%E6%B3%A2%E5%85%B0%E8%A1%A8%E7%A4%BA%E6%B3%95
 */
// 波兰表达式  * + 5 6 - 1 2
// (5 + 6) * (1 - 2)
public class PolishNotation_stack {
    public int solution(String[] s){
        Stack<String> stack = new Stack<>();
        Stack<Integer> val = new Stack<>();
        for (String c : s){
            if (c == "+" || c == "-" || c == "*" || c == "/"){
                stack.add(c);
            }else{
                int cur = 0;
                if (c.charAt(0) == '-'){
                    cur = -1 * Integer.parseInt(c.substring(1,c.length()));
                }else{
                    cur = Integer.parseInt(c.substring(1,c.length()));
                }
                if (val.isEmpty()){
                    val.push(cur);
                }else{
                    int pre = val.pop();
                    String op = stack.pop();
                    switch (op){
                        case "+" : pre += cur; break;
                        case "-" : pre -= cur; break;
                        case "*" : pre *= cur; break;
                        case "/" : pre /= cur; break;
                    }
                    val.push(pre);
                }
            }
        }
        return val.pop();
    }
}
