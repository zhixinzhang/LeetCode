package google.Design;

import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/8/6.
 */
class Pair{
    int dis,left,right;
    Pair(int dis, int left, int right){
        this.dis = dis;
        this.left = left;
        this.right = right;
    }
}
public class _855_ExamRoom_PQ_google {
    public static int[] haveSeats(int[] seats, int k){
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->(b.dis - a.dis));
        int i = -1, len;
        for (int j = 0; j < seats.length; j++){
            if (seats[j] == 1){
                if (i == -1){
                    len = j;
                    if (len == 0)
                        continue;
                    else {
                        len *= 2;
                        Pair p = new Pair(len,i,j);
                        maxHeap.add(p);
                    }
                }else {
                    len = j - i;
                    if (len == 0)
                        continue;
                    else {
                        Pair p = new Pair(len,i,j);
                        maxHeap.add(p);
                    }
                }
                i = j;
            }
        }
        int last = seats.length -1;
        i = i== -1 ? 0 : i;
        if (seats[last] == 0){
            if (i == 0)
                len = last * 2;
            else
                len = last - i;
            maxHeap.add(new Pair(len,i,last));
        }


        for (int j = 0; j < k; j++){
            Pair p = maxHeap.poll();
            int left = p.left, right = p.right, dis = p.dis;
            if (seats[left] == 1 && seats[right] == 1){
                int newLen = (right - left)/2;
                seats[left+newLen] = 1;
                Pair PL = new Pair(newLen,left, left+newLen);
                Pair PR = new Pair(newLen,left+newLen, right);
                maxHeap.add(PL);
                maxHeap.add(PR);
            }else if (seats[left] == 0 && seats[right] == 1){
                int newLen = right - left;
                seats[left] = 1;
                Pair PM = new Pair(newLen,left, right);
                maxHeap.add(PM);
            }else {
                int newLen = right - left;
                seats[right] = 1;
                Pair PM = new Pair(newLen,left, right);
                maxHeap.add(PM);
            }
        }
        return seats;
    }

    public static void main(String[] args){
        haveSeats(new int[]{0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0},5);
    }
}
