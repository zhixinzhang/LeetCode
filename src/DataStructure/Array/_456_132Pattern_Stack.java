package DataStructure.Array;
import java.util.*;

//建一个栈来维持一个单调子序列，倒序扫描。
public class _456_132Pattern_Stack{
    public boolean find132pattern(int[] nums) {
        // [1, 5, 4, 2]   i < j < k  ai < aj < ak
        // i      3    2    1   0
        //stack   2    4    4    
        //s2      min  2    5
        //[1, 2, 3, 4]
        int s2 = Integer.MIN_VALUE;  
        Stack<Integer> stack = new Stack<>();  
      	for(int i = nums.length-1; i>=0 ; i--){
      		if(s2 > nums[i]) return true;
      		while(!stack.isEmpty() && nums[i] > stack.peek()){
      			s2 = stack.pop();
      		}
      		stack.push(nums[i]);
      	}
        return false;  
    }

}