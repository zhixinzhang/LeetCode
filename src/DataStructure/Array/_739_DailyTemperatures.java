package DataStructure.Array;


public class _739_DailyTemperatures{

	  public int[] dailyTemperatures(int[] temperatures) {
        // [73, 74, 75, 71, 69, 72, 76, 73]
        if(temperatures == null || temperatures.length == 0) return new int[1];
        int len = temperatures.length;
        int[] res = new int[len];
        int right = 0;
        for(int i = 0; i < len-1 ;i++){
           right = i+1;
            while(temperatures[right] <= temperatures[i] && right < len-1){
                right++;
            }
            if(temperatures[right] <= temperatures[i])
                res[i] = 0;
            else
                res[i] = right - i; 
                
        }
        return res;
    }
}