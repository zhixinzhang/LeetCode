package company.uber.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.HashMap;

/**
 * Created by zhang on 2018/9/18.
 * https://www.geeksforgeeks.org/construct-tree-inorder-level-order-traversals-set-2/
 */
public class BuildTreeOnInorderLevel {
    public static void main(String[] args){
        int[]  in  = new int[]{4, 8, 10, 12, 14, 20, 22};
        int[] level = {20, 8, 22, 4, 12, 10, 14};
        build(in,level);
    }
    static HashMap<Integer, Integer> idxMap = new HashMap<>();
    public static TreeNode build(int[] in, int[] level){
        for (int i = 0; i < in.length; i++){
            idxMap.putIfAbsent(in[i],i);
        }
        TreeNode root = new TreeNode(level[0]);     //20
        root.left = recur(in,level,1,0,idxMap.get(level[0])-1);
        root.right = recur(in,level,1,idxMap.get(level[0])+1,in.length-1);
        return root;
    }
    public static TreeNode recur(int[] in, int[] level, int valIdx,int left, int right){
        TreeNode root;
        if (left > right || left < 0 || right > in.length)
            return new TreeNode();
        // find
        int idxInOrder = 0;
        for (int i = valIdx; i < in.length; i++){
            int idx = idxMap.get(level[i]);         // index in inorder
            if (idx >= left && idx <= right){
                idxInOrder = idx;
                break;
            }
        }
        root = new TreeNode(in[idxInOrder]);
        int val = in[idxInOrder];
        root.left = recur(in,level,valIdx + 1,left,idxMap.get(val)-1);
        root.right = recur(in,level,valIdx+1,idxMap.get(val)+1,right);
        return root;
    }
}
