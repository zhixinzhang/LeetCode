package DataStructure.BinaryTree;

/**
1、当前删除位置，用左边子树的最大值的节点替换 
2、或者是，用右边子树的最小值的节点替换
 node doesn't have left or right - return null
node only has left subtree- return the left subtree
node only has right subtree- return the right subtree
node has both left and right - find the minimum value in the right subtree, set that value to the currently found node, then recursively delete the minimum value in the right subtree
**/
public class _450_DeleteNodeinaBST{
public TreeNode deleteNode(TreeNode root, int key) {
    if(root == null){
        return null;
    }
    if(key < root.val){
        root.left = deleteNode(root.left, key);
    }else if(key > root.val){
        root.right = deleteNode(root.right, key);
    }else{
        if(root.left == null){
            return root.right;
        }else if(root.right == null){
            return root.left;
        }
        
        TreeNode minNode = findMin(root.right);
        root.val = minNode.val;
        root.right = deleteNode(root.right, root.val);
    }
    return root;
}

private TreeNode findMin(TreeNode node){
    while(node.left != null){
        node = node.left;
    }
    return node;
}


}