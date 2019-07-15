package DataStructure.Array;

/**
 * Created by zhang on 2017/1/26.
 * 对于每个柱子，找到其左右两边最高的柱子，该柱子能容纳的面积就
 是 min(max_left, max_right) - height 。所以，
 1. 从左往右扫描一遍，对于每个柱子，求取左边最大值；
 2. 从右往左扫描一遍，对于每个柱子，求最大右值；
 3. 再扫描一遍，把每个柱子的面积并累加。
 也可以，
 1. 扫描一遍，找到最高的柱子，这个柱子将数组分为两半；
 2. 处理左边一半；
 3. 处理右边一半。
 *
 *
 */
public class TrappingRainWater46 {
//{0,1,0,2,1,0,1,3,2,1,2,1};

    public static int trap(int[] height) {
        int water = 0;
        final  int  n = height.length;
        int peak_index = 0 ; //
        for(int i = 0;i<n;i++){
            if (height[i] > height[peak_index]) peak_index = i;
        }

        for(int i = 0 ,left_peak = 0;i<peak_index ;i++){
            if (height[i] > left_peak) left_peak = height[i];
            else water += left_peak - height[i];
        }

        for(int i = n-1 ,right_peak = 0;i>peak_index ;i--){
            if (height[i] > right_peak) right_peak = height[i];
            else water += right_peak - height[i];

        }
        return water;
    }





//    public static int trap(int[] height) {
//        int result = 0;
//        int curHeight = 0;
//        List<DataStructure.Integer> curL = new DataStructure.ArrayList<DataStructure.Integer>();
//        if (height.length<=1) return  result;
//        //找到最大值
//        int max
//        for(int i = 0; i<height.length;i++){
//            if(i+1< height.length){
//
//            }
//        }
//        for(int i = 0;i<height.length;i++){
//
//            if(i+1<height.length && height[i]>= height[i+1]){
//                curHeight = height[i];
//                if(curL.size() != 0 && curL.get(0)<height[i]){
//                    curL.set(0,height[i]);
//                }else{
//                    curL.add(curHeight);
//                }
//                result = result +(curL.get(0) - height[i+1]);
//            }else{
//                curL.clear();
//            }
//        }
//        return  result;
//    }





    public static void main(String args[]){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
         trap(height);

    }

}
