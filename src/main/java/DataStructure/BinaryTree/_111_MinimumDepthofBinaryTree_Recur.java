package DataStructure.BinaryTree;



public class _111_MinimumDepthofBinaryTree_Recur{
//	    public int minDepth(TreeNode root) {
//		    if(root == null) return 0;
//	        int left = minDepth(root.left);
//	        int right = minDepth(root.right);
//	        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
//		}
		public static int minDepth(TreeNode root){
	    	if (root == null)
	    		return 0;
	    	int left = minDepth(root.left);
	    	int right = minDepth(root.right);
	    	int res = 0;
	    	if (left == 0 || right == 0)
	    		res = left + right + 1;
	    	else
	    		res = Math.min(left,right)+1;
	    	return res;
		}
}