package Company.Google;

/**
 * Created by zhang on 2018/5/17.
 * Now we are using binary search to find the smallest possible value of D.
 I initilze left = 0 and right = the distance between the first and the last station
 count is the number of gas station we need to make it possible.
 if count > K, it means mid is too small to realize using only K more stations.
 if count <= K, it means mid is possible and we can continue to find a bigger one.
 When left + 1e-6 >= right, it means the answer within 10^-6 of the true value and it will be accepted.
 */
// mid 是距离值！
public class _774_MinimizeMaxDistancetoGasStation_BS {
    public static double minmaxGasDist(int[] stations, int K) {
        // BS
        int n = stations.length;
        double left = 0, right = stations[n-1] - stations[0], mid;
        if (stations == null) return left;
        while (left +1e-6 < right){
            mid = (left + right) / 2;
            int count = 0;
            // 1 2 3 4 5     k = 4  l = 0 r = 4 m = 2
            for (int i = 0; i< K -1; ++i){
                count += Math.ceil((stations[i+1] - stations[i]) / mid) - 1;
                int c = 0;
            }
            if (count > K) left = mid;
            else right = mid;
        }
        return right;
    }
    public static void main(String[] args){
        minmaxGasDist(new int[]{1,2,3,4,5}, 4);
    }
}
