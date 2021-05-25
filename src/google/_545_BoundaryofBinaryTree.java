package google;

import java.util.*;
/**
 * Created by zhang on 2018/5/29.
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary,
 * leaves, and right boundary in order without duplicate nodes.
 */
// 逆时针 anti-clockwise
public class _545_BoundaryofBinaryTree {

    List<Integer> nodes = new ArrayList<>(1000);
    public List<Integer> boundaryOfBinaryTree_Best(TreeNode root) {

        if(root == null) return nodes;

        nodes.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return nodes;
    }
    public void leftBoundary(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        nodes.add(root.val);
        if(root.left == null)
            leftBoundary(root.right);
        else
            leftBoundary(root.left);
    }

    public void rightBoundary(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)) return;
        if(root.right == null)
            rightBoundary(root.left);
        else
            rightBoundary(root.right);
        nodes.add(root.val); // add after child visit(reverse)
    }

    public void leaves(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }





    //直接找到所有的边
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> bound = new ArrayList<>();
        if (root == null) return bound;
        if (!(root.left == null && root.right == null)) {
            bound.add(root.val);
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        // find left node
        while (l!=null && !(l.left == null && l.right == null)){
            bound.add(l.val);
            if (l.left != null)
                l = l.left;
            else
                l = l.right;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || stack.size()!= 0){
            if (p != null){
                stack.add(p);
                if (p.left == null && p.right == null)
                    bound.add(p.val);
                p = p.left;
            }else{
                TreeNode tmp = stack.pollLast();
                p = tmp.right;
            }
        }
        List<Integer> right = new ArrayList<>();
        while (r != null && !(r.left == null && r.right == null)) {
            right.add(r.val);
            if (r.right != null) r = r.right;
            else r = r.left;
        }
        for (int i = right.size() - 1; i >= 0; i--) {
            bound.add(right.get(i));
        }
        return bound;
    }
}
