package google.Array;

import java.util.TreeSet;

/**
 * Created by zhang on 2018/8/6.
 */
public class _220_ContainsDuplicateIII_slidingwindow_twopointer_TreeSet {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 1 5  3  4  6   k ,t
        if(nums == null || nums.length < 2 || k < 1 || t < 0)
            return false;
        int i = 0, j = 1;
        while(i < nums.length - 1){
            if(i != j && Math.abs((long)nums[i] - nums[j]) <= t)
                return true;   // found one
            if(j-i == k || j == nums.length -1){  // maximum window size of k
                i++;    // shift the left boundary of the window
                if(t!=0)
                    j = i+1;  // update j
            }else{
                j++;
            }
        }
        return false;
    }


    // O(n*logk)
    public boolean containsNearbyAlmostDuplicate_TreeSet(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || k < 1 || t < 0)
            return false;
        TreeSet<Integer> treeSet = new TreeSet<>();
        int p = 0;
        for(int i = 0; i < nums.length; i++){
            Integer b = treeSet.ceiling(nums[i]);
            Integer s = treeSet.floor(nums[i]);
            if(b!=null && b - nums[i]<=t) return true;
            if(s!=null && nums[i] - s<=t) return true;

            // maintance k size treeSet
            if(treeSet.size()==k) treeSet.remove((long)nums[p++]);
            treeSet.add(nums[i]);
        }
        return false;
    }
//    public static boolean solu(int[] nums, int k, int t){
//        if (nums.length == 0 || nums == null)   return true;
//        TreeSet<DataStructure.Integer> tree = new TreeSet<>();
//        for (int i = 0; i<nums.length; i++){
//            DataStructure.Integer a = tree.ceiling(nums[i]);
//            DataStructure.Integer b = tree.floor(nums[i]);
//        }
//        return true;
//    }
    public static void main(String[] args){
//        solu(new int[]{1,2,3,1},3,0);
    }
}
