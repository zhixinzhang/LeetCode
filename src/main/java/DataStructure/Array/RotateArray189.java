package DataStructure.Array;

/**
 * Created by zhang on 2017/1/30.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 123456  k = 1   612345
 */
public class RotateArray189 {
    public static void rotate(int[] nums, int k) {
            k = k%nums.length;
            int[] numsTmp = new int[k];//1234;
            int[] numsTmp2 = new int[nums.length - k];
            for(int i = nums.length - k,m = 0;i<nums.length;i++,m++)
                    numsTmp[m] = nums[i];
            for(int i = 0,m = 0;i<numsTmp2.length && m<nums.length-k;i++,m++)
                numsTmp2[i] = nums[m];

            for (int i = 0,m = 0,j=0;i<nums.length;i++){
                if (m<numsTmp.length){
                    nums[i] = numsTmp[m];
                    m++;
                }else if(j<numsTmp2.length){
                    nums[i] = numsTmp2[j];
                    j++;
                }
            }

            //nums[] =1234567   ----  5674567  //   123456  ---  6 23456
//            for(int i = 0,j = nums.length-k;j<nums.length || i<k;i++,j++){
//                nums[i] = nums[j];
//            }
//            //5671234
//            for(int i = 0,m = k;i<numsTmp.length && m<nums.length;i++,m++ ){
//                nums[m] = numsTmp[i];
//            }

    }



//    public static void rotate(int[] nums, int k) {
//        k = k%nums.length;
//        if (nums.length > k){
//            int[] numsTmp = new int[k+1];//1234;
//            for(int i =0;i<k+1;i++){
//                if (nums.length>i){
//                    numsTmp[i] = nums[i];
//                }
//            }
//            //nums[] =1234567   ----  5674567
//            for(int i = 0,j = nums.length-k;j<nums.length || i<k;i++,j++){
//                nums[i] = nums[j];
//            }
//            //5671234
//            for(int i = 0,m = k;i<numsTmp.length && m<nums.length;i++,m++ ){
//                nums[m] = numsTmp[i];
//            }
//        }else if (k>nums.length){
//            for(int i = 0,j = nums.length-1; i<nums.length-1 && j<nums.length;i++,j--){
//                int tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = tmp;
//                int a = 0;
//
//            }
//        }else {
//            nums = nums;
//        }
//    }



    public  static  void  main(String args[]){
//            int[] nums = {1,2,3,4,5,6};
//            int k = 1;
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
            rotate(nums,k);

    }
}
