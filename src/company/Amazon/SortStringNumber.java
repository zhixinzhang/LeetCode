package company.Amazon;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/19/19
 * Time: 10:01 PM
 * Description:
 */


public class SortStringNumber {

    public static void main(String[] args){
        String[] nums = new String[]{"123","45","23.67", "23"};
        double[] dd = new double[nums.length];
        int i = 0;
        for (String s : nums)
             dd[i++] = Double.parseDouble(s);
        Arrays.sort(dd);
        i = 0;
        for (double d : dd)
            nums[i++] = String.valueOf(d);
        String s4 = String.valueOf(1233);

        System.out.println(dd);
    }
}
