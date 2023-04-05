package DataStructure.String;

import java.util.Stack;

/**
 * Use stack to store all characters except right parenthesis
 * when we find a close parenthesis then we pop character
 * from stack
*/
public class _1106_ParsingABooleanExpression_Stack_Recursion {
    public boolean parseBoolExpr(String expression) {
        if (expression == null || expression.length() == 0) {
            return true;
        }

        Stack<Character> st = new Stack<>();
        for(char c : expression.toCharArray() ){
            if(c!=')'){
                st.push(c);
            }else{
                boolean hasTrue = false;
                boolean hasFalse = false;
                while(st.peek()!='('){
                    char check = st.pop();
                    //System.out.println(check);
                    if(check =='t'){
                        hasTrue = true;
                    }else if(check == 'f') {
                        hasFalse = true;
                    } 
                }
                
                st.pop();
                char op=st.pop();
                if(op == '&'){
                    st.push(hasFalse?'f':'t');
                    //System.out.println(hasFalse);
                }
                else if(op == '|')
                    st.push(hasTrue?'t':'f');
                else 
                    st.push(hasTrue?'f':'t');
            }
        }
        System.out.print(st.peek());
        return st.pop() == 't';
    }
}
