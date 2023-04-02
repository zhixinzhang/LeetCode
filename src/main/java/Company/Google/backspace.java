package Company.Google;


import java.util.Stack;
// basic idea is kep an stack to store character.  if character == '<'  we pop the peek
// time complexity is O(n)  n is length od string
public class backspace{
    public static void main(String[] args){
        boolean a = judgeSame("<a<b<c","ab<<c");
    }
	public static boolean judgeSame(String s1, String s2){
			char[] c1 =  s1.toCharArray();
			char[] c2 =  s2.toCharArray();
            Stack<Character> stack = new Stack<>();
            Stack<Character> stack2 = new Stack<>();

        // a<b<c    ab<<c
			for (int i = 0; i<c1.length;i++ ) {
				if (c1[i] == '<') {
					if (stack.size()!=0)stack.pop();
				}else{
				    stack.push(c1[i]);
                }
			}

            for (int i = 0; i<c2.length;i++ ) {
                if (c2[i] == '<') {
                    if (stack2.size()!=0)stack2.pop();
                }else{
                    stack2.push(c2[i]);
                }
            }
            if (stack.equals(stack2)) return true;
			return true;
	}
}