package Company.Google;


//dfs or dp 
//dp mem where mem[i+1][j+1] means that S[0..j] contains T[0..i]
//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=306857&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%255B3089%255D%255Bvalue%255D%255B2%255D%3D2%26searchoption%255B3089%255D%255Btype%255D%3Dcheckbox%26searchoption%255B3046%255D%255Bvalue%255D%3D1%26searchoption%255B3046%255D%255Btype%255D%3Dradio&page=1
public class _115_DistinctSubsequences_DP{
	    public int numDistinct(String S, String T) {
	  // array creation
	    int[][] mem = new int[T.length()+1][S.length()+1];

	    // filling the first row: with 1s
	    for(int j=0; j<=S.length(); j++) {
	        mem[0][j] = 1;
	    }
	    
	    // the first column is 0 by default in every other rows but the first, which we need.
	    
	    for(int i=0; i<T.length(); i++) {
	        for(int j=0; j<S.length(); j++) {
	            if(T.charAt(i) == S.charAt(j)) {
	                mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
	            } else {
	                mem[i+1][j+1] = mem[i+1][j];
	            }
	        }
	    }
	    
	    return mem[T.length()][S.length()];
		}
}