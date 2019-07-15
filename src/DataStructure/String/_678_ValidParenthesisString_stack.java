package DataStructure.String;
import java.util.*;


public class _678_ValidParenthesisString_stack{
	public boolean checkValidString(String s) {
        // ((*())
        char[] len = new char[s.length()];
        len = s.toCharArray();
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        for(int i = 0;i<len.length;i++){
            if(len[i] == '('){
                st1.add(i);
            }else if(len[i] == '*'){
                st2.add(i);
            }else{
                if (!st1.isEmpty())  
                    st1.pop();  
                else if (!st2.isEmpty())  
                    st2.pop();  
                else   
                    return false;  
            }
        }
        
        while(!st1.isEmpty()){
            int n1 = st1.pop();
            if(st2.isEmpty())   return false;
            int n2 = st2.pop();
            if(n1 > n2) return false;
        }
        
        return true;
    }
}