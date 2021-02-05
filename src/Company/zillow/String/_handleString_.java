package Company.zillow.String;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhang on 2018/8/18.
 */
public class _handleString_ {
    public static void main(String[] args){
//        handleString("asdf,asdf/,asdf,//asdf");
        handleString("asdf,////asd///f");

    }
    public static List<String> handleString(String s){
        String[] res = s.split(",");
        LinkedList<String> list = new LinkedList<>();
        String pre = "";
        for (String str : res){
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            boolean f = false;
            for (int i = 0; i<chars.length; i++){
                if (chars[i] == '/' && i+1 == chars.length){
                    sb.append(',');
                    f = true;
                    pre += sb.toString();
                    break;
                }else if (chars[i] != '/'){
                    sb.append(chars[i]);
                }else {
                    if (i + 1 != chars.length && chars[i+1] != '/'){
                        sb.append('/');
                    }
                }
            }
            if (!f){
                String curS = pre+sb.toString();
                list.addLast(curS);
                pre = "";
            }
        }
        return list;
    }
}
