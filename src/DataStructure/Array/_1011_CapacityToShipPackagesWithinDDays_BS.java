package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/6/19
 * Time: 10:54 PM
 * Description:
 */


public class _1011_CapacityToShipPackagesWithinDDays_BS {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) / 2, need = 1, cur = 0;
            for (int w: weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if (need > D) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
