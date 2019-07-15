package DataStructure.Array;

import java.util.PriorityQueue;

/**
 * Created by zhang on 2017/10/23.
 * Given the height m and the length n of a m * n Multiplication Table,
 * and a positive integer k, you need to return the k-th smallest number in this table.
 */
/**multiplication table 九九乘法表  minheap 找到第k个最小的值  minheap 时间复杂度超时 58/68个case过了
 * 之后 尝试用二分法
 *  m = 3  n = 4
 *  1 2 3 4
 *  2 4 6 8
 *  3 6 9 12           m = 3 n = 4
 *  左上角 是1*1 右下角是 m * n
 *  m = 3 n = 3  k = 5
 *  1 2 3 4 5 6
 *  2 4 6 8 10 12
 *  3 6 9 12 15 18
 * */

public class _668_KthSmallestNumberinMultiplicationTable_minHeap {
    static int res = Integer.MIN_VALUE;
    public static int findKthNumber(int m, int n, int k) {
        if (m == 0 || n == 0){
            return res;
        }
        if (k == m * n)
            return m * n;
        helper(m,n,k);
        return res;
    }
    private static void helper(int m,int n,int k){
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        //puth first row in minHeap and search down
        for (int i = 1; i <= n;i++){
            minHeap.offer(new Node(1,i,i*1));
        }
        //x = m    y = n
        for (int j = 1;j < k;j++){
            Node curNode = minHeap.poll();
            System.out.println(curNode.x + " ----- " + curNode.y + "   value : " + curNode.val);
            int curM = curNode.x;
            if (curM == m){
                continue;
            }else{
                curM = curNode.x+1;
            }
            int curN = curNode.y;
            minHeap.offer(new Node(curM,curN,curM * curN));

        }
        res = minHeap.poll().val;
    }

    public static void main(String[] args){
        int m = 9895;
        int n = 28405;
        int k = 100787757;
        int a = findKthNumber(m,n,k);
    }
}
