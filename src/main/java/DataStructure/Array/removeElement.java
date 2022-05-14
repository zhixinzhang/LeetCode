package DataStructure.Array;

/**
 * Created by zhang on 2017/1/17.
 */
public class removeElement {
    public static int removeElement(int[] nums, int target) {
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != target){
                nums[index++]  = nums[i];
            }
        }
        return  index;
    }







    public static void main(String args[]){

        int[] num = {-1,2,1,-4};
        int target  = 1;
        int result = removeElement(num,target);
    }
}
