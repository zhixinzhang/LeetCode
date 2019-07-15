package DataStructure.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2017/10/14.
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 For example:
 Given the below binary tree and sum = 22,
 */
/**因为要返回 list里面的 所有路线 所以要记住路线
 * 用递归resursion
 *
 * */
public class _113_PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> curPath = new ArrayList<>();
        helper(res,curPath,sum,root);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> curPath,int sum,TreeNode root){
        if(root == null){
            return;
        }
        curPath.add(root.val);
        // right path
        //新建一个对象  深复制 不是浅复制 ！！！
        if(root.left == null && root.right == null && root.val == sum){
//            List<DataStructure.Integer> rightPath = new DataStructure.ArrayList<>();
//            rightPath = curPath;
            res.add(new ArrayList<>(curPath));
        }else{
            helper(res,curPath,sum-root.val,root.left);
            helper(res,curPath,sum-root.val,root.right);
        }

        curPath.remove(curPath.size()-1);
    }
}
