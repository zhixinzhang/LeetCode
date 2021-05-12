import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 5/10/2021 11:25 PM
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

public class HasAlternatingParity {
    public static void main(String[] args) {
//        System.out.println(hasAlternatingParity(12345));
//        System.out.println(hasAlternatingParity(692785634));
//        System.out.println(hasAlternatingParity(2340));
//        System.out.println(hasAlternatingParity(3));
//        System.out.println(hasAlternatingParity(669));
//        System.out.println(hasAlternatingParity(242));
//        System.out.println(hasAlternatingParity(0));
        System.out.println(hasAlternatingParity(100));
    }

    // TODO: Your Code Here -> Write a method
    // called hasAlternatingParity for this problem

    private static boolean hasAlternatingParity(int number){
        if (number <= 10) {
            return true;
        }
        int prev = -1;
        while (number >= 10){
            if (prev == -1) {
                prev = number % 10;
            } else {
                int curPrev = number % 10;
                // 12345   prev :5  curPre 4
//                if (curPrev % 2 == 0 && prev % 2 == 0 || curPrev % 2 == 1 && prev % 2 == 1) {
                int c = Math.abs(curPrev - prev) % 2;
                if (Math.abs(curPrev - prev) % 2 == 1) {
                    prev = curPrev;
                } else {
                    return false;
                }
            }
            number /= 10;
        }

        return Math.abs(number - prev) % 2 == 1;
    }
}
