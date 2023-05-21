package Company.Attentive;

import java.util.*;

/**
 * Created by zhang on 2018/9/6.
 */
public class _56_MergeInterval_PQ__Sort_SweepLine {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public static void main(String[] args){
        List<Interval> intervals = new ArrayList<>();
        //1,3],[2,6],[8,10],[15,18]
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(4,5));
//        intervals.add(new Interval(2,6));
//        intervals.add(new Interval(9,10));
//        intervals.add(new Interval(15,18));
        merge_SweepLine(intervals);
    }

    //O(n * log (n)) + O(n)    O(n)
    public static List<Interval> merge_sort(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 1){
            res.add(intervals.get(0));
            return res;
        }
        // 这里特殊处理 start相同情况 end值大的排在前面 后面的就可以直接跳过了
        Collections.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                if (a.start == b.start)
                    return b.end - a.end;
                else
                    return a.start - b.start;
            }
        });

        res.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            Interval prev = res.get(res.size() - 1);
            if(cur.start == prev.start)
                continue;
            if(cur.start <= prev.end)
                res.set(res.size()-1, new Interval(prev.start, Math.max(cur.end,prev.end)));
            else
                res.add(cur);
        }
        return res;
    }

    public static List<Interval> merge_SweepLine(List<Interval> intervals){
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 1){
            res.add(intervals.get(0));
            return res;
        }
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);   // 1 4 2 8 15   ->  1 2 4 9 15
        Arrays.sort(end);     // 3 9 6 10 18  ->  3 6 8 10 18
        // build new Inter depend on our start and end
        for (int i = 1, j = 0; i < n;){
            int curLeft = start[i-1];
            while (start[i] <= end[j]){
                i++;j++;
                if (i == n)
                    break;
            }
            int curRight = end[j];
            res.add(new Interval(curLeft,curRight));
            i++;j++;
            if (i == n)
                res.add(new Interval(start[n-1],end[n-1]));
        }
        return res;
    }
}
