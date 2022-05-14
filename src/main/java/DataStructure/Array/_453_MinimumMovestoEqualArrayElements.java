package DataStructure.Array;

//路。每次将数组中的n-1个数字加1，相当于将剩余的一个数字减1。所以只需找到数组中的最小值m，
// 计算m与数组中其他数字差的累计和即可
//https://www.cnblogs.com/VickyWang/p/6056587.html
//[1,2,3]
public class _453_MinimumMovestoEqualArrayElements{
	// 1 2 3  
	 public int minMoves(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int min= Integer.MAX_VALUE;  
        int sum = 0;  
        for(int n:nums){  
            min = Math.min(min, n);  
            sum+=n;  
        }  
        return sum-nums.length*min; 
    }
}