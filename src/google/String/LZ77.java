package google.String;

/**
 * Created by zhang on 2018/6/26.
 * http://www.1point3acres.com/bbs/thread-317571-1-1.html
 * ABRA DABRA KADABRA 压缩后:ABRA D|tag|len|offset| KA|tag|len|offset
 * ABRA D\tag\4\6\ KA\tag\5\8
 * ABRA DABRA KA
 *  有压缩后的字符串，还原原来的。时间复杂度O(N) 。tag就是一个标记，len是引用了多长，offset是这个字符串往前数多少个是同一个字符串。
 *  这个有一定的小trick，一个是会有地址偏移，一个是可以引用引用，如例子所示。要考虑引用的地址偏移
 followup原文中遇到tag怎么办.我的答案|tag|tag.留学论坛-一亩-三分地
 考官答案|tag|0 压缩效率更好
 写出来了之后还有几分钟聊天时间
 *
 */
public class LZ77 {

    public static String LZ(String s){
        if (s.indexOf('\\') == -1) return s;
        String res = "";
        int tagIndex = s.indexOf('\\');
        char[] chars = s.toCharArray();
        res = s.substring(0, tagIndex);
        res = recur(tagIndex,chars,res);
        return res;
    }
    //ABRA D\tag\4\6\ KA\tag\5\8
    public static String recur(int tagIndex, char[] chars, String res){
        int len = 0, offSet = 0;
        int i = tagIndex + 5;
        for (;i<chars.length; i++){
            char c = chars[i];
            if (c != '\\')
                len = len *10 + c - '0';
            else
                break;
        }
        i++;
        for (;i<chars.length;i++){
            char c = chars[i];
            if (c != '\\')
                offSet = offSet *10 + c - '0';
            else
                break;
        }
        String tagString = res.substring(tagIndex - offSet,tagIndex-offSet+len);
        res += tagString;
        String newS = res + new String(chars).substring(i,chars.length);
        return recur(i,newS.toCharArray(),res);
    }






//    static String res = "";
//    static String cc ="";
//    public static String solution(String s){
//        for (int i = 0; i<s.length(); i++){
//            if (s.charAt(i) != '\\')
//                res += s.charAt(i);
//            else{
//                i = unCompresion(i,res,s);
//                char c = s.charAt(i);
//                res = cc;
//                s = res;
//            }
//
//        }
//        return res;
//    }
//    //ABRA D\tag\4\6\ KA\tag\5\8
//    public static int unCompresion(int i, String res, String s){
//        int curIndex = i;
//        i += 5;
//        int len = 0;
//        int offSet = 0;
//        for (;i<s.length(); i++){
//            char c = s.charAt(i);
//            if (s.charAt(i) != '\\')
//                len = len *10 + s.charAt(i) - '0';
//            else
//                break;
//        }
//        i++;
//        for (;i<s.length();i++){
//            char c = s.charAt(i);
//            if (s.charAt(i) != '\\')
//                offSet = offSet *10 + s.charAt(i) - '0';
//            else
//                break;
//        }
//        i--;
//        String tagString = res.substring(curIndex - offSet,curIndex-offSet+len);
//        res += tagString;
//        res += s.substring(i,s.length());
//        cc = res;
//        return i;
//    }
    public static void main(String[] args){
        LZ("ABRA D\\tag\\4\\6\\ KA\\tag\\5\\8");
    }
}
