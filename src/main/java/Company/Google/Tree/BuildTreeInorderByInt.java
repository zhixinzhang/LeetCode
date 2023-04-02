package Company.Google.Tree;
import java.util.Stack;

/**
 * Created by zhang on 2018/7/9.
 */
public class BuildTreeInorderByInt {
    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.left.left.right = new TreeNode(0);
        root.left.left.right.left = new TreeNode(0);
        root.left.left.right.right = new TreeNode(0);
//        solution_stack(new int[]{1,9,2,10,3,4,5,7,6},root);
        solution_PostOrder_stack(new int[]{9,10,2,1,4,3,8,7,5},root);
    }
    public static TreeNode solution_stack(int[] nums, TreeNode root){
        if (root == null || nums == null || nums.length == 0)
            return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int i = 0;
        TreeNode tmp = root;
        while (!stack.isEmpty() || tmp != null){
            if (tmp != null){
                stack.push(tmp);
                tmp = tmp.left;
            }else {
                TreeNode node = stack.pop();
                if (i == nums.length)   break;
                node.val = nums[i];
                tmp = node.right;
                i++;
            }
        }
        return root;
    }
    public static TreeNode solution_PreOrder_stack(int[] nums, TreeNode root){
        if (root == null || nums == null || nums.length == 0)
            return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int i = 0;
        TreeNode  p = root;
        while (!stack.isEmpty() || p != null){
            if (p != null){
                p.val = nums[i++];
                stack.push(p);
                p = p.left;
            }else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return root;
    }

    public static TreeNode solution_PostOrder_stack(int[] nums, TreeNode root){
        int i = nums.length - 1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null){
            if(p != null){
                p.val = nums[i--];
                stack.push(p);
                p = p.right;
            }else{
                TreeNode node = stack.pop();
                p = node.left;
            }
        }
        return root;
    }

}
