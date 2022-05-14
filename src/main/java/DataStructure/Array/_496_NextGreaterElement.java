package DataStructure.Array;
import java.util.*;



public class  _496_NextGreaterElement{
	//O(n)
	// map  : num next greater 
	    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
			HashMap<Integer, Integer> map = new HashMap<>();
	    	Stack<Integer> stack = new Stack<>();
	    	for (int num : nums2) {
	    		while (!stack.isEmpty() && stack.peek() < num) {
	    			map.put(stack.pop(),num);
	    		}
	    		stack.push(num);
	    	}
	    	int[] res = new int[nums1.length];
	    	for(int i = 0;i<nums1.length;i++){
	    		res[i] = map.getOrDefault(nums1[i],-1);
	    	}
	    	return res;
	    }	


		//O(n^2)
	    public int[] nextGreaterElement_BruteForce(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if(nums2 == null || nums2.length == 0) return res;
        
        for(int i = 0; i<nums1.length;i++){
            for(int j = 0; j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    res[i] = find(nums1,nums2,i,j);
                    break;
                }
            }
        }
        return res;
        
    }
    private int find(int[] nums1, int[] nums2, int i,int j){
        for(int k = j; k<nums2.length;k++){
            if(nums2[k] > nums1[i]){
                return nums2[k];
            }
        }
        
        return -1;
    }
}