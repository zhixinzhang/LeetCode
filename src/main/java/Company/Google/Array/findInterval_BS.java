package Company.Google.Array;

/**
 * Created by zhang on 2018/6/24.
 * 第二道是查找一串值是不是在一列 interval 里，interval 没有重叠并且排好了序。
 * 我表示 binary search 就可以，然后让实现了一下，也是秒了。然后聊了聊 TensorFlow
 */
public class findInterval_BS {
    public boolean[] solution(int[] nums, int[][] intervals){
        boolean[] res = new boolean[nums.length];
        //[1 3  5  8] [1,2] [5,7] [10,20]
        for (int i = 0; i<nums.length; i++){
            res[i] = bs(nums[i],intervals);
        }
        return res;
    }
    public boolean bs(int a, int[][] intervals){
         if (a < intervals[0][0] || a > intervals[intervals.length-1][1]) return false;
         int left = 0, right = intervals.length -1;
         while (left < right){
             //[1 3  5  8,100] [1,2] [5,7] [10,20] [21 25] [26 27]
             // l = 0 r = 4  mid = 2
             // l = 3 r = 4  mid = 3
             //l = 4



            int mid = left + (right - left) / 2;
            int[] cur = intervals[mid];
            if (cur[0] <= a && cur[1] >= a)
                return true;
            if (cur[0] > a)
                right = mid-1;
            else if (cur[1] < a)
                left = mid+1;
         }
         return false;
    }
}
