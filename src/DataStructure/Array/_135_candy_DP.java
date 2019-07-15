package DataStructure.Array;

import java.util.Arrays;

/**
 * Created by zhang on 2017/11/14.
 * There are N children standing in a line. Each child is assigned a rating value.
 You are giving candies to these children subjected to the following requirements:
 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */
public class _135_candy_DP {
    //分别左右 循环扫一遍 然后相加最大值
    //  5 4 3 3 2 4 5 3 2
    //  4 3 2 2 1 2 3 2 1

    public static int candy(int[] ratings) {

        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        left[0] = 1;
        right[ratings.length - 1] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }

    public static void main(String[] args){
        int[] ra = new int[]{1,0,2,3,1};
        candy(ra);
    }

    public static int candy_1D(int[] ratings){
        int res = 0;
        //
        if (ratings == null || ratings.length == 0)
            return res;
        int m = ratings.length;
        int[] candy = new int[m];
        Arrays.fill(candy,1);
        // scan from left to right
        for (int i = 0; i < m-1; i++){
            if (ratings[i] < ratings[i+1])
                candy[i+1] = candy[i]+1;
        }
        for (int i = m - 2; i >= 0; i--){
            if (ratings[i] > ratings[i+1])
                candy[i] = Math.max(candy[i],candy[i+1]+1);
        }
        for (int i : candy){
            res += i;
        }
        return res;
    }
}
