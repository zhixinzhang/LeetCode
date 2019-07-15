package DataStructure.BinaryTree;

/**
 * Created by zhang on 2017/2/12.
 */
//中 跟后序
public class ConstructBinTreeIntoPos106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode treeNode = new TreeNode(0);
        //find the rootNode
        int i = 0;
        for (;i<inorder.length;i++){
            if (inorder[i] == postorder[postorder.length-1]) break;
        }







        return  treeNode;
    }




}
