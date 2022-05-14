package DataStructure.ArrayList;
import java.util.*;



public class _554_BrickWall_HM{

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> data = new HashMap<>();  
        for (int i = 0; i < wall.size(); ++i) {  
            int sum = 0;  
            List<Integer> temp = wall.get(i);  
            for (int j = 0; j < temp.size() - 1; ++j) {  
                sum += temp.get(j);  
                if (data.containsKey(sum))  
                    data.put(sum, data.get(sum) + 1);  
                else  
                    data.put(sum, 1);  
            }  
        }  
        int max = 0;  
        for (int i : data.keySet())  
            max = Math.max(max, data.get(i));  
        return wall.size() - max;  
    }
}