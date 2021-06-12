package Xinba;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/5/2021 11:43 PM
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

public class Weave {
    public static void main(String[] args) {
//        int[] a1 = {1, 2, 3};
//        int[] a2 = {4, 5, 6};
//        System.out.println(Arrays.toString(weave(a1, a2)));

        int[] b1 = {1, 2, 3, 4, 5, 6};
        int[] b2 = {7, 8, 9};
        System.out.println(Arrays.toString(weave(b1, b2)));
    }

    // TODO: Your Code Here -> Write a method
    // called weave for this problem

    private static int[] weave(int[] a1, int[] a2){
        if (a1 == null || a2 == null)
            return a1 == null ? a2 : a1;

        int[] a3 = new int[a1.length + a2.length];
        int shortL = Math.min(a1.length, a2.length);
        for (int i = 0; i < shortL; i++){
            a3[i * 2] = a1[i];
            a3[i * 2 + 1] = a2[i];
        }

        for (int i = shortL; i < a1.length; i++)
            a3[i + shortL] = a1[i];

        for (int i = shortL; i < a2.length; i++){
            a3[i + shortL] = a2[i];
        }

        return a3;
    }
}
