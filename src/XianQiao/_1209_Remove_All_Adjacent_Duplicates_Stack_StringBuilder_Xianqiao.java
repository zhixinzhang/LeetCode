package XianQiao;
/**
@Author: Xianqiao
@Date: 3/28/20 17:28
*/

import java.util.Stack;

public class _1209_Remove_All_Adjacent_Duplicates_Stack_StringBuilder_Xianqiao {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++){
            if (i == 0 || sb.charAt(i) != sb.charAt(i-1)){ //sb.charAt(i)
                stack.push(1);
            } else{
                int num = stack.pop() + 1;
                if (num == k){
                    sb.delete(i - k + 1, i + 1);
                    i = i - k; //在这一轮 i 回到被删减序列的前一个数，等重新进loop时会+1，这样正好是删减后的下一位
                } else{
                    stack.push(num);
                }
            }
        }
        return sb.toString();
    }
}
