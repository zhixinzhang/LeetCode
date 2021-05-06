package DataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;


// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
// perfect tree

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class _116_PopulatingNextRightPointersinEachNode_BFS_DFS {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i ++){
                Node node = q.poll();

                if (i < size - 1) {
                    node.next = q.peek();
                }

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return root;
    }


    public Node connect_Dfs(Node root) {
        if (root == null)
            return root;
        dfs(root.left, root.right);
        return root;
    }

    private void dfs(Node nodeLeft, Node nodeRight){
        if (nodeLeft == null || nodeRight == null)
            return;

        nodeLeft.next = nodeRight;
        dfs(nodeLeft.left, nodeLeft.right);
        dfs(nodeLeft.right, nodeRight.left);
        dfs(nodeRight.left, nodeRight.right);

    }
}