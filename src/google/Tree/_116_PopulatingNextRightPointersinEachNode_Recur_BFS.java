package google.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 5/24/19
 * Time: 6:19 PM
 * Description:
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/294853/Java-solution-in-Chinese
 *
 * 重点是连接 如何连接孙子节点
 */



public class _116_PopulatingNextRightPointersinEachNode_Recur_BFS {
    class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

//        public Node(int _val, google.Tree.Node _left, google.Tree.Node _right, google.Tree.Node _next) {
//            val = _val;
//            left = _left;
//            right = _right;
//            next = _next;
//        }
    }

    //O（1） space
    public Node connect(Node root) {
        if(root == null) return null;
        connect(root.left);
        connect(root.right);
        recur(root.left, root.right);
        return root;
    }

    public void recur(Node left, Node right){
        if (left == null || right == null)
            return;
        left.next = right;
        recur(left.right, right.left);
    }

    //BFS
    Queue<Node> q = new LinkedList<>();
    public Node connect_BFS(Node root) {
        if(root == null)return root;
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0;i<size - 1;i++) {
                Node temp = q.poll();
                Node temp2 = q.peek();
                temp.next = temp2;
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            Node temp1 = q.poll();
            temp1.next = null;
            if(temp1.left != null) q.add(temp1.left);
            if(temp1.right != null) q.add(temp1.right);
        }
        return root;
    }
}
