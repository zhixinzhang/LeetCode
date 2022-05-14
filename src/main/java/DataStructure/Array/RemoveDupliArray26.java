package DataStructure.Array;

/**
 * Created by zhang on 2017/1/10.
 */
public class RemoveDupliArray26 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length ==0) return  0;
        int index = 1;
        for(int i = 1;i<nums.length;i++){
            if (nums[i] != nums[index-1]){

                nums[index++] = nums[i];
            }
        }
        return index;
    }





    public  static  void main(String args[]){

        int[] array = {1,1,2,3};
        removeDuplicates(array);

    }
}
