package Company.FaceBook;

import javafx.util.Pair;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description:
 * Key Point: https://www.1point3acres.com/bbs/thread-448639-1-1.html
 * https://www.jianshu.com/p/e45b45592a21
 * https://sugarac.gitbooks.io/facebook-interview-handbook/content/fei-leetcode-ti/vector-dot-product.html
 */

public class sparseVectorDotProduct_Pairs_TwoPointer_BinarySearch {

    // O(n + m) time
    public void dotProduct(int[] A, int[] B){
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return;
        }
        List<Pair<Integer, Integer>> pairsOne = new ArrayList<>();
        List<Pair<Integer, Integer>> pairsTwo = new ArrayList<>();
        for (int i = 0; i < A.length; i++){
            if (A[i] != 0)
                pairsOne.add(new Pair(i, A[i]));
        }

        for (int i = 0; i < B.length; i++){
            if (B[i] != 0)
                pairsTwo.add(new Pair(i, B[i]));
        }

        int i = 0, j = 0, ans = 0;
        while (i < A.length && j < B.length){
            if (pairsOne.get(i).getKey() == pairsTwo.get(j).getKey()) {
                ans += pairsOne.get(i).getValue() * pairsTwo.get(j).getValue();
            } else if (pairsOne.get(i).getKey() < pairsTwo.get(j).getKey()){
                i++;
            } else {
                j++;
            }
        }
        System.out.println(ans);
    }

    // Follow up : 2.如果length(B) >>> length(A)，即B非常长，怎么做能减少时间复杂度。
    //
    //对A里面的每个数，用binary search找B中相对应的值，这样时间复杂度是O(mlogn) (m = len(A), n =len(B))

    // 优化：Binary Search on array B O(m log n); O(1)
    public int docProduct2(int[][] A, int[][] B) {
        int result = 0;
        for (int[] pair : A) { //O(m)
            int index = pair[0];
            int indexB = binarySearch(B, index); //O(log n)
            if (indexB != -1)
                result += pair[1] * B[indexB][1];
        }
        return result;
    }

    private int binarySearch(int[][] B, int index) {
        int l = 0, r = B.length - 1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (B[mid][0] >= index) //注意>=；原来写的是1，应该是0，第一个元素是index
                r = mid;
            else
                l = mid;
        }

        if (B[l][0] == index)
            return l;
        else if (B[r][0] == index)
            return r;
        return -1;
    }
}
