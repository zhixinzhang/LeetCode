package DataStructure.Array;

/**
 * @author Luke(New Man) Zhang
 * @Date 2/1/2021 12:05 AM
 * <p>
 * Description:
 * Key Point:
 *
 * Three conditions could be merged to one:
 * The Person with age A can request person with age B if
 *
 * B is in range ( 0.5 * A + 7, A ]
 */

public class _825_FriendsOfAppropriateAges_Math {
    public int numFriendRequests(int[] ages) {
        int[] ageCount = new int[121];
        int[] ageSum = new int[121];
        for (int i = 0; i < ages.length; i++) {
            ageCount[ages[i]]++;
        }
        int sum = 0;
        int res = 0;
        for (int i = 15; i <= 120; i++) {
            sum += ageCount[i];
            ageSum[i] = sum;
            if (ageCount[i] > 0) {
                res += ((ageSum[i] - ageSum[(int)(i * .5 + 7)] - 1) * ageCount[i]);
            }
        }
        return res;
    }
}
