package DataStructure.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhang on 2017/10/23.
 * bst中找到第k个最小的值
 */
/*自己做的 accepted
*  recursion 跟 dfs 和 binary search tree的特性  左节点 小于根 小于右面节点
* 或者用stack inorder
*
* */
public class _230_KthSmallestElementinaBST {

    public int kthSmallest_stack(TreeNode root, int k) {
        if(root == null)    return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        stack.push(temp);
        while(!stack.isEmpty() || temp.left != null){
            // find smallest node
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            if(!stack.isEmpty()){
                temp = stack.pop();
                if(--k == 0){
                    return temp.val;
                }

                temp = temp.right;
            }
        }
        return 0;
    }


    private int count=0;
    private int result = -1;
    public int kthSmallest_recursion(TreeNode root, int k) {
        if(count<k && root.left != null){
            kthSmallest_recursion(root.left, k);
        }
        if(++count == k){
            result = root.val;
        }
        if(count<k && root.right != null){
            kthSmallest_recursion(root.right, k);
        }
        return result;
    }

    public static void main(String[] args){
        List<String> node = new ArrayList<>();
//        node.add("6");
//        node.add("4");
//        node.add("8");
//        node.add("3");
//        node.add("5");
//        node.add("7");
//        node.add("9");
//        node.add("1");
//        node.add(null);
        node.add("1");
        node.add(null);
        node.add("2");
        zzx_createBTree zz = new zzx_createBTree();
        TreeNode treeNode = zz.createTree(node);
//        int res = kthSmallest(treeNode,1);
        int a = 0;
    }

}
