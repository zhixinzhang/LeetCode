package DataStructure.Integer;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/12/2021 12:11 AM
 * <p>
 * Description: https://leetcode.com/problems/sqrtx/submissions/
 * Similar task :
 * Key Point: Binary Search
 */

public class _69_Sqrt_BS {

    public static void main (String [] args){
        mySqrt_BS(4);
    }
    public static int mySqrt_BS(int x) {
        if (x < 2)
            return x;

        int l = 2, r = x/2;
        int mid = 0;
        while (l <= r){
            mid = l + (r - l) / 2;
            if ((long)mid * mid < x) {
                l = mid + 1;
            } else if ((long)mid * mid == x) {
                return mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public int mySqrt(int x) {

        int res = (int)Math.sqrt(x);
        return res;
    }
}
