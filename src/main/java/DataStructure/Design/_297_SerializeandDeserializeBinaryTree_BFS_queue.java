package DataStructure.Design;


import DataStructure.BinaryTree.TreeNode;

import java.util.*;

/**
 * Created by zhang on 2018/1/26.
 * 不能用三叙遍历，因为三叙遍历至少要两个
 */
public class _297_SerializeandDeserializeBinaryTree_BFS_queue {
    // Encodes a tree to a single string.
    public String serializeBFS(TreeNode root) {
        if(root == null){
            return "";
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }else{
                sb.append("#,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserializeBFS(String data) {
        if(data == null || "".equals(data)){
            return null;
        }
        String[] strArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!"#".equals(strArr[i])){
                TreeNode left = new TreeNode(Integer.parseInt(strArr[i]));
                node.left = left;
                queue.add(left);
            }
            i++;

            if(!"#".equals(strArr[i])){
                TreeNode right = new TreeNode(Integer.parseInt(strArr[i]));
                node.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }



    public String serialize_DFS(TreeNode root){
        if(root == null) return "";
        return recur(root, "");
    }
    public String recur(TreeNode root, String path){
        if(root == null){
            path += ",*";
            return path;
        }
        int val = root.val;
        path += "," + String.valueOf(val);
        recur(root.left, path);
        recur(root.right, path);
        return path;
    }

    public TreeNode deser(String path){
        String[] paths = path.split(",");
        return deRecur(paths, 0);
    }
    public TreeNode deRecur(String[] paths, int index){
        if (paths[index] == "#")
            return null;
        TreeNode curN = new TreeNode(Integer.valueOf(paths[index]));
        curN.left = deRecur(paths, index + 1);
        curN.right = deRecur(paths, index + 2);
        return curN;
    }


    // https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/discuss/190318/Serialize-and-Deserialize-Binary-and-N-ary-Tree-Summary

//    String NN="X";
//    String spliter=",";
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        StringBuilder sb=new StringBuilder();
//        buildString(root,sb);
//        return sb.toString();
//    }
//    private void buildString(TreeNode node, StringBuilder sb){
//        if(node==null){
//            sb.append(NN);
//            sb.append(spliter);
//        }else{
//            sb.append(node.val);
//            sb.append(spliter);
//            buildString(node.left,sb);
//            buildString(node.right,sb);
//        }
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        Deque<String> deque=new ArrayDeque<>(Arrays.asList(data.split(spliter)));
//        return buildTree(deque);
//
//    }
//
//    private TreeNode buildTree(Deque<String> deque){
//        String s=deque.removeFirst();
//        if(s.equals(NN)){
//            return null;
//        }else{
//            int val=Integer.valueOf(s);
//            TreeNode node=new TreeNode(val);
//            node.left=buildTree(deque);
//            node.right=buildTree(deque);
//            return node;
//        }
//    }

}
