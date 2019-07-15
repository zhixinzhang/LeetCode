package DataStructure.Array;


public class _498_DiagonalTraverse{

	    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[r][c];
            if ((r + c) % 2 == 0) { // moving up
                if      (c == n - 1) { r++; }
                else if (r == 0)     { c++; }
                else            { r--; c++; }
            } else {                // moving down
                if      (r == m - 1) { c++; }
                else if (c == 0)     { r++; }
                else            { r++; c--; }
            }   
        }   
        return arr;
    }

        /**
         *       1 2 3 4
         *       5 6 7 8
         *       9 8 7 6
         *       [1 2 5 9 6 3 4 7 8 7 8 6]
         * **/
        public int[] soultion(int[][] matrix){
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
	            return null;
	        int m = matrix.length, n = matrix[0].length;
	        int[] res = new int[m*n];
	        res[0] = matrix[0][0];
	        res[1] = matrix[0][1];
	        char d = 'd'; //  u
            int[] curP = new int[]{0,1};
	        for (int i = 2; i < m*n; i++){
	            int x = 0;
	            int y = 0;
                if (d == 'd') {
                    x = curP[0] + 1;
                    y = curP[1] - 1;
                }else {
                    x = curP[0] - 1;
                    y = curP[1] + 1;
                }
                if (x >= 0 && x < m && y >=0 && y <n){
                    res[i] = matrix[x][y];
                    curP[0] = x;
                    curP[1] = y;
                }else{
                    d = d == 'd'?'u':'d';
                }
            }
            return res;
        }
}