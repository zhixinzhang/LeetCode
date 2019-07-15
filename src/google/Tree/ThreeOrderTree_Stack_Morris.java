package google.Tree;
import java.util.*;
/**
 * Created by zhang on 2018/6/7.
 * lc 94 recursion stack Morris
 */
public class ThreeOrderTree_Stack_Morris {
    //[1,null,2,3]
    /**three recursion preorder inorder postorder**/
    List<Integer> res = new ArrayList<>();
    /**先序遍历**/
    public List<Integer> preOrder_recur(TreeNode root){
        if (root == null)   return res;
        preOrderRecur(root);
        return res;
    }
    public void preOrderRecur(TreeNode root){
        if (root == null) return;
        res.add(root.val);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }


    public List<Integer> preOrderTravel_stack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                res.add(p.val);  // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return res;
    }

    /**中序遍历**/
    public List<Integer> inorderTraversal_recur(TreeNode root){
        List<Integer> res = new ArrayList<>();
        recur_inOrder(root,res);
        return res;
    }
    public void recur_inOrder(TreeNode root,List<Integer> res){
        if (root == null)   return;
        recur_inOrder(root.left,res);
        res.add(root.val);
        recur_inOrder(root.right,res);
    }


    public List<Integer> inorderTraversal_stack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                p = node.right;
            }
        }
        return result;
    }
    public List<Integer> inorderTraversal_Morris(TreeNode root){
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode current = root;
        while (current != null){
            if (current.left == null){
                res.add(current.val);
                current = current.right;
            }else {
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current){
                    pre = pre.right;
                }
                if (pre.right == null){
                    pre.right = current;
                    current = current.left;
                }else { // left is already visited go right after visiting current
                    pre.right = null;
                    res.add(current.val);
                    current = current.right;
                }
            }
        }
        return res;
    }


    public List<Integer> preorderTraversal_Morris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null){
            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if (pre.right == cur){
                    pre.right = null;
                    cur = cur.right;
                }else {
                    res.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                }
            }
        }
        return res;
    }
/**
 * Create an empty stack, Push root node to the stack.
 Do following while stack is not empty.
 2.1. pop an item from the stack and print it.

 2.2. push the left child of popped item to stack.

 2.3. push the right child of popped item to stack.
 * **/

    public List<Integer> postorderTraversal_Stack(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        /**   stack     cur          res
         *     1        1
         *    26                      1
         *    6                       61
         *    34                       261
         *
         * */
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            ret.add(0,cur.val);
            if (cur.left != null){
                stack.push(cur.left);
            }
            if (cur.right != null)
                stack.push(cur.right);
        }
        return ret;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (!s.isEmpty() || p != null){
            if (p != null){
                s.push(p);
                result.addFirst(p.val);
                p = p.right;
            }else{
                TreeNode node = s.pop();
                p = node.left;
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal_recur(TreeNode root) {
        if(root == null) return res;
        recur(root);
        return res;
    }
    public void recur(TreeNode root){
        if(root == null)
            return;
        recur(root.left);
        recur(root.right);
        res.add(root.val);
    }

    int preIndex = 0;
    public TreeNode buildTreePreOrderPostOrder(int[] pre, int [] post, int size){
        if (pre == null || post == null) return new TreeNode(-1);
        return constrTree(pre, post,0, size-1, size);
    }

    public TreeNode constrTree(int[] pre, int[] post,int l, int h, int size){
        if (preIndex >= size || l > h)
            return null;
        TreeNode root = new TreeNode(pre[preIndex]);
        preIndex++;
        if (l == h || preIndex >= size)
            return root;
        int i;
        // Search the next element of pre[] in post[]
        for (i = l; i <= h; i++) {
            if (post[i] == pre[preIndex])
                break;
        }
        if (i <= h) {
            root.left = constrTree(pre, post, l, i, size);
            root.right = constrTree(pre, post, i + 1, h, size);
        }
        return root;
    }


}
