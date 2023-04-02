package google.Tree;

/**
 * Created by zhang on 2018/7/31.
 */
class Node{
    Node left, right,parent;
    int val;
    public Node(int val){
        this.val = val;
    }
}
public class AllLeafSum {
    public static void main(String[] args){
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        int a = recur(root);
//        System.out.println(a);


        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.left.right = new Node(7);
        node.left.right = new Node(5);
        node.left.right.right = new Node(8);
        node.right = new Node(3);
        node.right.left = new Node(6);

        node.parent = null;
        node.left.parent = node;
        node.left.left.parent = node.left;
        node.left.left.right.parent = node.left.left;

        node.left.right.parent = node.left;
        node.left.right.right.parent = node.left.right;

        node.right.parent = node;
        node.right.left.parent = node.right;

        allSum(node);
    }
    public static int recur(TreeNode node){
        if (node == null) return 0;
        if (node.left == null && node.right == null)
            return node.val;
        int res = 0;
        if (node.left != null)
            res += recur(node.left);
        if (node.right != null)
            res += recur(node.right);
        return res;
    }

    public static int allSum(Node root){
        int res = 0;
        if (root == null)   return 0;
        Node prev = null;
        Node cur = root;
        while (cur != null){
            if (prev == cur.parent){
                prev = cur;
                if (cur.left != null){
                    cur = cur.left;
                }else if (cur.right != null){
                    cur = cur.right;
                }else{
                    res += cur.val;
                    cur = cur.parent;
                }
            }else if (prev == cur.left){
                cur = cur.right;
                if (cur!=null){
                    prev = cur;
                    if (cur.left != null){
                        cur = cur.left;
                    }else if (cur.right != null){
                        cur = cur.right;
                    }else{
                        res += cur.val;
                        cur = cur.parent;
                    }
                }
            }else if (prev == cur.right){
                prev = cur;
                cur = cur.parent;
            }
        }
        return res;
    }
}
