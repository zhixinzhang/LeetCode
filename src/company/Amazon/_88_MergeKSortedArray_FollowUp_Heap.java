package company.Amazon;


import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/20/19
 * Time: 10:45 PM
 * Description:
 *
 * follow up 跟 281 很像
 */


public class _88_MergeKSortedArray_FollowUp_Heap {
    public static void main(String[] args){
//        sortK(new int[][]{{1,2,3,4}, {3,7,9,10}, {2,4,5,8}});
        sortK_Iterator(new int[][]{{1,2,3,4}, {3,7,9,10}, {2,4,5,8}});

    }
    public static List<Integer> sortK(int[][] nums){
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxSize = 0;
        int k = nums.length;
        for (int[] n : nums) maxSize = Math.max(maxSize, n.length);
        for (int i = 0; i < maxSize; i++){
            for (int[] n : nums){
                if (n.length <= maxSize){
                    pq.add(n[i]);
                    if (pq.size() > k){
                        ans.add(pq.poll());
                    }
                }
            }
        }
        while (!pq.isEmpty())
            ans.add(pq.poll());
        return ans;
    }

    // 如果 又一个input  array 有100Million 个数
    // 换成iterator
    public static List<Integer> sortK_Iterator(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<Iterator>  q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int[] n : nums){
            List<Integer> l = new ArrayList<>();
            for (int i : n)
                l.add(i);
            list.add(l);
        }
        int k = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (List<Integer> l : list){
            q.add(l.iterator());
        }
        while (!q.isEmpty()){
            Iterator it = q.poll();
            int val = (int)it.next();
            pq.add(val);
            if (pq.size() > k)
                ans.add(pq.poll());
            if(it.hasNext()) q.add(it);
        }
        while (!pq.isEmpty())
            ans.add(pq.poll());
        return ans;
    }
}
