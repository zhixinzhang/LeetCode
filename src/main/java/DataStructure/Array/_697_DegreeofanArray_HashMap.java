package DataStructure.Array;
import java.util.*;

public class _697_DegreeofanArray_HashMap{
    public static void main(String[] args){
        int[] nums = new int[]{1,2,2,3,1,4,2};
        findShortestSubArray_Map(nums);
    }


	 public static int findShortestSubArray_Map(int[] nums) {
        int maxCount = 0;
        int res = 1;
        HashMap<Integer,Integer> countMap = new HashMap<>();  // num  degree
        HashMap<Integer,Integer> firstIndexMap = new HashMap<>(); //num index
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int firstIndex = firstIndexMap.getOrDefault(num, -1);
            if(firstIndex == -1) {
                firstIndexMap.put(num, i);
                countMap.put(num,1);
            } else {
                int count = countMap.get(num) + 1;
                if(count > maxCount) {
                    res = i - firstIndex + 1; 
                    maxCount = count;
                } else if(count == maxCount) {
                    res = Math.min(res, i - firstIndex + 1);
                }
                countMap.put(num, count);
            }
        }
        return res;

    }
}