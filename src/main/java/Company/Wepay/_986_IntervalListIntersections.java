package Company.Wepay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/20/19
 * Time: 12:47 PM
 * Description:
 *
 * https://leetcode.com/problems/interval-list-intersections/
 */


 // Intution: Take two pinters i and j for traversing the two lists starting with 0. Now at any point if the start of any interval at i or j is less 
 // than or equal to end of corresponding interval at j or i then this can be intersection if its making valid interval i.e, end>=start.
public class _986_IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length==0 || secondList.length==0) return new int[0][0];
        int i = 0;
        int j = 0;
        int startMax = 0, endMin = 0;
        List<int[]> ans = new ArrayList<>();
        
        while(i<firstList.length && j<secondList.length){
            startMax = Math.max(firstList[i][0],secondList[j][0]);
            endMin = Math.min(firstList[i][1],secondList[j][1]);
            
			//you have end greater than start and you already know that this interval is sorrounded with startMin and endMax so this must be the intersection
			if(endMin>=startMax){           
                ans.add(new int[]{startMax,endMin});
            }
            
			//the interval with min end has been covered completely and have no chance to intersect with any other interval so move that list's pointer
            if(endMin == firstList[i][1]) i++;       
            if(endMin == secondList[j][1]) j++;
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}
