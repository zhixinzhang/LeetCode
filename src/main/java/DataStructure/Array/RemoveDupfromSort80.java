package DataStructure.Array;

/**
 * Created by zhang on 2017/1/11.
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length
 */
public class RemoveDupfromSort80 {
    public static int removeDuplicates(int[] nums) {//{11223}
        if(nums.length <=2) return nums.length;
        int len = 2;
        for(int i = 2;i<nums.length;i++){
            if(nums[i] != nums[len - 2]){
                nums[len++] = nums[i];
            }
        }
        return len;
    }

    public  static  void main(String args[]){

        int[] array = {1,1,1,2,2,3};
        removeDuplicates(array);

    }
}
