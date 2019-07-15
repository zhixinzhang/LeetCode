package google.Design;

import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/6/18.
 * Java PriorityQueue Solution O(logN) for seat() O(N) for leave()
 * https://leetcode.com/problems/exam-room/discuss/
 */
public class _855_ExamRoom_PQ {
    int size;
    PriorityQueue<int[]> pq;
    public _855_ExamRoom_PQ(int N) {
        this.size = N;
        pq = new PriorityQueue<>((a,b)->{
            int distA = findDis(a);
            int distB = findDis(b);
            if (distA != distB){
                return distB - distA;
            }else
                return a[0] - b[0];
        });
        pq.add(new int[]{-1, N});
    }

    public int seat() {
        int res = 0;
        int[] interval = pq.poll();
        if (interval[0] == -1){
            res = 0;
        }else if (interval[1] == size){
            res = size - 1;
        }else {
            res = interval[0] + (interval[1] - interval[0]) / 2;
        }
        //update my pq
        pq.add(new int[]{interval[0], res});
        pq.add(new int[]{res, interval[1]});
        return  res;
    }

    public void leave(int p) {
        // 这么写不对  会Exception in thread "main" java.util.ConcurrentModificationException
        // 切记
        // 下面的对
        int left = -1;
        int right = -2;
        for (int[] inter : pq){
            if (inter[1] == p){
                left = inter[0];
                pq.remove(inter);
            }
            if (inter[0] == p){
                right = inter[1];
                pq.remove(inter);
            }
        }
        pq.add(new int[]{left,right});


        int[] leftInterval = null;
        int[] rightInterval = null;
        for (int[] interval : pq){
            if (interval[1] == p){
                leftInterval = interval;
            }
            if (interval[0] == p){
                rightInterval = interval;
            }
        }
        pq.remove(leftInterval);
        pq.remove(rightInterval);
        pq.add(new int[]{leftInterval[0],rightInterval[1]});
    }

    public int findDis(int[] interval){
        int dist = 0;
        if (interval[0] == -1) {
            dist = interval[1];
        } else if (interval[1] == size) {
            dist = size - 1 - interval[0];
        } else {
            dist = (interval[1] - interval[0]) / 2;
        }
        return dist;
    }
}
