package DataStructure.Array;

//
public class _566_ReshapetheMatrix{
	    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if(nums.length == 0 || nums.length * nums[0].length != r * c) return nums;
        int i = 0;
        for(int[] row: nums){
          for(int n: row){
            res[i / c][i % c] = n;
            i++;
          }
        }
        return res;
}
}