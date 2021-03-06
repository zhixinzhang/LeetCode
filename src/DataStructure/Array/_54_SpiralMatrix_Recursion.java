package DataStructure.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2017/10/10.
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */
/**用递归算法 每个递归里面 就是一个螺旋 左到右 上倒下 又到左 下到上
 * */
public class _54_SpiralMatrix_Recursion {
    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}
        };
        spiralOrder_Travel(matrix);
    }

    public static List<Integer> spiralOrder_Travel(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1, left = 0;
        int size = matrix.length * matrix[0].length;

        while(ans.size() < size){
            // go right
            for (int i = left; i <= right && ans.size() < size; i++){
                ans.add(matrix[top][i]);
            }
            top++;

            // go down
            for (int i = top; i <= bottom && ans.size() < size; i++){
                ans.add(matrix[i][right]);
            }
            right --;

            // go left
            for (int i = right; i >= left && ans.size() < size; i--){
                ans.add(matrix[bottom][i]);
            }
            bottom --;

            // go up
            for (int i = bottom; i >= top && ans.size() < size; i--){
                ans.add(matrix[i][left]);
            }
            left ++;
        }

        return ans;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0){
            return res;
        }
        if (matrix[0].length == 0 || matrix[0].length == 0){
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        onceSpiral(res, matrix,row,col,0);
        return res;

    }
    public void onceSpiral(List<Integer> res, int[][] matrix,int row,int col,int levelSpiral){
            if (row == 0 || col == 0){
                return;
            }
            if (row == 1){
                for (int i = levelSpiral; i < col + levelSpiral;i++){
                    res.add(matrix[levelSpiral][i]);
                }
                return;
            }
            if (col == 1){
                for (int i = levelSpiral; i < row + levelSpiral; i++){
                    res.add(matrix[i][levelSpiral]);
                }
            }
                //1. up row
        for(int i = levelSpiral; i < col - 1 + levelSpiral; i++) {
            res.add(matrix[levelSpiral][i]);
        }
        //2. right col
        for(int i = levelSpiral; i < row - 1 + levelSpiral; i++) {
            res.add(matrix[i][col - 1 + levelSpiral]);
        }
        //3. down row
        for(int i = col - 1 + levelSpiral; i > levelSpiral; i--) {
            res.add(matrix[row - 1 + levelSpiral][i]);
        }
        //4. left col
        for(int i = row - 1 + levelSpiral; i > levelSpiral; i--) {
            res.add(matrix[i][levelSpiral]);
        }

        //Next level
        onceSpiral(res, matrix, row - 2, col - 2, levelSpiral + 1);
    }
}
