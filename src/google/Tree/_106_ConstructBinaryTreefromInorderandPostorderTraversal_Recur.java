package google.Tree;
import java.util.HashMap;

/**
 * Created by zhang on 2018/6/10.
 inorder = [9,3,15,20,7]
 postorder = [9,15,7,20,3]
 */
public class _106_ConstructBinaryTreefromInorderandPostorderTraversal_Recur {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0 || postorder.length != inorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i<inorder.length; i++){
            hm.put(inorder[i],i);
        }
        return helper(hm,inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    private TreeNode helper(HashMap<Integer,Integer> hm, int[] inorder,int is,int ie, int[] postorder, int ps, int pe){

        if (ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        root.left = helper(hm,inorder,is,ri-1,postorder,ps, ps+ri-is-1);
        root.right = helper(hm,inorder,ri+1, ie, postorder, ps+ri-is, pe-1);
        return root;
    }
}
