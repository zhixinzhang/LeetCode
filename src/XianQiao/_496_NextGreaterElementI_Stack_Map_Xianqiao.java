package XianQiao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class _496_NextGreaterElementI_Stack_Map_Xianqiao {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums2){
            while(!stack.isEmpty() && stack.peek() < i){
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int j = 0; j < nums1.length; j++){
            if (map.containsKey(nums1[j])){
                res[j] = map.get(nums1[j]);
            }
        }
        return res;
    }
}
