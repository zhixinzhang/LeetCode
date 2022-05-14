package DataStructure.Array;

public class _755_PourWater{
	  public int[] pourWater(int[] heights, int V, int K) {
        //[2,1,1,2,1,2,2], V = 4, K = 3
        if(heights == null || heights.length == 0) return heights;
        String flag = "left";
        while(V-- > 0) droplet :{
            //first go left 
          for (int d = -1; d <= 1; d += 2) {
                int i = K, best = K;
                while (0 <= i+d && i+d < heights.length && heights[i+d] <= heights[i]) {
                    if (heights[i+d] < heights[i]) best = i + d;
                    i += d;
                }
                if (heights[best] < heights[K]) {
                    heights[best]++;
                    break droplet;
                }
            }
            heights[K]++;

        }
        
        return heights;
        
    }
}