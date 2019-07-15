package DataStructure.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/25/19
 * Time: 5:20 PM
 * Description:
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=519035&page=1
 *            A
 *         /      \
 *      B           C
 *   /    \         /
 * D        E         F
 *           \
 *              G
 *

 *            A
 *         /      \
        D  E       C
 *          \         \
 *           G         F



 *
 * 输入: vector<TreeNode> tree = {{-1, 'A'}, {0, 'B'}, {0, 'C'}, {1, 'D'}, {1, 'E'}, {2, 'F'}, {4,'G'}}
 * 删除 B, 则返回的应该是
 * 输出: vector<TreeNode> tree = {{-1,'A'}, {0, 'D'}, {0, 'E'}, {0, 'C'}, {1, 'G'}, {3, 'C'}}
 */


public class DeleteTreeNode_DFS_BFS {
    static class TreeNode{
        int parent_index;
        char val;
        public TreeNode(int index, char c){
            this.parent_index = index;
            this.val = c;
        }
    }
    static HashMap<Integer, List<TreeNode>> bfs;
    static HashSet<Character> visited = new HashSet<>();
    public static List<TreeNode> deleteNode(List<TreeNode> nodes, TreeNode target){

        HashMap<Integer, Character> hm = new HashMap<>();
        bfs = new HashMap<>();
        HashSet<Character> cache = new HashSet<>();
        cache.add(target.val);
        // -1 A, 0 BC , 1 DE, 2 F , 3 GH
        for (int i = 0; i < nodes.size(); i++){
            hm.put(i,nodes.get(i).val);
            List<TreeNode> child = bfs.getOrDefault(nodes.get(i).parent_index, new ArrayList<>());
            child.add(nodes.get(i));
        }

        List<TreeNode> res = recursion(0, new ArrayList<TreeNode>(),nodes, cache, hm);
        return res;
    }
    public static List<TreeNode> recursion(int index, List<TreeNode> ans, List<TreeNode> nodes, HashSet<Character> cache, HashMap<Integer, Character> hm){
        if (index >= nodes.size()) return ans;
        if (visited.size() == nodes.size()) return ans;
        List<TreeNode> res;
        if (visited.contains(nodes.get(index).val))
            return res = recursion(index++, ans ,nodes, cache, hm);

        TreeNode curNode = nodes.get(index);
        if (!cache.contains(curNode.val)){
            ans.add(curNode);
            index++;
            res = recursion(index, ans ,nodes, cache, hm);
            return res;
        }else {
            List<TreeNode> child = bfs.get(index);
            for (TreeNode node : child){
                ans.add(new TreeNode(index, node.val));
                List<TreeNode> nextChild = bfs.get(node.val);
                for (TreeNode nn : nextChild){
                    cache.add(nn.val);
                }
            }
            index++;
            res = recursion(index, ans ,nodes, cache, hm);
        }
        return res;
    }

    public static void main(String[] args){
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(-1,'A'));
        list.add(new TreeNode(0,'B'));
        list.add(new TreeNode(0,'C'));
        list.add(new TreeNode(1,'D'));
        list.add(new TreeNode(1,'E'));
        list.add(new TreeNode(2,'F'));
        list.add(new TreeNode(3,'G'));
        list.add(new TreeNode(3,'H'));
        list.add(new TreeNode(4,'I'));
        deleteNode(list, new TreeNode(1,'B'));
    }

}
