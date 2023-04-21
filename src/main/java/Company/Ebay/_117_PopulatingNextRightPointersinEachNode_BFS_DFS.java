package Company.Ebay;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Luke Zhang
 * @Date 2021-05-02 14:45
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37828/O(1)-space-O(n)-complexity-Iterative-Solution
 */
public class _117_PopulatingNextRightPointersinEachNode_BFS_DFS {
    class Node {
        int val;
        Node left;
        Node right;
        Node next;
      }

    public Node connect(Node root) {
        if (root == null) return root;

        Node left = root.left;
        Node right = root.right;
        Node nextChild = nextChild(root.next);

        if (left != null) {
            if (right != null) left.next = right;
            else left.next = nextChild;
        }

        if (right != null) right.next = nextChild;

        // connect from right to left
        connect(right);
        connect(left);

        return root;
    }

    private Node nextChild(Node node) {
        if (node == null) return node;
        if (node.left != null) return node.left;
        if (node.right != null) return node.right;

        return nextChild(node.next);
    }


    // BFS

    public Node connect_BFS(Node root) {
        if (root == null)
            return root;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            Node prev = q.poll();
            if (prev.left != null)
                q.add(prev.left);

            if (prev.right != null)
                q.add(prev.right);
            for (int i = 1; i < size; i++){
                Node node = q.poll();
                prev.next = node;
                prev = node;
                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }
        }


        return root;
    }
}
