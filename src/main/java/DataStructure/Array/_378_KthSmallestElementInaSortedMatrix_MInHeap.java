package DataStructure.Array;

import java.util.PriorityQueue;

/**
 * Created by zhang on 2017/10/23.
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
 */
/**minHeap 的方法  求的是 第k个最小的值 二维数组里有 重复的值
 * 建立一个minheap  最小的值在根部 先把第一列都加入到minheap里 然后往下增加
 * 重点 如何建立一个minHeap
 * */
class Node implements Comparable<Node> {
    int x, y, val;
    public Node (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo (Node that) {
        return this.val - that.val;
    }
}

public class _378_KthSmallestElementInaSortedMatrix_MInHeap {

    public static int kthSmallest_MinHeap(int[][] matrix, int k) {
            if (matrix == null)
                return Integer.MIN_VALUE;
            int n = matrix.length;
            PriorityQueue<Node>  minHeap = new PriorityQueue<>();
            for(int j = 0; j<n; j++){
                System.out.println(matrix[0][j]);
                minHeap.offer(new Node(0,j,matrix[0][j]));
            }

        for(int i = 0; i < k - 1; i++) {
            Node t = minHeap.poll();
            System.out.println(t.val+"------");
            if(t.x == n-1) {
                continue;
            }
            System.out.println(matrix[t.x+1][t.y]+"****");
            System.out.println(t.x + "    " + t.y);
            minHeap.offer(new Node(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return minHeap.poll().val;
     }

     public static void main(String[] args){

        int[][] martix = new int[4][4];
        martix[0] = new int[]{0,0,2,3};
        martix[1] = new int[]{1, 1, 2,4};
        martix[2] = new int[]{2, 3, 3,5};
        martix[3] = new int[]{2, 3, 4,5};
//        int[] a = new int[] {1,2,3};

         kthSmallest_MinHeap(martix,16);

    }
}

