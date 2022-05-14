package google.Array;

/**
 * Created by zhang on 2018/6/27.
 * O(n) time
 */
public class _849_MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int j = -1, maxDist = 0;
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 1) {
                if (j != -1) {
                    maxDist = Math.max(maxDist, (i - j) / 2); //Get middle point between two taken seats
                }
                else {
                    maxDist = Math.max(maxDist, i - j - 1); //Get distance between index 0 to first taken seat, since j = -1, we need to make distance here -1 also.
                }
                j = i;
            }
            else if (i == seats.length - 1) {
                maxDist = Math.max(maxDist, i - j); //Get distance between last taken seat to index n - 1
            }
        }
        return maxDist;

    }
}
