package DataStructure.String;
import java.util.*;


/**
 * we can use two stacks to solve this problem
 * one stack to store left  parenthesis 
 * one stack to store star sign
 * 
*/
public class _678_ValidParenthesisString_stack_twoPointer{
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

    public boolean checkValidString_twoPointer(String s) {
        int cmax = 0, cmin = 0;
        for(Character c : s.toCharArray()){
            if(c == '('){
                cmax++;
                cmin++;
            }else if(c == ')'){
                cmax--;
                cmin--;
            }else if(c == '*'){
//         There are two chances '(' or ')' hence we are using two counts
                cmax++;
                cmin--;
            }
            if(cmax < 0) return false;
            cmin = Math.max(cmin, 0);
        }
        return cmin == 0;
    }
}