package google.Array;

import java.util.HashMap;

/**
 * Created by zhang on 2018/8/5.
 * 4. 有个array， 比如0，2， 3， 1. 从某个元素开始，比如2， 跳到index是2的位置，也就是3， 然后再跳到index为3的位置，也就是1.。。。给你n代表一共跳多少步，k代表起始位置，输出最终跳到的元素的值。
 * follow up，如果n远远大于array的长度，如何optimize
 */
public class NStepInArray {
    public static int lastValue(int[] array, int n, int k){
        // [0,2,3,1]
        if (array == null || array.length == 0 || n < 0) return 0;
        if (array[k] >= array.length) return -1;
        HashMap<Integer, Integer> cycle = new HashMap<>();
        int res = array[k];
        cycle.put(array[k],0);
        for (int i = 1; i < n; i++){
            res = array[res];
            if (res >= array.length)
                return -1;
            if (!cycle.containsKey(res))
                cycle.putIfAbsent(res,i);
            else{
                int len = i - cycle.get(res);
                int next = (n - i) % len;
                i = n - next;
            }
        }
        return res;
    }
    public static void main(String[] args){
        lastValue(new int[]{0,2,3,4,5,6,7,3},12,1);
    }
}
