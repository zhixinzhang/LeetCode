package Company.PG;
import java.util.*;
/**
 * Created by zhang on 2018/1/27.
 */
public class _133_CloneGraph_recursion {
    class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };
    /**这道题的意思是完整复制一份图，实际上考察的是图的遍历方法，这道题主要使用BFS，然后先复制点，再复制边。旧图与新图之间使用一个map来做映射。而且新节点中的neibour都是要新创建出来的。
     * */
    public UndirectedGraphNode cloneGraph_bfs(UndirectedGraphNode node) {
        if(node==null)
            return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode,UndirectedGraphNode> maps = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        maps.put(node,newNode);
        queue.offer(node);

        while (!queue.isEmpty()){
            UndirectedGraphNode top = queue.poll();
            List<UndirectedGraphNode> neighbors = top.neighbors;

            for(UndirectedGraphNode neighbour:neighbors){
                if(!maps.containsKey(neighbour)){
                    UndirectedGraphNode newTmpNode = new UndirectedGraphNode(neighbour.label);
                    maps.put(neighbour,newTmpNode);
                    queue.offer(neighbour);
                }
                maps.get(top).neighbors.add(maps.get(neighbour));
            }
        }
        return newNode;
    }





    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph_recursion(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode nd = map.get(node);
        if (nd == null) {
            nd = new UndirectedGraphNode(node.label);
            map.put(node, nd);
            for (UndirectedGraphNode nei : node.neighbors) {
                nd.neighbors.add(cloneGraph_recursion(nei));
            }
        }
        return nd;
    }

}
