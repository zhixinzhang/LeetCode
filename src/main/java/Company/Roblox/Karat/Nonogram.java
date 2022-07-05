package Company.Roblox.Karat;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 7/4/2022 7:39 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>  Part 2
 *      * A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid and has to
 *      * color it according to some instructions. Specifically, each cell can be either black or white, which we will
 *      * represent as 0 for black and 1 for white.
 *      *
 *      * +------------+
 *      * | 1  1  1  1 |
 *      * | 0  1  1  1 |
 *      * | 0  1  0  0 |
 *      * | 1  1  0  1 |
 *      * | 0  0  1  1 |
 *      * +------------+
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class Nonogram {

    public static boolean validateNonogram(int[][] matrix, int[][] rows, int[][] cols) {
        if (matrix == null || rows == null || cols == null || matrix.length == 0 || matrix[0].length == 0
                || rows.length != matrix.length || cols.length != matrix[0].length) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // check rows
        for (int i = 0; i < m; i++) {
            if (!isValid(Arrays.stream(matrix[i]).iterator(), rows[i])) {
                return false;
            }
        }
        // check columns
        for (int j = 0; j < n; j++) {
            if (!isValid(new ColumnIterator(matrix, j), cols[j])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(PrimitiveIterator.OfInt nums, int[] runs) {
        int curZeros = 0; // count of zeros in current run
        int runIdx = 0; // index of run in instruction array runs

        while (nums.hasNext()) {
            int num = nums.next();
            if (num == 1) {
                if (curZeros > 0) { // ending a run
                    if (runIdx >= runs.length || runs[runIdx] != curZeros) {
                        return false;
                    }
                    runIdx++;
                    curZeros = 0;
                }
            } else { // starting or extending a run
                curZeros++;
            }
        }
        // finishing last run
        if (curZeros > 0) {
            if (runIdx >= runs.length || runs[runIdx] != curZeros) {
                return false;
            }
            runIdx++;
        }

        return runIdx == runs.length; // check if all runs finished
    }

    static class ColumnIterator implements PrimitiveIterator.OfInt {
        private final int[][] matrix;
        private final int col;
        private int row;

        public ColumnIterator(int[][] matrix, int col) {
            this.matrix = matrix;
            this.col = col;
            this.row = 0;
        }

        @Override
        public int nextInt() {
            return matrix[row++][col];
        }

        @Override
        public boolean hasNext() {
            return row < matrix.length;
        }
    }

    public static void main(String[] args) {
        System.out.println("Test part 1");
        int[][] m = new int[][] {
                {1, 2, 3},
                {2, 3, 1},
                {3, 1, 2}
        };
        System.out.println(isValidMatrix(m)); // true
        m = new int[][] {
                {1, 2, 3},
                {2, 3, 1},
                {3, 2, 2}
        };
        System.out.println(isValidMatrix(m)); // false


        System.out.println("Test part 2");

        int[][] matrix1 = new int[][] {
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 1}
        };
        int[][]  rows1_1 = new int[][] {
                {},
                {1},
                {1, 2},
                {1},
                {2}
        };
        int[][] cols1_1 = new int[][] {
                {2, 1},
                {1},
                {2},
                {1}
        };

        int[][] rows1_2 = new int[][] {{}, {}, {1}, {1}, {1, 1}};
        int[][] cols1_2 = new int[][] {{2}, {1}, {2}, {1}};

        System.out.println(validateNonogram(matrix1, rows1_1, cols1_1)); // true
        System.out.println(validateNonogram(matrix1, rows1_2, cols1_2)); // false

        int[][] matrix2 = new int[][] {
                {1, 1},
                {0, 0},
                {0, 0},
                {1, 0}
        };
        int[][] rows2_1 = new int[][]{{}, {2}, {2}, {1}};
        int[][] cols2_1 = new int[][]{{1, 1}, {3}};
        System.out.println(validateNonogram(matrix2, rows2_1, cols2_1)); // false
    }

    public static boolean isValidMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                // check row
                int x = matrix[i][j];
                if (!rowSet.add(x) || x  < 1 || x > n) {
                    return false;
                }
                // check column
                int y = matrix[j][i];
                if (!colSet.add(y) || y < 1 || y > n) {
                    return false;
                }
            }
        }
        return true;
    }

}
