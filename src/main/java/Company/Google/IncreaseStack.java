package google;

import java.util.Stack;

/**http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=301466&extra=page%3D3%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311*/
public class IncreaseStack{
//【69，73，68，81，82】[  1 2  1 1 -1 ]
public int[] find(int[] nums){
		int[] res = new int[nums.length];
		//keep Stack to store data
		Stack<Integer> stack = new Stack<>();
		stack.push(nums[0]);
		int curMax = nums[0];
		for(int i = 1; i<nums.length;i++){
			// 73 68 81
			if(stack.size()!=0 && curMax<nums[i]){
			curMax = nums[i];
			//i = 3	
			int curIndex = i;
			int count  = 0;
				for(Integer s : stack){
					res[--curIndex] = ++count; 
				}
			}else{
				stack.push(nums[i]);
			}

		}

		return res;
}



}