package google.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2018/6/17.
 */
public class _162_FindPeakElement_BinarySearch {
        public int findPeakElement(int[] nums) {
            if(nums == null || nums.length <= 1) return 0;
            int left = 0;
            int right = nums.length-1;
            while (left < right){
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                    return mid;
                if (nums[mid] < nums[mid + 1]){
                    left = mid+1;
                }else {
                    right = mid;
                }
            }
            return (left == nums.length - 1 || nums[left] > nums[left + 1]) ? left:right;
        }


        // folow up find all peak
        public List<Integer> findAllPeak(int[] nums){
            if (nums == null || nums.length <= 1) return null;
            List<Integer> res = new ArrayList<>();
            // 1 2 2 2  2 不是peak
            for (int i = 0; i< nums.length; i++){
                if(i - 1 >=0 && i+1 <= nums.length-1){
                    if (nums[i+1] < nums[i] && nums[i] > nums[i-1]){
                        res.add(i);
                    }
                }
            }
            return res;
        }
    }
