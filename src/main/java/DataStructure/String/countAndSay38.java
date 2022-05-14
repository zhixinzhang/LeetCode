package DataStructure.String;

/**
 * Created by zhang on 2017/2/3.
 * 1, 11, 21, 1211, 111221, ...
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 */
public class countAndSay38 {
    public static String countAndSay(int n) {
        String result = "1";
        while (n-->0){
            result = say(result);
        }
        return  result;
    }

    private static  String say(String ss){
        String  result = "";
        Character cTmp = null;
        int numTMp = 0;

        for(int i = 0;i< ss.length();i++){   //21 --- 1211-- 111221--31221--13112211
            if(i == 0 && ss.charAt(i)!= '1'){
                result = result + "1"+String.valueOf(ss.charAt(i));
            }else{
                if(cTmp != null && cTmp != ss.charAt(i) ){
                    String num = String.valueOf(numTMp);
                    result = result + num + String.valueOf(cTmp);
                    cTmp = null;
                    numTMp = 0;
                }else if (cTmp != null && cTmp == ss.charAt(i)){
                    numTMp ++;
                    continue;
                }
                if(ss.charAt(i) == '1' ){
                    numTMp ++;
                }else{

                    if(cTmp == null){
                        result = result + String.valueOf(numTMp) + "1";
                        numTMp = 0;
                        cTmp = ss.charAt(i);
                        numTMp = 1;
                    }else {
                        result = result + String.valueOf(numTMp) + String.valueOf(cTmp);
                        cTmp = null;
                        continue;
                    }
                }
            }
        }
        result = result + String.valueOf(numTMp) + "1";

        return  result;
    }

//    String getNext(final String s) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length();) {
//            int j = notEqual(s, i);
//            sb.append(j - i);
//            sb.append(s.charAt(i));
//            i = j;
//        }
//        return sb.toString();
//    }
//    private static int notEqual(final String s, int fromIndex) {
//        final char target = s.charAt(fromIndex);
//        int i = fromIndex;
//        for (; i < s.length(); ++i) {
//            if (s.charAt(i) != target) break;
//        }
//        return i;
//    }

    public static void main(String args[]){
        int n = 2;
        countAndSay(n);
    }
}
