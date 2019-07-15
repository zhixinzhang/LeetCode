package google.Tree;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/25/19
 * Time: 11:46 PM
 * Description:
 *
 *        9
 *     5     2
 *   2  1   0  0
 * 0  0   0
 *
 */


public class findNodeFromInorder_recur {
    static class Node{
        int val;
        char c;
        Node left;
        Node right;
        public Node(int val, char c){
            this.val = val;
            this.c = c;
        }
    }
    public static void main(String[] args){
        Node root = new Node(10, 'A');
        root.left = new Node(5, 'B');
        root.left.left = new Node(2, 'D');
        root.left.left.left = new Node(0, 'G');
        root.left.right = new Node(1, 'E');
        root.left.right.left = new Node(0, 'Z');

        root.right = new Node(3, 'c');
        root.right.right = new Node(2, 'F');
        root.right.right.left = new Node(0, 'K');
        root.right.right.right = new Node(0, 'H');

        Node ans = findK(root, 8);
        int c = 0;
    }
    public static Node findK(Node root, int k){
        if (root.left == null && k == 1)
            return root;
        if (root.left != null && root.left.val + 1 >= k)
            return findK(root.left, k);
        if (root.right != null){
            int left = root.left == null ? 0 : root.left.val + 1;
            return findK(root.right, k - 1 - left);
        }
        return root;
    }
}
