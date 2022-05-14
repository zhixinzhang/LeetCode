package DataStructure.Array;

/**
 * Created by zhang on 2017/10/23.
 * Given a n x n matrix where each of the
 * rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 */
/**一个二维数组 他的每行 每一列都递增  求kth个最小的值 两种解法 用minHeap 或者二分法
 * */
public class _378_KthSmallestElementinaSortedMatrix_BS {

    public int kthSmallest(int[][] matrix, int k) {
        int matrixRowSize=matrix.length;
        int matrixColSize=matrix[0].length;
        int minVal = matrix[0][0];
        int maxVal = matrix[matrixRowSize-1][matrixColSize-1];
        int midVal = 0;
        int count = 0;

        while (minVal < maxVal){
            midVal = (maxVal + minVal)/2;
            for (int i = 0;i<matrixRowSize && matrix[i][0]<= midVal;i++){
                for (int j = 0; j< matrixColSize; j ++){
                    if (matrix[i][j] <= midVal){
                        count++;
                    }
                }
            }
            if (k < count){
                maxVal = midVal;
            }else{
                minVal = midVal + 1;
            }
            count = 0;
        }
        return minVal;
    }
}
