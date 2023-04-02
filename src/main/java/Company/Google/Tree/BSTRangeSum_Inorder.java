package Company.Google.Tree;


/**
 * Created by zhang on 2018/7/11.
 */
public class BSTRangeSum_Inorder {
    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(11);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(13);
        findRange(root, 5,10);
    }
    public static int findRange(TreeNode root, int low, int high){
        if(root == null)    return 0;
        int c =  helper(root,7,10);
        return c;
    }
    public static int helper(TreeNode root, int s, int h){
        if (root == null)   return 0;
        int count = 0;
        int v = root.val;
        if (v > s && v < h)
            count += (helper(root.left,s,h) +  helper(root.right,s,h) + v);
        else if(v < s)
            count += helper(root.right,s,h);
        else if(v > h)
            count += helper(root.left,s,h);
        else if(v == s)
            count += (helper(root.right,s,h) + v);
        else if (v == h)
            count += (helper(root.left,s,h) + v);

        return count;
    }
}
