package DataStructure.Array;
import java.util.*;
//[3,1,2,1]  -1,2,3,3
//3 1 2 1 3 1 2 1  -1,2,3,3  
//[5 3 1 2 4] 
// peek 5
//

//用stack 存index 并且重点是 n*2 和 i%n
public class _503_NextGreaterElement2{
    public int[] nextGreaterElements(int[] nums) {
    	int n = nums.length, next[] = new int[n];
    	Arrays.fill(next,-1);
    	Stack<Integer> stack = new Stack<>();
    	for(int i = 0; i<n*2; i++){
    		int num = nums[i%n];
    		while(!stack.isEmpty() && nums[stack.peek()] < num){
    			next[stack.pop()] = num;
    		}
    		if(i < n) stack.push(i);
    	}
    	return next;
    }
}