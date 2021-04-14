package Company.Tesla;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/12/2021 11:53 PM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class tt {
    public static void main(String[] args){
        solution(-515);
    }
    public static int solution(int N) {
        boolean flag = N >= 0 ? true : false;
        int val = Math.abs(N);
        String s = String.valueOf(val);
        StringBuilder sb = new StringBuilder(s);
        if (flag) {
            for (int i = 0; i < sb.length(); i++){
                if (sb.charAt(i) >= '5') {
                    continue;
                } else {
                    sb.insert(i, '5');
                    break;
                }
            }
        } else {
            for (int i = 0; i < sb.length(); i++){
                if (sb.charAt(i) <= '5') {
                    if (i == sb.length() - 1) {
                        sb.insert(i + 1, '5');
                        break;
                    }
                    continue;
                } else {
                    sb.insert(i, '5');
                    break;
                }
            }
        }
        String changed = sb.toString();
        return Integer.valueOf(changed);
    }
}
