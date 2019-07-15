package DataStructure.BinaryTree;



/**
 * Created by zhang on 2017/2/11.
 */
public class FlattenBinaryToLinked114 {
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left!=null){
                TreeNode pre = root.left;
                while(pre.right!=null)
                    pre = pre.right;
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
