package Company.Tesla;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/13/2021 12:46 AM
 * <p>
 * Description:
 * Similar task :
 * Key Point:
 */

public class cc {
    public static void main(String[] args){
        solution(6, 20);
    }
    public static int solution(int A, int B) {
        int s = 0;
        int l = Math.max(A, B);
        int mid = 0;
        while (s < l){
            mid = s + (l - s) / 2;
            long val = (long) mid * (mid + 1);
            if (val > B) {
                l = mid - 1;
            } else if (val <= A){
                s = mid + 1;
            } else {
                mid++;
                break;
            }
        }

        return solution_A(A, B, mid);
    }

    public static int solution_A(int A, int B, int mid) {
        int res = 0;
        int s = Math.min(A, B);
        int l = Math.max(A, B);
        for (int i = 0; i < mid; i++){
            long val = i * (i + 1);
            if (val > l || val < s) {
                continue;
            }
            res ++;
        }
        return res;
    }
}
