package Company.Houzz;

/**
 * Created by zhang on 2017/10/20.
 */

import java.util.Arrays;

/**{1,2,6,8,5,4};  ----  128456  就是找到下一个 比他大的数
 * 首先从后往前search nums[i] > nums[i-1] 第一个降序的数 8 跟 6 互换 128654
 * 然后 654 从小到大排列
 * */
public class _31_NextPermutation {
    public static void nextPermutation(int[] nums) {
        if(nums.length==0) return;
        int i=nums.length-1;
        for(;i>0;i--){
            if(nums[i]>nums[i-1]) break;
        }
        if(i==0) {              // 3 2 1
            Arrays.sort(nums);
//            reverse(nums,0,nums.length-1);     自己写的reverse方法  用了递归 很好可以看看
            return;
        }
        int first=i-1; //the first num need to be swapped.
        int nextbig=nums[i];
        int nextbig_index=i;
        for(int j=i+1;j<nums.length;j++){
            if(nextbig>=nums[j]&&nums[j]>nums[first]){
                nextbig=nums[j];
                nextbig_index=j;
            }
        }
        swap(nums,first,nextbig_index);
        Arrays.sort(nums,first+1,nums.length);
//        reverse(nums,first+1,nums.length-1);
    }
    private static void reverse(int[] nums, int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    private static void swap(int[] nums, int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
    public static void main(String[] args){
        int[] nums = {1,2,6,8,5,4};
        nextPermutation(nums);
        int a = 0;
    }
}

