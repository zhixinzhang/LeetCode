package DataStructure.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/7/19
 * Time: 2:18 PM
 * Description:
 */


public class _875_KokoEatingBananas_BS {
    public int minEatingSpeed(int[] piles, int H) {
        int min = 1, max = 0;
        for(int n : piles) max = Math.max(max, n);

        while (min < max) {
            int mid = ((max-min) >> 1) + min;
            if(canFinish(piles, mid, H)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean canFinish(int[] piles, int s, int H) {
        int sum = 0;
        for (int n : piles) {
            sum += (n + s - 1)/s;
            if(sum > H) return false;
        }
        return true;
    }
}
