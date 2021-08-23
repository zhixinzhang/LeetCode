package Company.LinkedIn;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/24/2021 1:25 AM
 * <p>
 * Source Link:
 * <p> https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii
 *
 * same question : https://leetcode.com/problems/intersection-of-two-linked-lists/solution/
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _1650_LowestCommonAncestorofABinaryTree3_TwoPointer {
//    public static TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
//        Node p1 = p, p2 = q;
//        while (p1 != p2) {
//            p1 = p1 == null ? q : p1.parent;
//            p2 = p2 == null ? p : p2.parent;
//        }
//        return p1;
//    }


//    public TreeNode lowestCommonAncestor(Node p, Node q) {
//        if (p == null || q == null)
//            throw new IllegalArgumentException("Invalid input as p and q are guaranteed to exist");
//
//        int pDepth = getDepth(p), qDepth = getDepth(q);
//
//        while (pDepth > qDepth) {
//            pDepth--;
//            p = p.parent;
//        }
//
//        while (qDepth > pDepth) {
//            qDepth--;
//            q = q.parent;
//        }
//
//        while (p != q) {
//            p = p.parent;
//            q = q.parent;
//        }
//
//        return p;
//    }
//
//    private int getDepth(Node a) {
//        int depth = 0;
//        while (a != null) {
//            a = a.parent;
//            depth++;
//        }
//        return depth;
//    }
}
