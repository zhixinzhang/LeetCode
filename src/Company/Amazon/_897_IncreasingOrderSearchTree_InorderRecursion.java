package Company.Amazon;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/25/19
 * Time: 6:38 PM
 * Description:
 */


public class _897_IncreasingOrderSearchTree_InorderRecursion {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inorder(root,vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for(int v : vals){
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode root, List<Integer> vals){
        if(root == null) return;
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
}
