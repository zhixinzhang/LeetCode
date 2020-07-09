package XianQiao;

import DataStructure.BinaryTree.TreeNode;

/**
 * @Author: Xianqiao
 * @Date: 7/8/20 16:44
 */
public class _1379_FindACorrespondingNodeOfBinaryTreeInACloneOfThatTree_DFS {
    TreeNode ans = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return helper(original, cloned, target);
    }
    private TreeNode helper(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null && cloned == null) {
            return null;
        }
        if (original == target) {
            ans = cloned;
        }
        helper(original.left, cloned.left, target);
        helper(original.right, cloned.right, target);
        return ans;
    }
}
