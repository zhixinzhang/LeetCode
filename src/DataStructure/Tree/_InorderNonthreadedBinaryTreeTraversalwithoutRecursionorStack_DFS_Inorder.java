package DataStructure.Tree;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://www.geeksforgeeks.org/inorder-non-threaded-binary-tree-traversal-without-recursion-or-stack/
 * Key Point:
 * We have discussed Thread based Morris Traversal. Can we do inorder traversal without threads if we have parent pointers available to us?
 *
 * 1. Initialize current node as root
 * 2. Initialize a flag: leftdone = false;
 * 3. Do following while root is not NULL
 *      a) If leftdone is false, set current node as leftmost
 *         child of node.
 *      b) Mark leftdone as true and print current node.
 *      c) If right child of current nodes exists, set current
 *         as right child and set leftdone as false.
 *      d) Else If parent exists, If current node is left child
 *         of its parent, set current node as parent.
 *         If current node is right child, keep moving to ancestors
 *         using parent pointer while current node is right child
 *         of its parent.
 *      e) Else break (We have reached back to root)
 */

public class _InorderNonthreadedBinaryTreeTraversalwithoutRecursionorStack_DFS_Inorder {

    class NodeWithParent {
        int value;
        NodeWithParent left, right, parent;

        public NodeWithParent (int value){
            this.value = value;
            left = right = parent = null;
        }
    }

    public List<NodeWithParent> inorder (NodeWithParent root){
        boolean leftDone = false;
        List<NodeWithParent> ans = new ArrayList<>();
        while (root != null) {
            if (!leftDone) {
                while (root.left != null) {
                    root = root.left;
                }
            }

            ans.add(root);
            leftDone = true;

            // If right child exists
            if (root.right != null) {
                leftDone = false;
                root = root.right;
            } else if (root.parent != null) {
                // If this node is right child of its parent,
                // visit parent's parent first
                while (root.parent != null && root == root.parent.right) {
                    root = root.parent;
                }

                if(root.parent == null) {
                    break;
                }
                root = root.parent;
            }else {
                break;
            }
        }

        return ans;
    }
}
