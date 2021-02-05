package Company.uber;

import java.util.*;

/**
 * Created by zhang on 2018/9/19.
 */
class Stream{
    Deque<Integer> q = new LinkedList<>();
    public Stream(){}
    public void add(int val){
        q.addLast(val);
    }
}
public class _23_MergeKSortedLists_followUp {
    public static void main(String[] args){
        Stream s1 = new Stream();
        Stream s2 = new Stream();
        Stream s3 = new Stream();
        s1.q.add(1);
        s1.q.add(4);
        s1.q.add(5);

        s2.q.add(1);
        s2.q.add(3);
        s2.q.add(4);

        s3.q.add(2);
        s3.q.add(6);

        List<Stream> streams = new ArrayList<>();
        streams.add(s1);
        streams.add(s2);
        streams.add(s3);
        mergeByVal(streams);
        mergeByOrder(streams);
    }
    //O(n)
    public static List<Integer> mergeByOrder(List<Stream> streams){
        List<Integer> res = new ArrayList<>();
        boolean flag = true;
        while (flag){
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < streams.size(); i++){
                Stream cur = streams.get(i);
                if (cur.q.isEmpty())
                    continue;
                int curVal = cur.q.pollFirst();
                curLevel.add(curVal);
            }
            if (curLevel.size() == 0)
                break;
            res.addAll(curLevel);
        }
        return res;
    }


    //O(n * log k)
    public static List<Integer> mergeByVal(List<Stream> streams){
        List<Integer> res = new ArrayList<>();
        int n = streams.size();
        PriorityQueue<Deque<Integer>> minHeap = new PriorityQueue<>(new Comparator<Deque<Integer>>() {
            @Override
            public int compare(Deque<Integer> o1, Deque<Integer> o2) {
                return o1.peekFirst() - o2.peekFirst();
            }
        });
        for (int i = 0; i < streams.size(); i++){
            Stream cur = streams.get(i);
            minHeap.add(cur.q);
        }
        //
        while (!minHeap.isEmpty()){
            Deque<Integer> curQ = minHeap.poll();
            res.add(curQ.pollFirst());
            if (curQ.size()!=0)
                minHeap.add(curQ);
        }
        return res;
    }
}
