package XianQiao;


import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Xianqiao
 * @Date: 7/7/20 22:31
 */
public class _589_Nary_Tree_Preorder_Traversal_DFS {
    LinkedList<Integer> list = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        return helper(root);
    }
    private LinkedList<Integer> helper(Node root) {
        //break condition
        if (root == null) {
            return list;
        }

        //operation
        list.add(root.val);

        //recursion
        for (Node child : root.children) {
            helper(child);
        }
        return list;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
