package DataStructure.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2017/3/14.
 */
public class PasclTriangle118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for(int i = 1;i<numRows+1;i++){
//            int[] arr = new int[i];
            List tmp = paTriangle(cur,i,numRows);
            result.add(tmp);
            cur = tmp;
        }
        return  result;
    }
//1       1
//11      2
//121     3
//1331    4
//14641   5
    public  static  List<Integer> paTriangle(List<Integer> cur,int i,int numRows){
        if (cur.size() == 0){
            cur.add(1);

            return cur;
        }
        List<Integer> tmp = new ArrayList<>();
        for(int j = 0;j<i;j++){
            if (j==0 || j==i-1){
                tmp.add(1);

            }else{
                int tmpNum =cur.get(j-1) + cur.get(j);
                tmp.add(tmpNum);
            }
        }


        return tmp;
    }
    public  static  void  main(String args[]){
        generate(5);
    }
}
