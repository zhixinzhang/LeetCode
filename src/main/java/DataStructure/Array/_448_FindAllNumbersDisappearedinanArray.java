package DataStructure.Array;
import java.util.*;
/**
 * Created by zhang on 2017/12/19.
 */
//https://www.cnblogs.com/grandyang/p/6222149.html
//首先来看第一种解法，这种解法的思路路是，对于每个数字nums[i]，如果其对应的nums[nums[i] - 1]是正数，我们就赋值为其相反数，如果已经是负数了，就不变了，那么最后我们只要把留下的整数对应的位置加入结果res中即可
public class _448_FindAllNumbersDisappearedinanArray {
    public static void main(String[] args){
        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        //[4,3,2,7,8,2,3,1]
        //4 3 2 -7 8 2 3 1
        //4 3 -2 -7
        //
        List<Integer> result = new ArrayList<Integer>();
        for( int i=0;i< nums.length; i++){
            int index = nums[i];
            if(nums[Math.abs(index)-1] > 0){
                nums[Math.abs(index)-1]= -nums[Math.abs(index)-1];
            }
        }

        for(int j =1 ;j <= nums.length ; j++){
            if(nums[j-1] > 0){
                result.add(j);
            }
        }
        return result;
    }
}
