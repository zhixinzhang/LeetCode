package DataStructure.ArrayList;
import java.util.*;

public class _120_Triangle_List_DP{

    public int minimumTotal(List<List<Integer>> triangle) {
        //dp[row][col] = Math.min(dp[row+1][col+1]+cur,dp[row+1][col]+cur);
        if(triangle.size() == 0) return 0;
        // for(int i = 0;i<triangle.size();i++){
        //     for(int j = 0; j<triangle.get(i).size();j++){
        //         int cur = triangle.get(i).get(j);
        //         triangle.get(i).set(j) = cur + Math.min(triangle.get(i+1).get(j+1),triangle.get(i+1).get(j));
        //     }
        // }
        
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
                // cur = triangle.get(i).get(j);
                // triangle.get(i).set(j, cur + Math.min( triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1) ));
        return triangle.get(0).get(0);        
    }


}