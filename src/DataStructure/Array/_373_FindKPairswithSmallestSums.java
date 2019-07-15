package DataStructure.Array;
import java.util.*;
/**
 * Created by zhang on 2018/4/19.
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
 */
public class _373_FindKPairswithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<int[]>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return ret;
        }

        int[] index = new int[nums1.length];
        while (k-- > 0) {
            int min_val = Integer.MAX_VALUE;
            int in = -1;
            for (int i = 0; i < nums1.length; i++) {
                if (index[i] >= nums2.length) {
                    continue;
                }
                if (nums1[i] + nums2[index[i]] < min_val) {
                    min_val = nums1[i] + nums2[index[i]];
                    in = i;
                }
            }
            if (in == -1) {
                break;
            }
            int[] temp = {nums1[in], nums2[index[in]]};
            ret.add(temp);
            index[in]++;
        }
        return ret;
    }


    public static List<int[]> kSmallestPairs_mergeK(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }

    public static List<List<Integer>> kSmallestPairs_PQ(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                return b[0] + b[1] - a[0] - a[1];
            }
        });

        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                if(i >= nums1.length || j >= nums2.length) continue;
                pq.add(new int[]{nums1[i], nums2[j]});
                int a  = 0;
                if(pq.size() > k)
                    pq.poll();
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            List<Integer> res = new ArrayList<>();
            int[] n = pq.poll();
            res.add(n[0]);
            res.add(n[1]);
            ans.add(res);
        }
        return ans;
    }

    public static void main(String[] args){
        kSmallestPairs_PQ(new int[]{1,4,7,10}, new int[]{2,3,4,6,7}, 4);
    }
}
