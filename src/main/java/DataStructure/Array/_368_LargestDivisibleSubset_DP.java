package DataStructure.Array;
import java.util.*;
/**
 * Created by zhang on 2018/4/19.
 */
/*
 * Process nums increasingly.
 * lens[i] denotes the max length of the subset constructed so far containing nums[i].
 * If nums[j] (j > i) is multiple of nums[i], then lens[j] = max(lens[j], lens[i] + 1)
 */
public class _368_LargestDivisibleSubset_DP {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, maxIdx = 0;
        List<Integer> ans = new LinkedList<>();
        if (n == 0) return ans;
        Arrays.sort(nums);
        int[] lens = new int[n], prevs = new int[n];
        Arrays.fill(prevs, -1);
        for (int i = 0; nums[i] <= nums[n-1]/2; ++i) {
            for (int j = i + 1, f = 2; nums[i] <= nums[n-1]/f; f = (nums[j] + nums[i] - 1)/nums[i]) {
                int idx = Arrays.binarySearch(nums, j, n, f*nums[i]);
                if (idx > 0 && lens[idx] <= lens[i]) {
                    prevs[idx] = i;
                    lens[idx] = lens[i] + 1;
                    if (lens[idx] > lens[maxIdx]) maxIdx = idx;
                }
                j = idx >= 0 ? idx + 1 : -(idx + 1);
                if (j >= n) break;
            }
        }
        for (int i = maxIdx; i >= 0; i = prevs[i]) ans.add(0, nums[i]);
        return ans;

    }
}
