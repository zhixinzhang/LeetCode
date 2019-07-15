package google.Tree;

import java.util.HashMap;
import java.util.Map;
// https://articles.leetcode.com/construct-binary-tree-from-inorder-and-preorder-postorder-traversal/
/**
 * Created by zhang on 2018/6/10.
 */
public class _105_ConstructBinaryTreefromPreorderandInorderTraversal_Recur {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null ||inorder == null || preorder.length ==0 || inorder.length==0)
            return null;
        Map<Integer, Integer> indexes = new HashMap<>();
        for(int i =0; i<inorder.length; i++){
            indexes.put(inorder[i],i);
        }
        return helper(preorder,inorder,0, preorder.length-1, indexes,0);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int pstart,int pend,  Map<Integer, Integer> indexes, int iStart ){
        if(pstart>pend || iStart>= preorder.length)
            return null;
        int idx = indexes.get(preorder[iStart]);
        TreeNode root = new TreeNode(preorder[iStart]);
        root.left =  helper(preorder, inorder, pstart, idx-1, indexes, iStart+1);
        root.right = helper(preorder, inorder,  idx+1, pend, indexes, iStart+idx-pstart+1);
        return root;
    }
}
