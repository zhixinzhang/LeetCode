package DataStructure.String;

/**
 * Created by zhang on 2018/4/26.
 */
public class SortedMergeofStrings {
    public static String merger(String s1, String s2){
        StringBuilder res = new StringBuilder();
        if (s1.length() == 0 || s2.length() == 0)
            return res.toString();
        String s3 = s1 + s2;
        int[] arr = new int[26];
        for(int i = 0; i < s3.length();i++){
            if (s3.charAt(i)<'a' || s3.charAt(i)>'z')
                continue;
            int index = (int)s3.charAt(i)-'a';
            arr[index] ++;
        }
        for (int i = 0; i<arr.length;i++){
            while (arr[i] > 0){
                arr[i]--;
                Character c = (char)(i+'a');
                res.append(c);
            }
        }
        return res.toString();
    }
    public static void main(String[] args){
        String a = merger("a&bcdhhmca","aaadefs");
        System.out.println(a);
    }
}
