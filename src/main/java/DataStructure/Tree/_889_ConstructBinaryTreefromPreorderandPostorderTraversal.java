package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/30/19
 * Time: 9:23 PM
 * Description:
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 *          1              1
 *      2
 *  4
 *
 *     5
 */


public class _889_ConstructBinaryTreefromPreorderandPostorderTraversal {
    HashMap<Integer, Integer> cache = new HashMap<>();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int len = post.length;
        for (int i = 0; i < post.length; i++)
            cache.put(post[i], i);
        return build(0, len - 1, 0, len - 1, pre, post);
    }

    private TreeNode build(int preLeft, int preRight, int postLeft, int postRight, int[] pre, int[] post) {
        if(preLeft > preRight || postLeft > postRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        if(preLeft + 1 <= preRight) {
            int index = cache.get(pre[preLeft + 1]);
            int sum = index - postLeft;
            root.left = build(preLeft + 1, preLeft + sum + 1, postLeft, postLeft + sum, pre, post);
            root.right = build(preLeft + sum + 2, preRight, postLeft + sum + 1, postRight - 1, pre, post);
        }

        return root;
    }
}
