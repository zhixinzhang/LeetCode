package DataStructure.Array;

/**
 * If you had the two pictures in your hand, what's the most intuitive thing to do? Move them around until you get the most overlap. This is what the code does:

#Move the second image around starting from the bottom right corner to the top left hand corner
#For each move, see whats the overlap
#Return the highest value

and coming to your question , the inner loop takes care of the second image by trying to overlap it with the first image to get maximum overlap possible
 * 
*/
public class _835_ImageOverlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int res = 0;
        int N = img1.length;
        int[][] count = new int[N * 2][N * 2]; 
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                if(img1[i][j] == 0) continue;
  
                for(int m = 0; m < N; m ++) {
                    for(int n = 0; n < N; n ++) {
                        if(img2[m][n] == 0) continue;
                        res = Math.max(res, ++ count[N + i - m][N + j - n]);
                    }
                }
            }
        }
        return res; 
      }
}
