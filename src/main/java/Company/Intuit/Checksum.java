package Company.Intuit;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string "5 7 8 9 \n 8 7 6 \n 4 5 6", differentiate rows from \n and find the largest and smallest number and return a sum of the largest and smallest numbers for each row. Return sum of all the numbers from each row.
 * 
*/
public class Checksum {
    public static void main(String[] args) {
        checkSum("5 7 8 9 \n" + //
                "8 7 6 \n" + //
                "4 5 6");
    }

    private static void checkSum(String input){
        List<Integer> lists = new ArrayList<>();
        String[] rows = input.split("\n");
        for (String row : rows){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            String[] val = row.split(" ");
            for (String v : val){
                int curVal = Integer.parseInt(v);
                max = Math.max(curVal, max);
                min = Math.min(curVal, min);
            }

            lists.add(max + min);
        }

        System.out.println();
    }
}
