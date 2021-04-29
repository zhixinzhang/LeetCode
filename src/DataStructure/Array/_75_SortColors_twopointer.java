package DataStructure.Array;

/**
 * Created by zhang on 2018/1/26.
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * */
//我们先用两个指针，一个指向已经排好序的0的序列的后一个点，一个指向已经排好序的2的序列的前一个点
public class _75_SortColors_twopointer {
    // l as first element of 1 and right as first element 2
    public static void main(String[] args){
        sort_Colors(new int[]{1, 0, 2, 0, 1});
    }
    // 1 0 2 1
    public static void sort_Colors(int[] nums){
        int p0 = 0, p2 = nums.length - 1;
        int cur = 0;

        int temp;
        while (cur <= p2){
            if (nums[cur] == 0){
                temp = nums[p0];
                nums[p0++] = nums[cur];
                nums[cur++] = temp;
            } else if (nums[cur] == 2) {
                temp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2--] = temp;
            } else {
                cur++;
            }
        }

    }
    public static void swap(int[] nums, int left , int right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
    }

    public static void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        for (int i = l; i <= r; i++) {
            while (l <= i && i <= r && nums[i] != 1) {
                if (nums[i] == 0) {
                    int tmp = nums[i];
                    nums[i] = nums[l];
                    nums[l] = tmp;
                    l++;
                } else if (nums[i] == 2) {
                    int tmp = nums[i];
                    nums[i] = nums[r];
                    nums[r] = tmp;
                    r--;
                }
            }
        }
    }
}
