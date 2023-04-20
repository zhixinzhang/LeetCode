package DataStructure.Array;

/**
 * https://leetcode.com/problems/kth-smallest-subarray-sum/solutions/1310835/binary-search-sliding-window-java/
 * Brute Force: We need to find the kth smallest subarray, for that we can find the sum of all subarrays and then sort them and find the kth smallest. But this will take O(n^2) time since we are traversing each subarray.

Optimization: Instead of findting the kth smallest subarray , we can find the number of subarrays with sum<=S, this will take O(n) time using sliding window technique. And using binary search we can move the sum S according to the number of subarryays we find from the sliding window technique.
 * 
*/
public class _1918_KthSmallestSubarraySum_BinarySearch_SlidingWindow {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int sum=0;
        int n= nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int low=0, high=sum;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(count(nums,mid)<k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    public int count(int[] nums, int target){
        //count Subarrays with Sum less than target
        int start=0, end=0;
        int ans=0;
        int sum=0;
        while(end<nums.length){
            sum+=nums[end];
            end++;
            while(sum>target){
                sum-=nums[start];
                start++;
            }
            ans+=end-start;
        }
        return ans;
    }
}
