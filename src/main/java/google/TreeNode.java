package google;
import java.util.List;

/**
 * Created by zhang on 2017/2/7.
 */
public class TreeNode {
     // Definition for a binary tree node.
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    public TreeNode productTree(TreeNode treeNode, List<String> nodesList, int level){

        while (nodesList.size()>0){
            int val = Integer.parseInt(nodesList.get(0));
            TreeNode treeNode1 = new TreeNode(val);//1#23
        }
        return  treeNode;
    }
}
