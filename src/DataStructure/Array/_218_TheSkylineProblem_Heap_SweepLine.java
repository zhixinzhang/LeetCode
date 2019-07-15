package DataStructure.Array;

import java.util.*;

/**
 * Created by zhang on 2018/3/25.
 * https://leetcode.com/problems/the-skyline-problem/description/
 * SweepLine 扫描线算法
 * https://www.cnblogs.com/TinyBobo/p/4592061.html
 * 最核心的思想：扫描到左边界的时候，将高度加入到大顶堆，cur的值去peek即为当前的最大值，当cur和pre不同的时候，将坐标加入结果队列即可，当为右边界时（高度为负值），证明该矩形已经到头，在堆中去掉其高度值，
 * 如果此时队列为空，则证明此处非连续，即此时应加入的高度为0，如果不为空，则更新相应当前最高即可。
 */

public class _218_TheSkylineProblem_Heap_SweepLine {
    //大顶推比较器
    public class MaxCom implements Comparator<Integer> {
        public int compare(Integer a, Integer b){
            return b - a ; // 大的在堆的顶端
        }
    }
    //数组比较器
    public class ArrayCom implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if(a[0] != b[0]) return a[0] - b[0];  //先按左边界进行排序
            return b[1] - a[1];  // 相等 则高的在前面
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new MaxCom());

        List<int[]> ver = new ArrayList<int[]>();  // 记录每一个竖线
        for(int i = 0 ; i < buildings.length ; i++){
            int[] temp = buildings[i];
            ver.add(new int[]{temp[0], temp[2]});  // 左边界竖线
            ver.add(new int[]{temp[1], -temp[2]});  // 右边界竖线 为了区分 存入负值
        }
        Collections.sort(ver, new ArrayCom());

        int cur = 0, pre = 0;
        for(int i = 0 ; i < ver.size() ; i++){
            int[] temp = ver.get(i);
            if(temp[1] > 0) {  // 左边界
                maxHeap.offer(temp[1]);  //高度入队
                cur = maxHeap.peek(); // 当前最高的
            }else { // 右边界
                maxHeap.remove(-temp[1]);  // 将对应的高度从堆中删除 这里就是右边存负值的方便之处
                cur = (maxHeap.peek() == null ? 0 : maxHeap.peek()); // 如果右边界是最后一个则高度为0，否则更新当前最高
            }
            if(cur != pre) {  // 与上一个最高的不相等
                res.add(new int[]{temp[0], cur});
                pre = cur;  // 保存当前高度为下一次的前面高度
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[][] buildings = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//                [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ];
//        getSkyline(buildings);
    }
}
