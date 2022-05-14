package DataStructure.String;

/**
 * Created by zhang on 2017/3/12.
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return  new String("");
        String result = strs[0];
        if (strs.length ==1) return  strs[0];
        if (strs.length == 2) return findLong(strs[0],strs[1]);
        for(int i = 0;i<strs.length-1;i++){
            if (i+1< strs.length){
                String lonStr = findLong(strs[i],strs[i+1]);
                result = result.length()>lonStr.length()?lonStr:result;
            }
        }
        return result;
    }

    private static  String findLong(String s1, String s2){
        String lonString = "";
        for(int i =0,j=0;i<s1.length() && j<s2.length();i++,j++ ){
            if (s1.charAt(i) == s2.charAt(j)){
                lonString = lonString + String.valueOf(s1.charAt(i));
            }else{
                break;
            }
        }
        return  lonString;
    }

    public static void main(String args[]){
//        String[] strs = {"comme","commnkop","commmm","commq"};
        String[] strs = {"a","a","b"};


        longestCommonPrefix(strs);
    }
}
