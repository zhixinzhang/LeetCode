package DataStructure.BinaryTree;

import java.util.HashMap;

/**
 * Created by zhang on 2017/2/12.
 */
//用递归
public class ConstructBinaryTreefromPtoI105{
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1, map);
    }
    private static TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map)
    {
        if(preL>preR || inL>inR)
            return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int index = map.get(root.val);
        root.left = helper(preorder, preL+1, index-inL+preL, inorder, inL, index-1, map);
        root.right = helper(preorder, preL+index-inL+1, preR, inorder, index+1, inR,map);
        return root;
    }




    public static void main(String args){
            int[] preOrder = {1,2,4,5,3,0,7};
            int[] inOrder = {4,2,5,1,0,3,7,};
        buildTree(preOrder,inOrder);
        }
}
