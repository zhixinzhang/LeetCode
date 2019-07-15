package company.uber;

import DataStructure.Array.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/20/19
 * Time: 12:47 PM
 * Description:
 *
 * https://leetcode.com/problems/interval-list-intersections/
 */


public class _986_IntervalListIntersections {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new Interval[] {};
        }

        int m = A.length, n = B.length;
        int i = 0, j = 0;
        List<Interval> res = new ArrayList<>();
        while (i < m && j < n) {
            Interval a = A[i];
            Interval b = B[j];

            // find the overlap... if there is any...
            int startMax = Math.max(a.start, b.start);
            int endMin = Math.min(a.end, b.end);

            if (endMin >= startMax) {
                res.add(new Interval(startMax, endMin));
            }

            //update the pointer with smaller end value...
            if (a.end == endMin) { i++; }
            if (b.end == endMin) { j++; }
        }

        //thanks EOAndersson for the concice expression of converting a list to an array
        //thanks Sithis for the explaination of using toArray (new T[0]) intead fo toArray newT[size])
        return res.toArray(new Interval[0]);
    }
}
