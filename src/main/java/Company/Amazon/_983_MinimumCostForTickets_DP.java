package Company.Amazon;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 3/21/19
 * Time: 1:57 PM
 * Description:
 */


public class _983_MinimumCostForTickets_DP {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || costs == null || days.length == 0 || costs.length == 0)
            return 0;
        int[] minCosts = new int[366];
        boolean[] isDays = new boolean[366];
//        Arrays.fill(isDays, true);
        for(int day: days) isDays[day] = true;

        for(int i = 1; i <= 365; i++) {
            if(!isDays[i]) {
                minCosts[i] = minCosts[i - 1];
                continue;
            }
            int minCost;
            // case 1
            minCost = minCosts[i - 1] + costs[0];
            // case 2
            minCost = Math.min(minCost, minCosts[Math.max(0, i - 7)] + costs[1]);
            // case 3
            minCost = Math.min(minCost, minCosts[Math.max(0, i - 30)] + costs[2]);

            minCosts[i] = minCost;
        }

        return minCosts[365];
    }
}
