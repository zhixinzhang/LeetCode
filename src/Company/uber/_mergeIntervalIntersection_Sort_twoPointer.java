package Company.uber;

import java.util.*;

/**
 * Created by zhang on 2018/9/14.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=428489&ctid=201324
 */

//a = [[0, 2], [5, 10], [13, 23], [24, 25b = [[1, 5], [8, 12], [15, 18], [20, 24
//Expected output: [[1, 2], [5, 5], [8, 10], [15, 18], [20, 24]]
//[0,2][1,5][5,10][8,12][13,23][15,18][20,24][24,25]
public class _mergeIntervalIntersection_Sort_twoPointer {
    // [1  5]  [2  6]  [3  8]
    //[2 5] [3 8] -> [3  5]
    public static List<int[]>  mergeInter(List<int[]> a, List<int[]> b){
        a = sort(a);
        b = sort(b);
        List<int[]> res = new ArrayList<>();

        for (int i = 0, j = 0; i < a.size() && j < b.size();){
            int[] curA = b.get(i);
            int[] curB = b.get(j);
            if (curA[1] < curB[0]){             //no over lap[0 ,2] [3 5]
                i++;continue;
            }else if(curB[1] < curA[0] ){       //no over lap[3 5] [6 7]
                j++;continue;
            }
            if (curA[1] == curB[0]){            // special overlap
                i++;
                res.add(new int[]{curA[1],curA[1]});
            }else if (curA[0] == curB[1]){
                j++;
                res.add(new int[]{curA[0],curA[0]});
            }
            if (curA[1] > curB[0]){
                int[] cur = new int[]{curB[0],-1};
                if (curA[1] > curB[1]){
                    j++;
                    cur[1] = curB[1];
                    res.add(cur);
                }else {
                    i++;
                    cur[1] = curA[1];
                    res.add(cur);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        a.add(new int[]{0,2});
        a.add(new int[]{5,10});
        a.add(new int[]{13,23});
        a.add(new int[]{24,25});

        b.add(new int[]{1,5});
        b.add(new int[]{8,12});
        b.add(new int[]{15,18});
        b.add(new int[]{20,24});
        mergeInter(a,b);
    }

    public static List<int[]> sort(List<int[]> a){
        Collections.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> af = new ArrayList<>();
        for (int i = 0; i < a.size()-1; i++){
            int cur = a.get(i)[1];
            int next = a.get(i+1)[0];
            if ( cur + 1 == next){
                af.add(new int[]{a.get(i)[0], a.get(i+1)[1]});
            }else
                af.add(a.get(i));
        }
        return af;
    }
}
