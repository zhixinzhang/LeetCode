package Company.Amazon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/11/19
 * Time: 1:09 PM
 * Description:
 *
 * https://leetcode.com/problems/reorder-log-files/
 */


public class _937_ReorderLogFiles_Sort {
    public static void main(String[] args){
        reorderLogFiles_Sort(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"});
    }
    public static String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length <= 1)
            return logs;

        Comparator<String> com = new Comparator<String>() {
            public int compare(String s1, String s2) {
                int s1si = s1.indexOf(' ');
                int s2si = s2.indexOf(' ');
                char s1fc = s1.charAt(s1si+1);
                char s2fc = s2.charAt(s2si+1);

                if (s1fc <= '9') {
                    if (s2fc <= '9')
                        return 0;
                    else
                        return 1;
                }
                if (s2fc <= '9') return -1;

                int preCompute = s1.substring(s1si+1).compareTo(s2.substring(s2si+1));
                if (preCompute == 0) return s1.substring(0,s1si).compareTo(s2.substring(0,s2si));
                return preCompute;
            }
        };

        Arrays.sort(logs);
        return logs;
    }


    public static String[] reorderLogFiles_Sort(String[] logs){
        Arrays.sort(logs, (log1, log2)->{
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2){
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });

        return logs;
    }
}
