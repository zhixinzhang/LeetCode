package Company.Google.Array;

import java.util.*;

/**
 * Created by zhang on 2018/7/6.
 */
public class _56_MergeIntervals_Sort_PQ {
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

  public List<Interval> merge(List<Interval> intervals) {
    int n = intervals.size();
    int[] start = new int[n];
    int[] end = new int[n];
    for(int i = 0; i<n; i++){
        start[i] = intervals.get(i).start;
        end[i] = intervals.get(i).end;
    }
    Arrays.sort(start);
    Arrays.sort(end);
    // loop through
    List<Interval> res = new ArrayList<>();
    for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
        if (i == n - 1 || start[i + 1] > end[i]) {
            res.add(new Interval(start[j], end[i]));
            j = i + 1;
        }
    }
    return res;
}

    public static List<Interval> merge_sort(List<Interval> intervals) {
        LinkedList<Interval> res = new LinkedList<>();
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                if (a.start != b.start)
                    return a.start - b.start;
                else
                   return a.end - b.end;
            }
        });
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size();i++){
            Interval rigInter = intervals.get(i);
            Interval lefInter = res.get(res.size()-1);
            if (rigInter.start <= lefInter.end){
                res.removeLast();
                Interval n = new Interval(lefInter.start, rigInter.end);
                res.addLast(n);
            }else {
                res.add(rigInter);
            }
        }
        return res;
    }
    public static void main(String[] args){
        List<Interval> res = new ArrayList<>();
        res.add(new Interval(1,3));
        res.add(new Interval(2,6));
        res.add(new Interval(8,9));
        res.add(new Interval(11,15));
        merge_sort(res);

    }
}
