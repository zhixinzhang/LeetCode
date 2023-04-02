package google.Array;

/**
 * Created by zhang on 2018/6/5.
 *
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=426234&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26searchoption%5B3109%5D%5Bvalue%5D%3D1%26searchoption%5B3109%5D%5Btype%5D%3Dradio%26sortid%3D311
 */
public class maxDistanceinBus {
    //[1 0 0 1 0 1 0 0 0 0 0 ]  O(1) O(n)
    public static int findMaxDitance(int[] arr){
        if(arr == null || arr.length <= 1)  return arr.length;
        int left = 0, right = 0,maxDis = 0;
        for (;right<arr.length;){
            //[0 0 0 0 0 1]
            if (left == 0 && arr[left] == 0){
                while (right+1 < arr.length && arr[right] == 0){
                    right++;
                }
                maxDis = Math.max(maxDis,right);
                left = right;
                right++;
                continue;
            }
            // [1 1      ]
            if (arr[left] == 1 && left + 1 < arr.length){
                // location i
                while(left + 1 < arr.length && arr[left+1] == 1 ){
                    left++;
                }
                right = left+1;
                while (right < arr.length-1 && arr[right] == 0){
                    right++;
                }
                if (arr[right] == 0)
                    maxDis = Math.max(maxDis,right- left);
                else
                    maxDis = Math.max(maxDis, (right - left)/2);
                left = right;
                right++;
            }
        }
        return maxDis;
    }
    public static void main(String[] args){
//        findMaxDitance(new int[]{0,0,1,0,0,1,0,0,0,0,0});
        findMaxDitance_twoloop(new int[]{1,0,0,1,0,1,0,0,0,0,0,1});
    }
    // 这种方法一定要想到1 0 0 0 0 怎么算这种情况
    // 我的思路：先从左到右把数组扫一遍，记录每个0点左边最近的1，存到left[]。
    //然后从右到左再扫一遍，记录每个0点右边最近的1，存到right[]。
    // 如果右面没有1那么要设值为arr的长度
    public static int findMaxDitance_twoloop(int[] arr){
        int[] maxToLeft = new int[arr.length];
//        int[] maxToRight = new int[arr.length];
        int left = 0;
        int res = 0;
        for (int i = 0; i< arr.length; i++){
            if (arr[i] == 1){
                maxToLeft[i] = 0;
                left = i;
            }else{
                maxToLeft[i] = i - left;
            }
        }
        left = arr.length;
        //      1,0,0,1,0,1,0,0,0,0,0 1
        //left  0 1 2 0 1 0 1 2 3 4 5 0
        //right 0 2  1 0 1 0 7 8 9 10 11
        for (int i = arr.length-1; i>=0; i--){
            if (arr[i] == 1){
                left = i;
            }else{
                if (left == arr.length)
                    res = Math.max(Math.min(i,maxToLeft[i]),res);
                else
                    res = Math.max(Math.min(left - i,maxToLeft[i]),res);
            }
        }
        return res;
    }
}
