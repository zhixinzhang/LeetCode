package DataStructure.Array;

/**
 * Created by zhang on 2017/11/8.
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 For example,
 Given n = 3, there are a total of 5 unique BST's.
 */
/*binary search tree  left < root < right
* DataStructure.DP + recursion   optima
* */
public class _96_UniqueBinarySearchTrees_DP {
    public static int numTrees(int n) {
        int res = 0;
        if (n <= 2)  // 1 , 2
            return n;
        int[] root = new int[n + 1];
        res = count(root,n);
        return res;
    }
    public static int count(int[] root, int n){
        if (n <= 1)
            return 1;
        if (root[n] != 0){
            return root[n];
        }
        int sum = 0;
        for (int i = 0;i <n;i++){
            sum += count(root,i) * count(root,n-i-1);
        }
        root[n] = sum;
        return sum;
    }
//    public int numTrees(int n) {
//        if (n <= 0) {
//            return 0;
//        }
//        int[] count = new int[n + 1];
//        count[0] = 1;
//
//        for (int i = 1; i <= n; i++) {
//            for(int j = 0; j < i; j++) {
//                count[i] += count[j] * count[i - j - 1];
//            }
//        }
//        return count[n];
//    }

    public static void main(String[] args){
        int c = numTrees(3);
        int a = 0;
    }
}
