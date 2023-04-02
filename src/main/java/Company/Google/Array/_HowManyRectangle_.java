package Company.Google.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhang on 2018/7/7.
 */
public class _HowManyRectangle_ {
    class pair{
        int start;
        int end;
    }
    public static void main(String[] args){
        int[] a = new int[]{1,1};
        int[] b = new int[]{1,3};
        int[] c = new int[]{1,5};
        int[] d = new int[]{2,3};
        int[] e = new int[]{2,5};
        List<int[]> left = new ArrayList<>();
        left.add(a);
        left.add(b);
        left.add(c);
        left.add(d);
        left.add(e);

        int[] a1 = new int[]{1,1};
        int[] b1 = new int[]{3,1};
        int[] c1 = new int[]{5,1};
        int[] d1 = new int[]{3,2};
        int[] e1 = new int[]{5,2};
        List<int[]> right = new ArrayList<>();
        right.add(a1);
        right.add(b1);
        right.add(c1);
        right.add(d1);
        right.add(e1);

        solution(left,right);
    }
    public static int solution(List<int[]> left, List<int[]> right){
        int res = 0;
        HashSet<int[]> hs = new HashSet<>();
        List<int[]> all = new ArrayList<>();
        for (int i = 0; i<left.size(); i++){
            hs.add(left.get(i));
            hs.add(right.get(i));
        }

        return res;
    }
}
