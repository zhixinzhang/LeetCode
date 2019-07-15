package company.PG;
/**
 *
 You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the
 one-to-one mapping relationship between the string and the original binary tree.
 * Input: Binary tree: [1,2,3,4]
            1                   (DataStructure.Tree 1 (Tree2 (DataStructure.Tree 4 null null) null) (DataStructure.Tree 3 (DataStructure.Tree null)(DataStructure.Tree 6 null null)))
        /             \
        2              3
    /
    4        null        null   6
 null 5

 Output: "1(2(4))(3)"           //out put is preorder
 * */
// preorder seq is root + left + right
public class _606_ConstructStringfromBinaryTree_DFS_Recursion {
    public static String tree2str(TreeNode root) {
        String res = "";
        if (root == null)
            res = "";
        String r = recursion(root);
        System.out.println(r);
        return "(" +r +")";
    }
    // preorder  root left right
    private static String recursion(TreeNode t){
        if(t == null) return "null";
        String result = t.val + "";
        String left = recursion(t.left);
        String right = recursion(t.right);
        if (left == "null" && right == "null")
            return "DataStructure " + result + " null" + " null";   // current node is leaf node
        if (left == "null")
            return "DataStructure " + result + " null " + "(" + right + ")"; // current node have right subTree
        if (right == "null")
            return "DataStructure " + result + " (" + left +")" + " null";
        return "DataStructure " + result + " (" + left + ")" + "(" + right + ")";
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        tree2str(root);
    }
}