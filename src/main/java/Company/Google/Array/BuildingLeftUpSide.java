package Company.Google.Array;

import java.util.Arrays;

/**
 * Created by zhang on 2018/6/26.
 * 第二轮的排序就是，题意如果理解的充分的话，那么其实就是两个数组，可以凑出来的每一对数字组pair,对每一对的组合求最小值之后累加就可以了。那么在此基础上，可以通过排序使得用两个指针就可以做到预测这一对数字组合的结果，就是数组A的数字比数组B小的时候，直接把A*j加入总和就可以了,反之加A[j]*(len-j)。em，大概的思路就是这样。。具体细节的话，有个地方很容易出bug。走走testcase就行了。。
 这里就能凸显交流的重要性，其实我一开始是不知道要排序的，我也只是大概其想了想，排序可能会有所帮助，就半信半疑的问考官，排序有没有帮助呢，我还没说，考官就帮我回答了，说"对的,排序就行了,那么排完序呢"。我就顺势说，我觉得排序之后呢，blabla，没解释清楚，考官给hint说，你看看之前的方法，为什么能保证答案正确呢，答因为枚举了每一个pair，那我就get了，
 可以用排序的方法来预测每一组的pair的结果。所以。就成功优化了。
 * http://www.1point3acres.com/bbs/thread-317571-5-1.html
 *  2 5 4 3 6      2 3 4 5 6
 *  1 2 6 3 1      1 1 2 3 6
 *  4 3 5 2 1      1 2 3 4 5
 *
 * [4 5 6 3 6]    [2 3 4 5 6]
 * [6 6 5]        [6 6 5]
 *
 *[3 4 5 6 6]
 *[5 6 6]
 *
 排序最重要的作用在于预测答案。。这样就不用二重循环来得出sum（min(a,b[j]))了，
 而是可以预测min的结果，这样，就不用二重循环了
 */
public class BuildingLeftUpSide {
    public int solution(int[][] nums, int[] left, int[] up){
        if(nums == null || nums.length == 0 || nums[0].length == 0) return 0;
        int res = 0;
        int m = left.length;
        int n = up.length;
        for (int i = 0; i<m; i++){
            for (int j = 0; j < n; j++){
                res += Math.min(up[j],left[i]);
            }
        }
        return res;
    }
    public int solution_Sort(int[][] nums, int[] left, int[] up) {
        Arrays.sort(left);
        Arrays.sort(up);
        int res = 0;
        int m = left.length;
        int n = up.length;
        int[] preSum = new int[n]; preSum[0] = up[0];
        for (int i = 1; i<n; i++) preSum[i] = preSum[i-1] + up[i];
        for (int i = 0; i < m; i++){
               int l = 0, r = n-1;
               while (l < r){
                   int mid = l + (r - l)/2;
                   if (up[mid] > left[i])
                       r = mid - 1;
                   else if(up[mid] < left[i])
                       l = mid + 1;
               }
               res += preSum[l];
               res += (n-l) * Math.min(left[i],up[l]);
        }
        return res;
    }
}
