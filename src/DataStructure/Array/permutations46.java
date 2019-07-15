package DataStructure.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2017/1/17.
 * [123]
 [1,2,3],   123
 [1,3,2],   213
 [2,1,3],   231
 [2,3,1],   132
 [3,1,2],
 [3,2,1]
 ]
 */
public class permutations46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> numList = new ArrayList<List<Integer>>();
        List<List<Integer>> curNumList = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            curList.add(nums[i]);
        }
        curNumList.add(curList);
        for (int i = 0;i<nums.length;i++){
            numList = helper(numList,curList,curNumList);
        }
//        Arrays.fi
        return numList;
    }

    //change the sort
    public static  List<List<Integer>> changeSort(List<List<Integer>> curNumList){
        List<List<Integer>> curLists = new ArrayList<>();
        for (int k = 0;k<curNumList.size();k++){
            for(int i = 1;i<curNumList.get(k).size();i++){
                int curLoc = 0;
                List<Integer> L1 = new ArrayList<>();
                L1.addAll(curNumList.get(k));
                int curLocNum = L1.get(curLoc);
                L1.set(curLoc,L1.get(i));
                L1.set(i,curLocNum);
                curLists.add(L1);
            }
        }
        return curLists;
    }

    public  static  List<List<Integer>>  helper(List<List<Integer>> numList,List<Integer> curList,List<List<Integer>> curNumList){
        if (!numList.contains(curList)){
            numList.add(curList);
        }
        curNumList = changeSort(curNumList);
        List<List<Integer>> tmpNumList = new ArrayList<List<Integer>>();
        for (List<Integer> c : curNumList){
            if (!numList.contains(c)){
                numList.add(c);
            }else{
                tmpNumList.add(c);
            }
        }
        curNumList.removeAll(tmpNumList);
        if (curNumList.size()!=0){
            numList = helper(numList,curList,curNumList);
        }
        return numList;
    }

    public  static  void  main(String[] args){
        int[] n = {1,2,3};
        List<List<Integer>> answer = permute(n);
        System.out.print("");
    }

}
