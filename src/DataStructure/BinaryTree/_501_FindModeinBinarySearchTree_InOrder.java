package DataStructure.BinaryTree;
import java.util.*;

/**二叉搜索树的中序遍历的结果恰好是所有数的递增序列，根据中序遍历结果，对于当前遍历结点，标记maxCount为最大出现次数，tempCount为当前数字出现的次数，currentVal为当前保存的值。 
首先，tempCount++表示当前的数字出现次数+1，如果当前结点的值不等于保存的值，就更新currentVal的值，并且将tempCount标记为1。 
接下来，如果tempCount即当前数字出现的次数大于maxCount，就更新maxCount，并且将result数组清零，并将当前数字放入result数组中；如果tempCount只是等于maxCount，说明是出现次数一样的，则将当前数字直接放入result数组中。*/

public class _501_FindModeinBinarySearchTree_InOrder{
	Integer prev = null;
	int count = 1;
	int max = 0;
	public int[] findMode(TreeNode root){
		if(root == null) return new int[0];
		List<Integer> list = new ArrayList<>();
		traverse(root,list);
	     int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev)
                count++;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }

}