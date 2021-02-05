package Company.PG;

/**
 * Created by zhang on 2018/1/29.
 */
/**
 * 一个矩阵有0 和 1， 1的右边一定是1， 要找到整个矩阵最左边的1。 要求复杂度比O(mn) 好。 一开始naive了， 说每行binary search。 他问能不能更好。 才发现
 从右上角第一个1开始往左找， 遇到0 往下找下一个1， 直到不能走了为止。 复杂度O(m + n)*/
public class _01_matrix {
    public static void main(String[] args){
        int[][] mn = {{0,0,0,1,1},
                      {0,0,1,1,1},
                      {0,0,0,1,1},
                      {1,1,1,1,1},
                      {0,1,1,1,1}};
        int c = findLeft1(mn);
        int b = 0;
    }
    public static int findLeft1(int[][] mn){
        //  from right corner
        int res = mn[0].length;
//        int[] res = new int[mn.length];
        int right = mn[0].length-1;
        for (int i = 0; i<mn.length;i++){
            for (int j = right; j >= 0;){
                if (mn[i][j] == 0)
                    break;
                if (j == 0 && mn[i][j] == 1){
                    return 0;
                }
                if (j>=1 && mn[i][j] == 1 && mn[i][j-1] == 0){
                    res = Math.min(res,j);
                    right = j;
                    // index = 0;
                    break;
                }
                j--;
            }
        }
        return res;
    }
}
