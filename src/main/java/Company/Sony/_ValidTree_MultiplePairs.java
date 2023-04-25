package Company.Sony;

import DataStructure.BinaryTree.TreeNode;

// https://www.1point3acres.com/bbs/thread-879046-1-1.html
// 真正的coding 题。输入是几个pair，每个pair（2个）里的node相当于连接的。问‍‌‌‌‌‍‌‌‍‍‌‌‍‌‌‍‌‍‌最后一共有几棵树，非常简单的union find题
public class _ValidTree_MultiplePairs {
    public static void main(String[] args){
        findValidTree(new TreeNode[][]{
            {new TreeNode(1), new TreeNode(2)},
            {new TreeNode(1), new TreeNode(2)},
            {new TreeNode(1), new TreeNode(2)},
            {new TreeNode(1), new TreeNode(2)},
            {new TreeNode(1), new TreeNode(2)},
            {new TreeNode(1), new TreeNode(2)},
            {new TreeNode(1), new TreeNode(2)},
            {new TreeNode(1), new TreeNode(2)}
        });
    }

    private static int findValidTree(TreeNode[][] nodes){


        return 0;
    }
    
}
