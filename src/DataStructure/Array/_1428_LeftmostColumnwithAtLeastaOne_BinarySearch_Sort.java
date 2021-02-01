package DataStructure.Array;

/**
 * @author Luke(New Man) Zhang
 * @Date 1/31/2021 8:31 PM
 * <p>
 * Description:
 * Key Point:
 */

public class _1428_LeftmostColumnwithAtLeastaOne_BinarySearch_Sort {


    /**
     * Let NN be the number of rows, and MM be the number of columns.
     *
     * Time complexity : O(N + M)O(N+M).
     *
     * At each step, we're moving 1 step left or 1 step down. Therefore, we'll always finish looking at either one of the MM rows or NN columns. Therefore, we'll stay in the grid for at most N + MN+M steps, and therefore get a time complexity of O(N + M)O(N+M).
     *
     * Space complexity : O(1)O(1).
     *
     * We are using constant extra space.
     *
     * */
//    public int leftMostColumnWithOne_TopTOBot(BinaryMatrix binaryMatrix) {
//        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
//            int rows = binaryMatrix.dimensions().get(0);
//            int cols = binaryMatrix.dimensions().get(1);
//
//            // Set pointers to the top-right corner.
//            int currentRow = 0;
//            int currentCol = cols - 1;
//
//            // Repeat the search until it goes off the grid.
//            while (currentRow < rows && currentCol >= 0) {
//                if (binaryMatrix.get(currentRow, currentCol) == 0) {
//                    currentRow++;
//                } else {
//                    currentCol--;
//                }
//            }
//
//            // If we never left the last column, this is because it was all 0's.
//            return (currentCol == cols - 1) ? -1 : currentCol + 1;
//        }
//    }
    
    /**
     * This isn't the best approach, but it passes, and coding it up is a good opportunity to practice binary search.
     *
     * When linear search is too slow, we should try to find a way to use binary search. If you're not familiar
     * with binary search, check out this Explore Card!. We recommend doing the first couple of binary search questions to get familiar with the algorithm before coming back to this problem.
     *
     * Let NN be the number of rows, and MM be the number of columns.
     *
     * Time complexity : O(N \, \log \, M)O(NlogM).
     *
     * There are MM items in each row. Therefore, each binary search will have a cost of O(\log \, M)O(logM). We are performing NN of these binary searches, giving a time complexity of N \cdot O(\log \, M) = O(N \, \log \, M)N⋅O(logM)=O(NlogM).
     *
     * Space complexity : O(1)O(1).
     *
     * We are using constant extra space.
     * */
//    public int leftMostColumnWithOne_BinarySearch(BinaryMatrix binaryMatrix) {
//
//        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
//            int rows = binaryMatrix.dimensions().get(0);
//            int cols = binaryMatrix.dimensions().get(1);
//            int smallestIndex = cols;
//            for (int row = 0; row < rows; row++) {
//                // Binary Search for the first 1 in the row.
//                int lo = 0;
//                int hi = cols - 1;
//                while (lo < hi) {
//                    int mid = (lo + hi) / 2;
//                    if (binaryMatrix.get(row, mid) == 0) {
//                        lo = mid + 1;
//                    }
//                    else {
//                        hi = mid;
//                    }
//                }
//                // If the last element in the search space is a 1, then this row
//                // contained a 1.
//                if (binaryMatrix.get(row, lo) == 1) {
//                    smallestIndex = Math.min(smallestIndex, lo);
//                }
//            }
//            // If smallest_index is still set to cols, then there were no 1's in
//            // the grid.
//            return smallestIndex == cols ? -1 : smallestIndex;
//        }
//    }
}
