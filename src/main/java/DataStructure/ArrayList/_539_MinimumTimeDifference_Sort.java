package DataStructure.ArrayList;
import java.util.*;


public class _539_MinimumTimeDifference_Sort{
	public int findMinDifference(List<String> timePoints) {
   int min = Integer.MAX_VALUE;  
        Collections.sort(timePoints,new Comparator<String>(){  
            @Override  
            public int compare(String o1, String o2) {  
                String[] time1 = o1.split(":");  
                String[] time2 = o2.split(":");  
                int result1 = Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);  
                int result2 = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);  
                return result1 - result2;  
            }  
  
        });  
        for(int i = 0; i < timePoints.size() - 1; i ++){  
            String[] time1 = timePoints.get(i).split(":");  
            String[] time2 = timePoints.get(i+1).split(":");  
            int result1 = Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);  
            int result2 = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);  
            if(min >= result2 - result1) min = result2 - result1;  
        }  
  
        String[] time1 = timePoints.get(0).split(":");  
        String[] time2 = timePoints.get(timePoints.size() - 1).split(":");  
        int result1 = Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);  
        int result2 = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);  
        if(min >= result2 - result1) min = result2 - result1;  
        if(min >= result1 + 24* 60 - result2) min = result1 + 24* 60 - result2;  
          
        return min;          
    }
}


    