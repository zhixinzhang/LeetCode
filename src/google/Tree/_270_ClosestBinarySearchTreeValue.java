package google.Tree;

/**
 * Created by zhang on 2018/7/15.
 */
public class _270_ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        if (root == null)   return 0;
        int ret = root.val;
        while (root != null){
            if(Math.abs(target - root.val) < Math.abs(target - ret)){
                ret = root.val;
            }
            root = root.val > target? root.left: root.right;
        }
        return ret;
    }
}
