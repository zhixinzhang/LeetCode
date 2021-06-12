package Xinba;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/5/2021 10:59 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class Sweep {
    public static void main(String[] args) {
        int[] a1 = {1, 6, 2, 7, 3, 6, 4};
        // 1 2 6 7 3 6 4
        // 1 2 6 3 7 6 4
        // 1 2 3 6
        System.out.println(sweep(a1));

        int[] a2 = {9, 4, 2, 1, 3, 12, 14, 6, 8};
        System.out.println(sweep(a2));

        int[] a3 = {3, 4, 8, 2, 1, 8, 8, 4, 12};
        System.out.println(sweep(a3));

        int[] a4 = {-1, -4, 17, 4, -1};
        System.out.println(sweep(a4));

        int[] a5 = {2, 3, 5, 7, 11, 13};
        System.out.println(sweep(a5));

        int[] a6 = {42};
        System.out.println(sweep(a6));
    }

    // TODO: Your Code Here -> Write a method
    // called sweep for this problem

    private static  boolean sweep(int[] a1){
        if (a1 == null || a1.length == 1)
            return true;

        boolean res = false;
        for (int i = 1; i < a1.length; i++){
            if (a1[i] < a1[i - 1]) {
                int temp = a1[i];
                a1[i] = a1[i - 1];
                a1[i - 1] = temp;
                res = true;
            }
        }

        return res;
    }
}
