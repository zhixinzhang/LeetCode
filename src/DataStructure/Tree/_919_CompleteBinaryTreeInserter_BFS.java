package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/29/19
 * Time: 7:25 PM
 * Description:
 */


public class _919_CompleteBinaryTreeInserter_BFS {
    TreeNode root;
    Queue<TreeNode> q;
    public _919_CompleteBinaryTreeInserter_BFS(TreeNode root) {
        this.root = root;
        q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.peek();
            if(temp.left==null)break;
            q.offer(temp.left);
            if(temp.right==null)break;
            q.offer(temp.right);
            q.poll();
        }
    }


    public int insert(int v) {
        TreeNode add = new TreeNode(v);
        TreeNode x = q.peek();
        if(x.left==null){
            x.left=add;
            q.offer(add);
            return x.val;
        }
        if(x.right==null){
            x.right=add;
            q.offer(add);
            q.poll();
            return x.val;
        }
        return x.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
