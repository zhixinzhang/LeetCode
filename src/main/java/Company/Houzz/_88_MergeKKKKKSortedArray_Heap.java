package Company.Houzz;
import java.util.*;
/**
 * Created by zhang on 2018/1/21.
 * 构建一个长度是n*k的空数组。
 从k个数组中，取出每个数组的第一个元素，构建一个最小堆。
 把最小堆的根结点的元素放入结果中，并记下根结点元素来自哪个数组。
 删除最小堆的顶点元素。
 如果那个数组不空，从那个数组取下一个元素，放入堆中。
 维护最小堆。
 1. Create an output array of size n*k.
 2. Create a min heap of size k and insert 1st element in all the arrays into a the heap
 3. Repeat following steps n*k times.
 a) Get minimum element from heap (minimum is always at root) and store it in output array.
 b) Replace heap root with next element from the array from which the element is extracted.
 If the array doesn’t have any more elements, then replace root with infinite. After replacing the root, heapify the tree.
 *
 */
//O(nlog(n)).
public class _88_MergeKKKKKSortedArray_Heap {
    public static int[] mergeKSortedArray(int[][] arr) {
        class ArrayContainer implements Comparable<ArrayContainer> {
            int[] arr;
            int index;

            public ArrayContainer(int[] arr, int index) {
                this.arr = arr;
                this.index = index;
            }

            @Override
            public int compareTo(ArrayContainer o) {
                return this.arr[this.index] - o.arr[o.index];
            }
        }

        //PriorityQueue is heap in Java
        PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
        int total=0;

        //add arrays to heap
        for (int i = 0; i < arr.length; i++) {
            queue.add(new ArrayContainer(arr[i], 0));
            total = total + arr[i].length;
        }

        int m=0;
        int result[] = new int[total];

        //while heap is not empty
        while(!queue.isEmpty()){
            ArrayContainer ac = queue.poll();
            result[m++]=ac.arr[ac.index];

            if(ac.index < ac.arr.length-1){
                queue.add(new ArrayContainer(ac.arr, ac.index+1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(result));
    }
}
