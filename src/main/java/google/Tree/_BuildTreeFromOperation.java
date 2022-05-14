package google.Tree;

/**
 * Created by zhang on 2018/8/8.
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
public class _BuildTreeFromOperation {
   static class Node{
        char val;
        Node left, right;
        Node(char val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static Node build(String s){
        char[] arrc = s.toCharArray();
        Node root = dfs(arrc,0,s.length()-1);
        return root;
    }
    public static Node dfs(char[] arrc, int start, int end){
        if (start == end)
            return new Node(arrc[start]);
        int last = -1;
        for (int i = start; i<= end; i++){
            if (arrc[i] == '+' || arrc[i] == '-')
                last = i;
        }
        Node node;
        if (last != -1){
            node = new Node(arrc[last]);
            node.left = dfs(arrc, start,last-1);
            node.right = dfs(arrc, last+1, end);
        } else {
            int mid = start + (end - start) / 2;
            node = new Node(arrc[mid]);
            node.left = dfs(arrc, start,mid-1);
            node.right = dfs(arrc, mid+1, end);
        }
        return node;
    }
    public static void main(String[] args){
        build("1*9+2-4/3");
    }
}
