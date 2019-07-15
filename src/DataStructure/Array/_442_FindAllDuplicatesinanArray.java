package DataStructure.Array;
import java.util.*;

//Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), 
//some elements appear twice and others appear once.
/**1. 一组数范围在［0， n] 每个数都存在， 有的数出现一次， 有的数出现两次，输出所有出现两次的数 O(n) time, O(1) space
 居然不是top K， 上来有点懵， 稳了一下问他说可不可以改变数组元素的位置， 说可以。 就尝试扫一遍， 没到array[i] != i 的时候就交换 array[i] 和array[array[i]]
 知道相等。 最后所有array[i] != i的数就是重复的数。因为每次交换都会使一个位置出现array[i] ＝= i 的情况， 最多n 次交换 time O(n)
 * */
public class _442_FindAllDuplicatesinanArray{

	    public List<Integer> findDuplicates(int[] nums) {
	    	List<Integer> res = new ArrayList<>();
	    	if(nums == null || nums.length == 0) return res;

	    	for(int i = 0; i<nums.length;i++){
	    		int cur = Math.abs(nums[i])-1;
	    		if(nums[cur] < 0){
	    			res.add(nums[i]);
	    		}else{
	    			nums[i] = -nums[i];
	    		}
	    	}
	    	return res;
	    }
}