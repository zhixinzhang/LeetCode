package company.Amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/11/19
 * Time: 11:34 PM
 * Description:
 * https://leetcode.com/problems/rle-iterator/
 *
 * O（n）时间内解决不难  问题是如何O（1）空间内解决
 * 不用多余数据结构 找关系
 */


public class _900_RLEIterator {
    int index;
    int [] A;
//    Queue<DataStructure.Integer> q = new LinkedList<>();
    public _900_RLEIterator(int[] A) {
        this.A = A;
        index = 0;
//        for (int i = 0; i < A.length; i+=2){
//            int curV = A[i];
//            while (curV-- >= 0){
//                q.add(A[i+1]);
//            }
//        }

    }

    public int next(int n) {
        while(index < A.length && n > A[index]){
            n = n - A[index];
            index += 2;
        }

        if(index >= A.length){
            return -1;
        }

        A[index] = A[index] - n;
        return A[index + 1];
    }

//    public int next_(int n){
//
//    }


}
