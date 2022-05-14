package DataStructure.Array;

/**
 * Created by zhang on 2017/12/23.
 */
public class _495_TeemoAttacking {

    public int findPoisonedDuration_leetcode(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) return 0;

        int result = 0, start = timeSeries[0], end = timeSeries[0] + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] > end) {
                result += end - start;
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration;
        }
        result += end - start;

        return result;

    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0 || duration == 0) return 0;
        // [1 3 4]  5
        int start = timeSeries[0];
        int count = 0;
        for(int i = 1; i < timeSeries.length;i++){
            if(timeSeries[i] - start < duration){
                count += timeSeries[i] - start;
            }else{
                count += duration;
            }
            start = timeSeries[i];
        }
        return count+duration-1;
    }

    public static void main(String[] args){
        findPoisonedDuration(new int[]{1,6,7,8},5);
    }
}
