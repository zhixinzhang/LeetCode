package DataStructure.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhang on 2017/3/14
 * Given an index k, return the kth row of the Pascal's triangle.
 For example, given k = 3,
 Return [1,3,3,1]..
 Could you optimize your algorithm to use only O(k) extra space?
 */
//1       0
//11      1
//121     2
//1331    3
//14641   4
//1 5 10 5 1  5
//1 6 15 15 6 1 6
public class PascalTriangle119 {
    public List<Integer> getRow(int rowIndex) {
        Queue q = new LinkedList();
        List<Integer>  array = new ArrayList<>();
            for (int i =0;i<= rowIndex;i++){
                for (int j = i-1;j>0;j--){ 
                    array.set(j,array.get(j-1)+array.get(j));
                }
                array.add(1);
            }

        return  array;
    }

}
