package google.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/6/28.
 */
public class _257_BinaryTreePaths_Recursion {
    public List<String> binaryTreePath(TreeNode root){
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        recur(root,"",res);
        return res;
    }
    public void recur(TreeNode root, String path, List<String> res){
        if (root.left == null && root.right == null){
            path += root.val;
            res.add(path);
        }
        path += root.val + "->";
        if (root.left != null){
            recur(root.left, path, res);
        }
        if (root.right != null){
            recur(root.right, path,res);
        }
    }
}
