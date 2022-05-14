package google.Array;

import java.util.PriorityQueue;

/**
 * Created by zhang on 2018/6/15.
 */
public class maxDistanceBus_PQ_FollowUp {
    //int[1 0 0 0 0 1 0 0 0 0 0 1]
    public static int solution(int[] bus){
        if (bus == null || bus.length == 1) return 0;
        //call freq
        //
        int max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((b,a)->((a[1]-a[0]) - (b[1]- b[0])));
        for (int left = 0,right = 0; right <bus.length;){
            //0 0 1 0 0 0 1
            if (left == 0 && bus[left] == 1){
                right++;
                while (bus[right] != 1){
                    right++;
                }
                pq.add(new int[]{-1*left,right});
            }else {
                while (right < bus.length && bus[right] != 1){
                    right++;
                }
                if (right == bus.length-1 && bus[right] == 0){
                    pq.add(new int[] {left,right-left+right});
                }else{
                    pq.add(new int[]{left,right});
                }
            }
            left = right;
            right++;
        }
        int[] res = pq.poll();
        if ((res[1] - res[0]) % 2 == 0){
            max = (res[1] - res[0]) / 2 - 1;
        }else{
            max = (res[1] - res[0])/2;
        }
        return max;
    }
    public static void main(String[] args){
        // left 0 right 2
        solution(new int[]{1,0,0,1,0,0,1});
        solution(new int[]{0,0,1,0,0,0,0,0,1,0,0,0,0});
    }
}
