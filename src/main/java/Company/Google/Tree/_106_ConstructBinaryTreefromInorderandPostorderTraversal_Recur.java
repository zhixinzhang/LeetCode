package Company.Google.Tree;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhang on 2020/4/20.
 inorder = [9,3,15,20,7]
 postorder = [9,15,7,20,3]
 */
public class _106_ConstructBinaryTreefromInorderandPostorderTraversal_Recur {
    int indx;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        indx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return dfs(postorder, 0, indx);
    }

    private TreeNode dfs(int[] postorder, int left, int right){
        if (left > right || indx < 0){
            return null;
        }

        int val = postorder[indx--];
        int curIndex = map.get(val);
        TreeNode root = new TreeNode(val);
        root.right = dfs(postorder, curIndex + 1, right);
        root.left = dfs(postorder, left, curIndex - 1);

        return root;
    }
}
