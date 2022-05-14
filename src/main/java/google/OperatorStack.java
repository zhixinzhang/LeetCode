package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
举了几个例子：
"3" -> 3
"( + 1 2 )" -> 3
"( + 3 4 5 )" -> 12
"( + 7 ( * 8 12 ) ( * 2 ( + 9 4 ) 7 ) 3 )" -> ...
**/

public class OperatorStack{
	
	public int math(String s){
		if(s == null || s.length() == 0) return 0;
		//keep an stack
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		for(int i =1;i<s.length();i++){
			if(s.charAt(i) != ' '){
			while(stack.size() != 0){
				if(s.charAt(i) == ')'){
//				char curChar = count(stack);
				}else{
					stack.push(s.charAt(i));
				}
			}
		}
}
		return 0;
}
// 7 ( * 8 12  
//		private char count(Stack stack){
//			char oper,timeNum = ' ';
//			List<Character> list = new DataStructure.ArrayList<>();
//			while(stack.size()!=0){
//				if(stack.peek().equals( '+') || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/'){
////					oper = stack.pop().;
////					timeNum = stack.pop().pop();
//					break;
//		}else{
//			list.add(stack.pop());
//		}
}


	//char to integer
	
//	if(oper == ‘+’){
//			int res = 0;
//			for(int i = 0; i<list.size();i++){
//		res = res + DataStructure.Integer.valueOf(list.get(i));
//	}
//return (char)res;
//}





