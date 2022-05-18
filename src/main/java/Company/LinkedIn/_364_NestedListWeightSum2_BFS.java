package Company.LinkedIn;

import java.util.*;

/**
 * @author Luke Zhang
 * @Date 2019-10-24 00:00
 *
 * https://www.cnblogs.com/grandyang/p/5615583.html
 *
 * 下面这个方法就比较巧妙了，由史蒂芬大神提出来的，这个方法用了两个变量 unweighted 和 weighted，非权重和跟权重和，初始化均为0，然后如果
 * nestedList 不为空开始循环，先声明一个空数组 nextLevel，遍历 nestedList 中的元素，如果是数字，则非权重和加上这个数字，如果是数组，就加入 nextLevel，
 * 这样遍历完成后，第一层的数字和保存在非权重和 unweighted 中了，其余元素都存入了 nextLevel 中，此时将 unweighted 加到 weighted 中，将 nextLevel
 * 赋给 nestedList，这样再进入下一层计算，由于上一层的值还在 unweighted 中，所以第二层计算完将 unweighted 加入 weighted 中时，相当于第一层的数字和被加了两次
 * ，这样就完美的符合要求了，这个思路又巧妙又牛B，大神就是大神啊，参见代码如下
 */


public class _364_NestedListWeightSum2_BFS {

    public int depthSumInverse_BFS(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) return 0;
        Queue<List<NestedInteger>> q = new LinkedList();
        int unweighted  = 0;
        int weighted  = 0;
        q.add(nestedList);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++){
                nestedList = q.poll();
                for (NestedInteger ni : nestedList) {
                    if (ni.isInteger())
                        unweighted += ni.getInteger();
                    else
                        q.add(ni.getList());
                }
            }
            weighted += unweighted; //add to sum after processing the whole layer
        }
        return weighted;
    }

    public int depthSumInverse_BFS_worst_solution(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) return 0;
        Queue<List<NestedInteger>> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        int deepest_Length = 0;
        int ans = 0;
        q.add(nestedList);
        while (!q.isEmpty()) {
            int sz = q.size();
            map.putIfAbsent(deepest_Length, new ArrayList<>());
            List<Integer> curLevel = new ArrayList<>();

            for (int i = 0; i < sz; i++){
                nestedList = q.poll();
                for (NestedInteger ni : nestedList) {
                    if (ni.isInteger())
                        curLevel.add(ni.getInteger());
                    else {
                        q.add(ni.getList());
                    }
                }
            }

            deepest_Length++;
        }

        for (int i = 0; i <= deepest_Length; i++){
            List<Integer> level = map.get(i);
            for (int v : level){
                ans += (deepest_Length - i + 1) * v;
            }
        }

        return ans;
    }
}
