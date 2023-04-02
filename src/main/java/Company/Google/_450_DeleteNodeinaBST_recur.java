package Company.Google;


/**
 * Created by zhang on 2017/12/5.
 */
public class _450_DeleteNodeinaBST_recur {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (key<root.val){
            deleteNode(root.left,key);
        }else if(key > root.val){
            deleteNode(root.right,key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode minNode = findMin(root.right,key);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    public TreeNode findMin(TreeNode node, int key){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
