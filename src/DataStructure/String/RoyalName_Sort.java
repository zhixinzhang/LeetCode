package DataStructure.String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhang on 2018/1/16.
 */
public class RoyalName_Sort {
    public static void main(String[] args){
        String[] names = {"Albert II","Polo IV","Alexander V","Elizabeth XXV",
                						  "Albert XL","Polo XLVI","William IX","Edward XXXIX",
                						  "Elizabeth XIX"};
        royalName(names);
    }
    private static String[] royalName(String[] s){
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String name1 = o1.split(" ")[0];
                String name2 = o2.split(" ")[0];
                int val1 = countRoyal(o1.split(" ")[1]);
                int val2 = countRoyal(o2.split(" ")[1]);
//                return name1.compareTo(name2);
                if (!name1.equals(name2)){
//                    int res = name2.compareTo(name1);
                    return name1.compareTo(name2);
                }else{
                    return val1 - val2;
                }
            }
        });
        int c = 0;
        return s;
    }
    private static int countRoyal(String s){
        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
    }
}
