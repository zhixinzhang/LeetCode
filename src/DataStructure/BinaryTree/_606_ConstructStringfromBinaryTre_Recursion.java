package DataStructure.BinaryTree;

public class _606_ConstructStringfromBinaryTre_Recursion{
	    public String tree2str(TreeNode t) {
        if(t == null) return "";
        String result = t.val + "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
         if (left == "" && right == "") return result;
        if (left == "") return result + "()" + "(" + right + ")";
        if (right == "") return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")"; 
    }
}