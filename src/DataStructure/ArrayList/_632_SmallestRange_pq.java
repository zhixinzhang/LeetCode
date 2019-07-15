package DataStructure.ArrayList;
import java.util.*;
/**
 * Created by zhang on 2018/5/4.
 * 类似归并排序思想——多维有序数组问题考虑mergeSort+pq思想

 pq内每次poll出当前最小值，max保存当前已访问的最大值，当前pq中的所有值一定在这个区间内（满足该区间覆盖所有数组条件），
 只要看这个区间是否为更小的那个区间即可

 */
public class _632_SmallestRange_pq {
    public static int[] smallestRange(List<List<Integer>> nums) {
        int start = -1;
        int end = -1;
        int max = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;
        // 两种写法 都是返回maxheap
        PriorityQueue<Element> q = new PriorityQueue<>((a,b)->(a.val - b.val));
        PriorityQueue<Element> queue = new PriorityQueue(new Comparator<Element>() {
            public int compare(Element e1, Element e2) {
                return e1.val - e2.val;
            }
        });
        for (int i = 0; i < nums.size(); i++) {
            Element e = new Element(nums.get(i).get(0), 0, i);
            queue.offer(e);
            max = Math.max(max, e.val);
        }
        while (queue.size() == nums.size()) {
            Element e = queue.poll();
            if (max - e.val < range) {
                range = max - e.val;
                start = e.val;
                end = max;
            }
            if (e.index + 1 < nums.get(e.row).size()) {
                e.index = e.index + 1;
                e.val = nums.get(e.row).get(e.index);
                queue.offer(e);
                if (e.val > max) {
                    max = e.val;
                }
            }
        }
        return new int[]{start, end};
    }
    static class Element {
        int index;
        int row;
        int val;
        public Element(int val, int index, int row) {
            this.val = val;
            this.index = index;
            this.row = row;
        }
    }
    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        List<Integer> lll = new ArrayList<>();

        l.add(4);
        l.add(10);
        l.add(15);
        l.add(24);
        l.add(26);
        ll.add(0);
        ll.add(9);ll.add(12);ll.add(20);
        lll.add(5);lll.add(18);lll.add(22);lll.add(30);

        list.add(l);
        list.add(ll);
        list.add(lll);

        smallestRange(list);
    }
}
