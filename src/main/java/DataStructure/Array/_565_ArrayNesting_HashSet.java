package DataStructure.Array;
import java.util.*;

//从多个起点到达同一个值之后的路径都是完全相同的，所以每个值最多遍历一次，时间复杂度O(N)，每次遍历到就加到set中
public class _565_ArrayNesting_HashSet{
    public static void main(String[] args){
        arrayNesting(new int[]{5,4,0,3,1,6,2});
    }

	static  HashSet<Integer> set = new HashSet();
    public static int arrayNesting(int[] nums) {
        int max = 0;  
        for (int i = 0; i < nums.length; i++) {  
            max = Math.max(max, check(nums, i));  
        }  
        return max;  
    }  
    private static int check(int[] nums, int k) {
        int res = 0;  
        while (!set.contains(k)) {  
            set.add(k);  
            k = nums[k];  
            res++;  
        }  
        return res;  
    }  
}