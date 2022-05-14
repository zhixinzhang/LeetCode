package google.Tree;

/**
 * Created by zhang on 2018/7/12.
 * 第二题是 字符串转为二叉树 输入是一个字符串
 一个数组 数组里存着加减乘除的顺序 可能是+- 可能是* - + /之类的.留学论坛-一亩-三分地

        比如给你个1 * 9 - 3 +2 *7

        让你转成

        +
        /  \ . visit 1point3acres for more.
        -     *
        /\    /\
        *  3  2  7
        /\
        1  9
        普通递归dfs大家都会.
 */
class OpeNode{
    char c;
    OpeNode left;
    OpeNode right;
    OpeNode(char c){
        this.c = c;
    }
}
public class DecodeStringOperationTree {
    public static void main(String[] args){
        String s = "1*9-3+2*7";
        buildTree(s);
    }
    public static OpeNode  buildTree(String s){
        char[] c = s.toCharArray();
        int n = c.length;
        int i = n - 1;
        OpeNode root = new OpeNode('@');
        recur(c,0,i,root.left);
        return root;
    }
    public static void recur(char[] c, int left, int right, OpeNode root){
        if (left > right)   return;
        if (right == 0) {
            root = new OpeNode(c[0]);
            return;
        }
        int i = right;
        int j = right;
        int l = Integer.MIN_VALUE;
        for (;  i>=0; i--){
            if (c[j] == '*' || c[j] =='/') l = Math.max(j,l);
            if (c[i] == '+' || c[i] == '-'){
                root = new OpeNode(c[i]);
                break;
            }
        }
        if (root == null){
            root = new OpeNode(c[l]);
            i = right - 1;
        }
        recur(c,0,i-1,root.left);
        recur(c,i+1,right - 1 ,root.right);
    }
}
