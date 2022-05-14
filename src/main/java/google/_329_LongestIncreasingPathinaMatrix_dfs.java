package google;
public class _329_LongestIncreasingPathinaMatrix_dfs {

// nums = [
//   [9,9,4],
//   [6,6,8],
//   [2,1,1]
// ]
// [1, 2, 6, 9].
//DFS to go through all nodes and use another array to cache all the visited node, incase we revisit again.
// reduce alot of unnecessnary operations. Time complixity is O(nm) 
	  public int longestIncreasingPath(int[][] matrix) {
	  	int max = 0, n = matrix.length, m = matrix[0].length;
	  	// create matrix to store visited node
	  	int[][] cache = new int[n][m]; 
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return max;
        }

        for(int i=0;i<matrix.length;i++){  
            for(int j=0;j<matrix[0].length;j++) {  
                max = Math.max(max, maxLen(matrix, Integer.MIN_VALUE, i, j, cache));  
            }  
        }  
        return max;  
    }

    private int maxLen(int[][] matrix, int min, int r, int c, int[][] cache){
    	//over boundary
    	if(r<0 || c<0 || r>=matrix.length || c>= matrix[0].length) {  
            return 0;  
        }
        //  3 2    not increase
        if (matrix[r][c] <= min) {
 			return 0;       	
        }
        if(cache[r][c] != 0) {  
            return cache[r][c];  
        }  
        //reset min value 
        min = matrix[r][c];

        // up, left , right , down  4 way

        int up = maxLen(matrix,min,r-1,c,cache)+1;
        int down = maxLen(matrix,min,r+1,c,cache)+1;
        int left = maxLen(matrix,min,r,c-1,cache)+1;
        int right = maxLen(matrix,min,r,c+1,cache)+1;

        cache[r][c] =  Math.max(right,Math.max(left,Math.max(up,down)));

        return cache[r][c];

    }
}