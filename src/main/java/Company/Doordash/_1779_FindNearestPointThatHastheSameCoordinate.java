package Company.Doordash;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 9/18/2022 10:49 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _1779_FindNearestPointThatHastheSameCoordinate {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1;
        for (int i = 0, smallest = Integer.MAX_VALUE; i < points.length; ++i) {
            int dx = x - points[i][0], dy = y - points[i][1];
            if (dx * dy == 0 && Math.abs(dy + dx) < smallest) {
                smallest = Math.abs(dx + dy);
                index = i;
            }
        }
        return index;
    }
}
