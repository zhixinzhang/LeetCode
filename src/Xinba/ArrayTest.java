package Xinba;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/5/2021 11:13 PM
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

public class ArrayTest {

    public static void main(String[] args) {
        int[] list1 = {1, 3, 5, 8, 12, 1, 3, 17, 1, 3, 6,
                9, 1, 3, 6};
        int[] list2 = {1, 3, 6};

        System.out.println(indexOf(list2, list1));
        System.out.println(indexOf(list1, list2));
    }

    // TODO: Your Code Here -> Write a method
    // called indexOf for this problem

    private static int indexOf(int[] list1, int[] list2){
        if (list1  == null || list2 == null || list1.length < list2.length)
            return -1;

        for (int i = 0; i < list1.length; i++){
            for (int j = 0; j < list2.length; j++){

                if (list1[i] == list2[j]){
                    if(j == list2.length - 1)
                        return i - j;
                    i ++;
                    continue;
                } else {
                    break;
                }
            }
        }

        return -1;
    }

}
