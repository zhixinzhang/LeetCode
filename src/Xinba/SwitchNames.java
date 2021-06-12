package Xinba;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/5/2021 10:45 PM
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

public class SwitchNames {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("D:\\IdeaProjects\\LeetCode\\src\\Xinba\\input.txt"));
        switchNames(input);
    }

    private static void switchNames(Scanner input){
        String preVal = input.nextLine();
        List<String> ans = new ArrayList<>();
        ans.add(preVal);

        while (input.hasNextLine()){
            String curVal = input.nextLine();
            if (curVal.contains("name:")) {
                String curLine = input.nextLine();
                String[] arr = curLine.split(",");
                String res = "";
                for (int i = arr.length - 1; i >= 0; i--){
                    res += arr[i] + " ";
                }
                ans.add(res.trim());
            } else if (curVal.contains("If there is time")){
                ans.add(curVal);
            }
        }

        for (String s : ans){
            System.out.println(s);
        }
    }
}
