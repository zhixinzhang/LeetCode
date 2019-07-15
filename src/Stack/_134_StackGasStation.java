package Stack;
/**
 * Created by zhang on 2017/9/26.
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 You begin the journey with an empty tank at one of the gas stations.
 */
/**gas[3,5,6,8,4,5]
 * cost[1,2,4,5,8,9]
 * */

public class _134_StackGasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null){
            return -1;
        }
        if (gas.length < cost.length){
            return -1;
        }
        int start = gas.length -1;
        int end = 0;
        int sum = gas[start] - cost[start];

        while (end < start){
            //Case 1: sum < 0 --> a new start needed.
            if (sum < 0){
                sum += gas[--start] - cost[start];
            }else {
                sum += gas[end] - cost[end++];
            }
        }
        return  sum >= 0 ? start : -1;
    }
}
