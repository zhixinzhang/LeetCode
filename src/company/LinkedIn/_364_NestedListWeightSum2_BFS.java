package company.LinkedIn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Luke Zhang
 * @Date 2019-10-24 00:00
 */
public class _364_NestedListWeightSum2_BFS {
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        int prevSum = 0, totalSum = 0;
//        Queue<NestedInteger> queue = new LinkedList<>();
//        for (NestedInteger ni : nestedList) {
//            queue.add(ni);
//        }
//
//        while (!queue.isEmpty()) {
//            int size = queue.size(), levelSum = 0;
//            for (int i = 0; i < size; i++) {
//                NestedInteger current = queue.poll();
//                if (current.isInteger()) {
//                    levelSum += current.getInteger();
//                } else {
//                    for (NestedInteger ni: current.getList()) {
//                        queue.add(ni);
//                    }
//                }
//            }
//            prevSum += levelSum;
//            totalSum += prevSum;
//        }
//        return totalSum;
//    }
}
