package Company.LinkedIn;

/**
 * @author Luke Zhang
 * @date 2019-10-23 00:28
 */
public class _339_NestedListWeightSum_DFS_BFS {
//    int sum = 0;
//    public int depthSum(List<NestedInteger> nestedList) {
//        helper(nestedList, 1);
//        return sum;
//    }
//
//    public void helper(List<NestedInteger> nestedList, int depth){
//        for(NestedInteger n : nestedList){
//            if(n.isInteger()){   // [1]
//                sum += depth * n.getInteger();
//            }else
//                helper(n.getList(), depth+1);
//        }
//    }


    // BFS

//    public int depthSum(List<NestedInteger> nestedList) {
//        Queue<NestedInteger> queue = new LinkedList<>();
//        queue.addAll(nestedList);
//
//        int depth = 1;
//        int total = 0;
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                NestedInteger nested = queue.poll();
//                if (nested.isInteger()) {
//                    total += nested.getInteger() * depth;
//                } else {
//                    queue.addAll(nested.getList());
//                }
//            }
//            depth++;
//        }
//        return total;
//    }
}
