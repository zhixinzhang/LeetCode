package Company.PG;
import java.util.*;
//https://segmentfault.com/a/1190000005938045
/**
 * Created by zhang on 2018/1/28.
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 Example:
 Given binary tree

 1
 / \
 2   3
 / \
 4   5
 Returns [4, 5, 3], [2], [1].
 */
//O(N) 时间 O(N) 空间
/**这道题换句话说就是找每个node的index，这个index就是最后结果中这个节点所在的list的index，比如4,5,3的index是0， 2的index是1，1的index是2.
 怎么找呢？二分，看左，看右。
 确定一个点的index，得知道他的左孩子index是多少，右孩子的index是多少，当前这个点的index是他左右孩子的index最大值+1，这可以很容易地观察得到。比如对于1来说，
 左孩子2的index是1，右孩子3的index是0，那1的index肯定是max(1, 0) + 1，即2.
 * */
public class _366_FindLeavesofBinaryTree_DFS {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, root);
        return list;
    }

    //calculate the index of this root passed in and put it in that index, at last return where this root was put
    private int helper(List<List<Integer>> list, TreeNode root) {
        if (root == null)
            return -1;
        int left = helper(list, root.left);
        int right = helper(list, root.right);
        int cur = Math.max(left, right) + 1;
        if (list.size() == cur)
            list.add(new ArrayList<Integer>());
        list.get(cur).add(root.val);
        return cur;
    }
}
