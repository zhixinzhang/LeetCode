package DataStructure.BinaryTree;

public class _538_ConvertBSTtoGreaterTree_recursion{
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        // return case 
        if(root == null)
            return null;
        convertBST(root.right);
        root.val = root.val + sum;
        sum = root.val;
        convertBST(root.left);
        
        return root;
    }

}