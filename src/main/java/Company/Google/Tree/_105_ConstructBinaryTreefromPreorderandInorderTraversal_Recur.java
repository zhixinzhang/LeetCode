package google.Tree;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by zhang on 2021/4/22.
 */
public class _105_ConstructBinaryTreefromPreorderandInorderTraversal_Recur {

    int preorderIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right){
        if (left > right) {
            return null;
        }
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = build(preorder, left, map.get(rootValue) - 1);
        root.right = build(preorder, map.get(rootValue) + 1, right);

        return root;
    }
}
