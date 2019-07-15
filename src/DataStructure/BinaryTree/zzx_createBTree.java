package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhang on 2017/10/13.
 */
public class zzx_createBTree {
    public TreeNode createTree(List<String> list){
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i = 1; i< list.size();i++){
            while (!q.isEmpty()){
                TreeNode curTreeNode = q.poll();
                int left = i;
                if (list.get(left) == null){
                    curTreeNode.left = null;
                }else{
                    curTreeNode.left = new TreeNode(Integer.valueOf(list.get(left)));
                }

                int right = ++i;
                if (list.get(right) == null){
                    curTreeNode.right = null;
                }else{
                    curTreeNode.right = new TreeNode(Integer.valueOf(list.get(right)));

                }
                q.add(curTreeNode.left);
                q.add(curTreeNode.right);

                if (!q.isEmpty()){
                    i++;
                }
                if (i >= list.size())
                    break;
            }
        }
        return root;
    }
}
