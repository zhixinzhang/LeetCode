package google.String;

import java.util.Stack;

/**
 * Created by zhang on 2018/6/26.
 * http://www.1point3acres.com/bbs/thread-317571-1-1.html
 * a(b(c){2}){2}d
 */
public class decodeString_Stack {
    public static String soltion(String s){
        if (s == null || s.length()<=1) return s;
        char[] arr = s.toCharArray();
        Stack<String> stack = new Stack<>();
        //a(b(c){2}){2}d
        for (int i = 0; i<arr.length; i++){
            if (arr[i]>='a' && arr[i] <= 'z'){
                stack.push(String.valueOf(arr[i]));             //a b
            }else if (arr[i] == '('){
                continue;                     //( (
            }else if (arr[i] == ')'){
                i = timeCharacter(arr,i,stack);
                String curS1 = stack.pop();
                String curS2 = stack.pop();
                stack.push(curS2 + curS1);
            }
        }
        StringBuilder c = new StringBuilder();
        while (!stack.isEmpty()){
            StringBuilder sb = new StringBuilder(stack.pop());
            c.append(sb.reverse());
        }
        return c.reverse().toString();
    }
    public static int timeCharacter(char[] arr, int i, Stack<String> stack){
        if (arr[i + 1] != '{')
            return i;
        int num = 1;
        if (arr[i+1] == '}')
            num = 1;
        else
            num = arr[i+2] - '0';
        String curS = stack.pop();
        while (num > 1){
            curS+= curS;
            num--;
        }
        stack.push(curS);
        i+=3;
        return i;
    }

    public static void main(String[] args){
        soltion("a(b(c){2}){2}d");
    }
}
