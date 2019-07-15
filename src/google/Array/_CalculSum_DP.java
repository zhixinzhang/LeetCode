package google.Array;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/25/19
 * Time: 7:07 PM
 * Description:
 * 我的做法，dp，inplace, 先累和第一行，再累和第一列，剩余一个嵌套的循环，每个新的值都是->上方的数+左方的数+自己原来的值-左上角的值. From 1point 3acres bbs
 */


public class _CalculSum_DP {
    public static void main(){

    }
    public void  calSum(int[][] nums){
        if(nums == null || nums.length == 0 || nums[0].length == 0)
            return;
        int n = nums.length, m = nums[0].length;
        for (int i = 1; i < m; i++){
            nums[0][i] += nums[0][i-1];
        }
        for (int i = 1; i < n; i++){
            nums[i][0] += nums[i-1][0];
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                nums[i][j] = nums[i-1][j] + nums[i][j-1] + nums[i][j] - nums[i-1][j-1];
            }
        }
        System.out.println(nums);
    }
}
