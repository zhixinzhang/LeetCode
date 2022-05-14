package DataStructure.Tree;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/29/19
 * Time: 8:06 PM
 * Description:
 */


public class _894_AllPossibleFullBinaryTrees_Recursion {
    HashMap<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if(!memo.containsKey(N)){
            List<TreeNode> ans = new ArrayList<>();
            if(N == 1)
                ans.add(new TreeNode(0));
            else if(N % 2 == 1){
                for(int x = 0; x < N; x++){
                    int y = N - 1 - x;
                    for(TreeNode left : allPossibleFBT(x)){
                        for(TreeNode right : allPossibleFBT(y)){
                            TreeNode bs = new TreeNode(0);
                            bs.left = left;
                            bs.right = right;
                            ans.add(bs);
                        }
                    }
                }
            }
            memo.put(N, ans);
        }
        return memo.get(N);
    }

}
