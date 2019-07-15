package DataStructure.BinaryTree;
import java.util.*;

public class _671_SecondMinimumNodeInaBinaryTree_PreOrder{
	public int findSecondMinimumValue(TreeNode root) {
  if (root == null){
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        preOrder(root, set);
        if (set.size() < 2){
            return -1;
        }             
        int index = 0;
        for (Integer num : set){
            if (index == 1){
                return num;
            }
            index++;
        }
        return -1;
    }
    private void preOrder(TreeNode head, Set<Integer> set){
        if (head == null){
            return;
        }
        set.add(head.val);
        preOrder(head.left, set);
        preOrder(head.right, set); 
    }

}