package google.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhang on 2018/7/27.
 */
public class SortFile {
    public static void main(String[] args){
//        String[] strings = new String[]{"a1.doc", "a1.doc123","a1b.doc", "a2.doc",
//                "a12.doc","a1.0.1.doc"};
        String[] strings = new String[]{"a1.doc","a1.0.1.doc"};
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] c1 = o1.toCharArray();
                char[] c2 = o2.toCharArray();
                for (int i = 0; i < o1.length(); i++){
                    if (i >= o2.length() || i >= o1.length()){
                        return o1.length() - o2.length();
                    } else{
                        if (c1[i] == c2[i])
                            continue;
                        else if (c1[i] != '.' && c2[i] != '.'){ // a1.10.0   a1.2.0
                            if (c1[i]>='0' && c1[i]<='9' && c2[i]>='a' && c2[i]<='Z'){
                                return 1;
                            }else if (c1[i]>='0' && c1[i]<='9' && c2[i]>='a' && c2[i]<='Z'){
                                return -1;
                            }
                        }else if (c1[i] != '.' || c2[i] != '.'){
                            return c2[i] - c1[i];
                        }

                    }
                }
                return -1;
            }
        });
        for (String s : strings){
            System.out.println(s);
        }
    }
}
