package DataStructure.Array;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/16/19
 * Time: 3:41 PM
 * Description:
 * https://leetcode.com/problems/boats-to-save-people/discuss/156855/6-lines-Java-O(nlogn)-code-sorting-%2B-greedy-with-greedy-algorithm-proof.
 *
 * if the 2 ends, people[lo] and people[hi], can fit in a boat, move the 2 ends;
 * otherwise move only the high end, and the low end stays.
 * In other words: always move the high end, but the low end depends on if it can cram into a boat with the high end.
 * repeat the above till the 2 ends meet.
 */


public class _881_BoatstoSavePeople_Sort_greedy {
    public static void main(String[] args){
        numRescueBoats(new int[]{5,1,4,2}, 6);
    }
    public static int numRescueBoats(int[] people, int limit) {
        if(people == null || people.length == 0)
            return 0;
        Arrays.sort(people);
        int ans = 0;
        for (int hi = people.length - 1, lo = 0; hi >= lo; --hi, ++ans) { // high end always moves
            if (people[lo] + people[hi] <= limit) { ++lo; } // low end moves only if it can fit in a boat with high end.
        }
        return ans;
    }
}
