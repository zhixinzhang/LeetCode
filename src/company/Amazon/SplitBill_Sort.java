package company.Amazon;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/4/19
 * Time: 4:42 PM
 * Description:
 */


public class SplitBill_Sort {
    public static void main(String[] args){
        //50
        split(new String[]{"A","B","C","D"}, new int[]{90,70, 40,0});
    }
    static class People{
        String name;
        int bill;
        public People(String name, int bill){
            this.name = name;
            this.bill = bill;
        }
    }
    static List<String[]> plan = new ArrayList<>();
    public static void split(String[] names, int[] bill){
        if (names == null || names.length == 0 || bill == null || bill.length == 0)
            return;
        int i = 0;
        List<People> peoples = new ArrayList<>();
        int average = 0;
        for (String name : names){
            peoples.add(new People(name, bill[i]));
            average += bill[i];
            i++;
        }
        Collections.sort(peoples, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.bill - o2.bill;
            }
        });
        int l = 0, r = peoples.size() - 1;
        average /= names.length;
        while (l <= r){
            People pr = peoples.get(r);
            People pl = peoples.get(l);
            if (pl.bill == average){ l++; continue;}
            if (pr.bill == average){ r--; continue;}
            int sumDifL = 0;
            int sumDifR = 0;
            if (pr.bill > average)
                sumDifR = pr.bill - average;
            if (pl.bill < average)
                sumDifL = average - pl.bill;
            if (sumDifL < sumDifR){
                plan.add(new String[]{pr.name, pl.name, String.valueOf(sumDifL)});
                l++;
                pl.bill = average;
                pr.bill -= sumDifL;
            } else{
                plan.add(new String[]{pr.name, pl.name, String.valueOf(sumDifR)});
                r--;
                pr.bill = average;
                pl.bill += sumDifR;
            }
        }
        int c = 0;
    }
}
