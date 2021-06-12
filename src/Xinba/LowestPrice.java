package Xinba;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/5/2021 10:04 PM
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

import java.util.*;
import java.io.*;
/*
Yiteng Yu
2021
*/
public class LowestPrice {
    static double minVal = Double.MAX_VALUE;
    static double prevVal = 0;
    static String stockName = "";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("D:\\IdeaProjects\\LeetCode\\src\\Xinba\\input.txt"));
        double lowestPrice = lowestPrice(input);
        lowestPrice = Double.parseDouble(String.format("%.2f",lowestPrice));
        System.out.println("Lowest " + stockName + " price today : $" + lowestPrice);
    }


    private static double lowestPrice(Scanner input){
        stockName = input.next();
        minVal = Double.valueOf(input.next());
        prevVal = minVal;

        while (input.hasNext()){
            String a = input.next().trim();

            int i = 1;
            if (a.contains("-")) {
                i *= -1;
            } else if (a.contains("+")){
                i = 1;
            }

            String nextVal = input.next().trim();
            double c = i * Double.valueOf(nextVal);
            prevVal += c;
            minVal = Math.min(prevVal, minVal);
        }

        return minVal;
    }
}