package google.Tree;

/**
 * Created by zhang on 2018/6/13.
 * 重点是 根据complete的特点  2^h - 1
 * 另外好好看 recursion
 */
public class _222_CountCompleteTreeNodes_recursion {
    public int countNodes_TLE(TreeNode root){
        if (root == null) return 0;
        return countNodes_TLE(root.left)+countNodes_TLE(root.right)+1;
    }

    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        else {
            int left=getLeftHeight(root);
            int right=getRightHeight(root);
            if(left==right)
                return (1<<left)-1;
            //                return (int) Math.pow(2,left)-1;
            else {
                return countNodes(root.right)+countNodes(root.left)+1;
            }
        }
    }
    public int  getRightHeight(TreeNode root) {
        int height=0;
        while(root!=null)
        {
            height++;
            root=root.left;
        }
        return height;

    }

    public int  getLeftHeight(TreeNode root) {
        int height=0;
        while(root!=null)
        {
            height++;
            root=root.right;
        }
        return height;

    }
}
