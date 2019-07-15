package DataStructure.Array;

import java.util.Arrays;

/**
 * Created by zhang on 2017/12/14.
 */
public class _164_MaximumGap_BucketSort {

    public static int maximumGap(int[] num) {
        if (num == null || num.length == 0) return 0;
        if(num.length == 2) return Math.abs(num[0]-num[1]);
        int maxval = Integer.MIN_VALUE;
        int minval = Integer.MAX_VALUE;
        for (int i = 0; i<num.length;i++){
            if (num[i]>maxval) maxval = num[i];
            if (num[i]<minval) minval = num[i];
        }
        if (minval == maxval) return 0;
        int len = (int)Math.ceil((double)(maxval-minval)/(num.length-1));  //求解桶间差值,向上取整
        int n = (maxval - minval)/len;
        int maxBuk[] = new int[n+1];
        int minBuk[] = new int[n+1];

        Arrays.fill(maxBuk,Integer.MIN_VALUE);
        Arrays.fill(minBuk,Integer.MAX_VALUE);

        //桶映射
        for(int val:num){
            int temp = (val-minval)/len;
            maxBuk[temp] = Math.max(val,maxBuk[temp]);
            minBuk[temp] = Math.min(val,minBuk[temp]);
        }

        //求解最大gap,最大差值位于后桶的min-前桶的max
        int gap = 0;
        int pre = maxBuk[0];
        for(int i=1; i<=n; i++){
            if(maxBuk[i]==Integer.MIN_VALUE && minBuk[i]==Integer.MAX_VALUE){  //忽略空桶
                continue;
            }
            gap = Math.max(gap,minBuk[i]-pre);
            pre = maxBuk[i];
        }

        return gap;
    }
    public static void main(String[] args){
        maximumGap(new int[]{9,8,1,2,3});
    }
}
